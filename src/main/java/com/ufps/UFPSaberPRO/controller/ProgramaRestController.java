package com.ufps.UFPSaberPRO.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.UFPSaberPRO.dto.ProgramaDTO;
import com.ufps.UFPSaberPRO.serviceImpl.ProgramaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/programas")
@CrossOrigin("*")
public class ProgramaRestController {
	
	@Autowired
	private ProgramaServiceImpl programaService;
	
	@GetMapping("/getProgramas")
	public ResponseEntity<Object> getProgramas(){
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			List<ProgramaDTO> programas = programaService.getProgramas();
			if(programas.size()>0) {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("programas", programas);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}else {
				datos.put("error", null);
				datos.put("message", "No se encontraron programas.");
				datos.put("programas", null);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron programas.");
			datos.put("programas", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Obtiene un programa en especifico por el codigo.")
	@GetMapping("/getPrograma")
	public ResponseEntity<Object> getPrograma(@Valid @RequestParam String codigo){
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			ProgramaDTO programa = programaService.buscarPorCodigo(codigo);
			if(programa==null) {
				datos.put("error", "El codigo del programa no existe.");
				datos.put("message", "No existe un programa con ese codigo.");
				datos.put("programa", null);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}else {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("programa", programa);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "Ha ocurrido un error al buscar el programa.");
			datos.put("programa", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(datos, HttpStatus.OK);
	}
	
	@Operation(summary = "Registra un nuevo programa en la base de datos.")
	@PostMapping("/guardarPrograma")
	public ResponseEntity<Object> guardarPrograma(@Valid @RequestBody ProgramaDTO nuevoPrograma, BindingResult bidBindingResult){
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				programaService.guardar(nuevoPrograma);
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				return new ResponseEntity<Object>(datos, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "Ha ocurrido un error interno con los datos.");
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
