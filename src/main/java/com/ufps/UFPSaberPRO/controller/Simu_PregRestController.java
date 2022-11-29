package com.ufps.UFPSaberPRO.controller;


import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.UFPSaberPRO.dto.Simu_PregDTO;
import com.ufps.UFPSaberPRO.dto.SimulacroDTO;
import com.ufps.UFPSaberPRO.serviceImpl.Simu_PregServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/simu_preg")
@CrossOrigin("*")
public class Simu_PregRestController {

	@Autowired
	private Simu_PregServiceImpl simu_pregService;
	
	@Operation(summary = "Registra nuevas relaciones entre simulacro y pregunta en la base de datos.")
	@PostMapping("/guardarPreguntas")
	public ResponseEntity<Object> guardarPreguntas(@Valid @RequestBody Simu_PregDTO simu_PregDTO,
			BindingResult bidBindingResult) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				simu_pregService.guardar(simu_PregDTO);
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
	
	@Operation(summary = "Elimina relaciones entre simulacro y pregunta en la base de datos.")
	@DeleteMapping("/eliminarPreguntas")
	public ResponseEntity<Object> eliminarPreguntas(@Valid @RequestBody Simu_PregDTO simu_PregDTO,
			BindingResult bidBindingResult) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				simu_pregService.eliminar(simu_PregDTO);
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				return new ResponseEntity<Object>(datos, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "Ha ocurrido un error al eliminar las preguntas.");
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
