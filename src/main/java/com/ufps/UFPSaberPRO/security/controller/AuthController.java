package com.ufps.UFPSaberPRO.security.controller;

import javax.validation.Valid;

import com.ufps.UFPSaberPRO.security.service.*;
import com.ufps.UFPSaberPRO.serviceImpl.ProgramaServiceImpl;
import com.ufps.UFPSaberPRO.security.jwt.*;
import com.ufps.UFPSaberPRO.converter.ProgramaConverter;
import com.ufps.UFPSaberPRO.dto.DatogeneralDTO;
import com.ufps.UFPSaberPRO.dto.ProgramaDTO;
import com.ufps.UFPSaberPRO.security.dto.*;
import com.ufps.UFPSaberPRO.security.entity.*;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioService usuarioService;
    private final JwtProvider jwtProvider;
    
    @Autowired
	private ProgramaServiceImpl programaService;
    
	@Autowired
	private RoleService roleService;
	
	private DatogeneralDTO datogeneral;

    @Autowired
    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder, PasswordEncoder passwordEncoder,
            UsuarioService usuarioService, RoleService roleService, JwtProvider jwtProvider) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.passwordEncoder = passwordEncoder;
        this.usuarioService = usuarioService;
        this.jwtProvider = jwtProvider;
		this.datogeneral = new DatogeneralDTO();
    }
    
    @Operation(summary = "Obtiene los datos generales para el funcionamiento de registrarse de la aplicacion.")
    @GetMapping("/getDatos")
    public ResponseEntity<Object> getGeneral() {
		Map<String,Object> datos = new LinkedHashMap<>();
        try {
        	List<Rol> roles = roleService.getRoles();
        	List<ProgramaDTO> programas = programaService.getProgramas();
        	
        	datogeneral.setRoles(roles);
        	datogeneral.setProgramas(programas);
        	datos.put("error", null);
        	datos.put("message", "¡Proceso Exitoso!");
        	datos.put("general", datogeneral);
        	
        	return new ResponseEntity<Object>(datos, HttpStatus.OK);	
        	
        } catch (Exception e) {
        	datos.put("error", e.getMessage());
        	datos.put("message", "¡Oops!, Ha ocurrido un error al traer los datos generales.");
        	datos.put("general", null);
        	return new ResponseEntity<Object>(datos	, HttpStatus.INTERNAL_SERVER_ERROR);	
        }
    }

    @Operation(summary = "Se autentica al usuario, devolviendo una credencial.")
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginUser loginUser, BindingResult bidBindingResult) {
        Map<String, Object> rtn = new LinkedHashMap<>();
        if (bidBindingResult.hasErrors()) {
            rtn.put("error", bidBindingResult.getFieldError().getDefaultMessage());
            rtn.put("message", "Los campos estan incorrectos.");
            rtn.put("usuario", null);
            rtn.put("token", null);
            return new ResponseEntity<>(rtn, HttpStatus.BAD_REQUEST);
        }
        try {
            Usuario usuario = usuarioService.getByCodigo_Email(loginUser.getCodigo(),loginUser.getEmail());
            if(usuario!=null) {
            	UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword());
                Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtProvider.generateToken(authentication);
                JwtDTO jwtDto = new JwtDTO(jwt);
                usuario.setUsu_password("");
            	rtn.put("error", null);
                rtn.put("message", "¡Bienvenido(a)! "+ usuario.getUsu_nombre()+" "+usuario.getUsu_apellido());
                rtn.put("usuario", usuario);
                rtn.put("token", jwtDto.getToken());
                return new ResponseEntity<>(rtn, HttpStatus.OK);
            }else {
            	rtn.put("error", "Los datos son incorrectos.");
                rtn.put("message", "No se encontró ningún usuario con esos datos, intente nuevamente.");
            	rtn.put("usuario", null);
                rtn.put("token", null);
                return new ResponseEntity<>(rtn, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            rtn.put("error", e.getMessage());
            rtn.put("message", "No se encuentra registrado ningun usuario con esos datos.");
        	rtn.put("usuario", null);
            rtn.put("token", null);
            return new ResponseEntity<>(rtn, HttpStatus.BAD_GATEWAY);
        }
    }

    @Operation(summary = "Se registra un nuevo usuario.")
    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody UsuarioDTO nuevoUsuario, BindingResult bindingResult) {
        Map<String, Object> rtn = new LinkedHashMap<>();
    	try {
            if (bindingResult.hasErrors()) {
            	rtn.put("error", bindingResult.getFieldError().getDefaultMessage());
            	rtn.put("message", "¡Oops! Ha ocurrido un error con los datos ingresados.");
                return new ResponseEntity<>(rtn,HttpStatus.BAD_REQUEST);
            }
            Usuario user = new Usuario();
            user.setUsu_nombre(nuevoUsuario.getUsu_nombre());
            user.setUsu_apellido(nuevoUsuario.getUsu_apellido());
            user.setUsu_codigo(nuevoUsuario.getUsu_codigo());
            user.setUsu_email(nuevoUsuario.getUsu_email());
            user.setUsu_password(passwordEncoder.encode(nuevoUsuario.getUsu_password()));
            ProgramaDTO prg = programaService.buscarPorCodigo(nuevoUsuario.getCod_programa());
            user.setPrograma(new ProgramaConverter().converterToEntity(prg));
            user.setRol(new Rol(nuevoUsuario.getRol()));
            usuarioService.save(user);
            rtn.put("error", null);
        	rtn.put("message", "¡Éxito!, se ha registrado correctamente.");
            return new ResponseEntity<>(rtn,HttpStatus.CREATED);
        } catch (Exception e) {
            rtn.put("error", e.getMessage());
        	rtn.put("message", "¡Error!, no se pudo crear el usuario.");
            return new ResponseEntity<>(rtn,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @Operation(summary = "Se registra un nuevo usuario.")
    @PutMapping("/actualizarUsuario")
    public ResponseEntity<Object> actualizarUsuario(@Valid @RequestBody UsuarioDTO nuevoUsuario, BindingResult bindingResult) {
        Map<String, Object> rtn = new LinkedHashMap<>();
    	try {
            if (bindingResult.hasErrors()) {
            	rtn.put("error", bindingResult.getFieldError().getDefaultMessage());
            	rtn.put("message", "¡Oops! Ha ocurrido un error con los datos ingresados.");
                return new ResponseEntity<>(rtn,HttpStatus.BAD_REQUEST);
            }
            Usuario user = usuarioService.findUserById(nuevoUsuario.getId_usuario());
            user.setUsu_nombre(nuevoUsuario.getUsu_nombre());
            user.setUsu_apellido(nuevoUsuario.getUsu_apellido());
            user.setUsu_codigo(nuevoUsuario.getUsu_codigo());
            user.setUsu_email(nuevoUsuario.getUsu_email());
            if(nuevoUsuario.getUsu_password()!="" && nuevoUsuario.getUsu_password()!=null) {
                user.setUsu_password(passwordEncoder.encode(nuevoUsuario.getUsu_password()));
            }
            usuarioService.save(user);
            rtn.put("error", null);
        	rtn.put("message", "¡Éxito!, se ha actualizado correctamente.");
            return new ResponseEntity<>(rtn,HttpStatus.OK);
        } catch (Exception e) {
            rtn.put("error", e.getMessage());
        	rtn.put("message", "¡Error!, no se pudo actualizar el usuario.");
            return new ResponseEntity<>(rtn,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @Operation(summary = "Valida la autenticación de un usuario respeecto al token.")
    @PostMapping("/validateToken")
    public ResponseEntity<Boolean> validateToken(@RequestBody JwtDTO jwt) {
        try {
            String token = jwt.getToken();
            if (token != "" || token != null) {
                return new ResponseEntity<Boolean>(jwtProvider.validateToken(token), HttpStatus.OK);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.BAD_GATEWAY);
    }
}
