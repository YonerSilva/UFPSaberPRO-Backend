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
import org.springframework.web.bind.annotation.RestController;

import com.ufps.UFPSaberPRO.dto.DatogeneralDTO;
import com.ufps.UFPSaberPRO.dto.ProgramaDTO;
import com.ufps.UFPSaberPRO.security.entity.Rol;
import com.ufps.UFPSaberPRO.security.service.RoleService;
import com.ufps.UFPSaberPRO.serviceImpl.ProgramaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/auth/api/general")
@CrossOrigin("*")
public class GeneralRestController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ProgramaServiceImpl programaService;
	
	private DatogeneralDTO datogeneral;
	
	public GeneralRestController() {
		datogeneral = new DatogeneralDTO();
	}
    
	@Operation(summary = "Obtiene los datos generales para el funcionamiento de la aplicación.")
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
     
}
