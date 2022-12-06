package com.ufps.UFPSaberPRO.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.UFPSaberPRO.dto.CategoriaDTO;
import com.ufps.UFPSaberPRO.dto.ConvocatoriaDTO;
import com.ufps.UFPSaberPRO.dto.DatogeneralDTO;
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.dto.ProgramaDTO;
import com.ufps.UFPSaberPRO.dto.SimulacroDTO;
import com.ufps.UFPSaberPRO.dto.SubcatergoriaDTO;
import com.ufps.UFPSaberPRO.security.dto.UsuarioDTO;
import com.ufps.UFPSaberPRO.security.entity.Rol;
import com.ufps.UFPSaberPRO.security.entity.Usuario;
import com.ufps.UFPSaberPRO.security.service.RoleService;
import com.ufps.UFPSaberPRO.security.service.UsuarioService;
import com.ufps.UFPSaberPRO.serviceImpl.CategoriaServiceImpl;
import com.ufps.UFPSaberPRO.serviceImpl.ConvocatoriaServiceImpl;
import com.ufps.UFPSaberPRO.serviceImpl.PreguntaServiceImpl;
import com.ufps.UFPSaberPRO.serviceImpl.ProgramaServiceImpl;
import com.ufps.UFPSaberPRO.serviceImpl.SimulacroServiceImpl;
import com.ufps.UFPSaberPRO.serviceImpl.SubcategoriaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/general")
public class GeneralRestController {
	
	@Autowired
	private CategoriaServiceImpl categoriaService;
	
	@Autowired
	private SubcategoriaServiceImpl subcategoriaService;
	
	@Autowired
	private ConvocatoriaServiceImpl convocatoriaService;
	
	@Autowired
	private SimulacroServiceImpl simulacroService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PreguntaServiceImpl preguntaService;
		
	private DatogeneralDTO datogeneral;
	
	public GeneralRestController() {
		datogeneral = new DatogeneralDTO();
	}
    
	@Operation(summary = "Obtiene los datos generales para el funcionamiento de la aplicación.")
    @GetMapping("/getDatos")
    public ResponseEntity<Object> getGeneral(@RequestParam String id_usuario, @RequestParam String id_programa) {
 		Map<String,Object> datos = new LinkedHashMap<>();
		Long id_user = Long.parseLong(id_usuario);
		Long id_prg = Long.parseLong(id_programa);
        try {
        	Usuario usuario = usuarioService.findUserById(id_user);
        	if(usuario.getRol().getRol_nombre().equals("ROLE_ADMINISTRADOR")) {
            	List<ConvocatoriaDTO> convocatorias = convocatoriaService.getConvocatoriasByUsuPrg(id_user, id_prg);
            	List<SimulacroDTO> simulacros = simulacroService.getSimulacrosUsuPrg(id_user, id_prg);
            	List<CategoriaDTO> categorias = categoriaService.getCategoriasByUsuPrg(id_user, id_prg);
            	List<SubcatergoriaDTO> subconvocatorias = subcategoriaService.getSubcategoriasByUsuPrg(id_user, id_prg);
            	List<UsuarioDTO> usuarios_programa = usuarioService.getAllByUsuPrg(id_user, id_prg);
            	List<PreguntaDTO> preguntas_programa = preguntaService.getPreguntasByUsuPrg(id_user, id_prg);

            	datogeneral.setConvocatorias_programa(convocatorias);
            	datogeneral.setSimulacros_programa(simulacros);
            	datogeneral.setCategorias_programa(categorias);
            	datogeneral.setSubcategorias_programa(subconvocatorias);
            	datogeneral.setUsuarios_programa(usuarios_programa);
            	datogeneral.setPreguntas_programa(preguntas_programa);
        	}
        	
        	if(usuario.getRol().getRol_nombre().equals("ROLE_DOCENTE")) {
        		List<CategoriaDTO> categorias = categoriaService.getCategoriasByUsuPrg(id_user, id_prg);
            	List<SubcatergoriaDTO> subcategorias = subcategoriaService.getSubcategoriasByUsuPrg(id_user, id_prg);
            	List<PreguntaDTO> preguntas_programa = preguntaService.getPreguntasByUsuPrg(id_user, id_prg);
            	datogeneral.setCategorias_programa(categorias);
            	datogeneral.setSubcategorias_programa(subcategorias);
            	datogeneral.setPreguntas_programa(preguntas_programa);
        	}
        	
        	if(usuario.getRol().getRol_nombre().equals("ROLE_ESTUDIANTE")) {
        		List<SubcatergoriaDTO> subcategorias = subcategoriaService.getSubcategoriasByUsuPrg(id_user, id_prg);
            	datogeneral.setSubcategorias_programa(subcategorias);
        	}

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
	
	@Operation(summary = "Obtiene los usuarios de un programa en especifico.")
    @GetMapping("/getUsuariosPrograma")
    public ResponseEntity<Object> getUsuariosPrograma(@RequestParam String id_usuario, @RequestParam String id_programa) {
		Map<String,Object> datos = new LinkedHashMap<>();
		Long id_user = Long.parseLong(id_usuario);
		Long id_prg = Long.parseLong(id_programa);
        try {
        	List<UsuarioDTO> usuarios_programa = usuarioService.getAllByUsuPrg(id_user, id_prg);
        	datos.put("error", null);
        	datos.put("message", "¡Proceso Exitoso!");
        	datos.put("usuarios", usuarios_programa);
        	
        	return new ResponseEntity<Object>(datos, HttpStatus.OK);	
        	
        } catch (Exception e) {
        	datos.put("error", e.getMessage());
        	datos.put("message", "¡Oops!, Ha ocurrido un error al traer los usuarios del programa.");
        	datos.put("usuarios", null);
        	return new ResponseEntity<Object>(datos	, HttpStatus.INTERNAL_SERVER_ERROR);	
        }
    }
     
}
