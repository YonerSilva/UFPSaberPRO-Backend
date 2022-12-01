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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.UFPSaberPRO.dto.DatogeneralDTO;
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.dto.SubcatergoriaDTO;
import com.ufps.UFPSaberPRO.serviceImpl.PreguntaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaRestController {
	
	@Autowired
	private PreguntaServiceImpl preguntaService;
	
	private DatogeneralDTO datoGeneral;

	public PreguntaRestController() {
		datoGeneral = new DatogeneralDTO();
	}

	@Operation(summary = "Obtiene los datos generales de las preguntas para el usuario.")
	@GetMapping("/general")
	public ResponseEntity<Object> general(@RequestParam String id_usuario, @RequestParam String id_programa) {
		Map<String, Object> datos = new LinkedHashMap<>();
		Long id_user = Long.parseLong(id_usuario);
		Long id_prg = Long.parseLong(id_programa);
		try {
			List<PreguntaDTO> preguntas_programa = preguntaService.getPreguntasByUsuPrg(id_user,id_prg);
			datoGeneral.setPreguntas_programa(preguntas_programa);

			datos.put("error", null);
			datos.put("message", "¡Proceso Exitoso!");
			datos.put("general", datoGeneral);
			return new ResponseEntity<Object>(datos, HttpStatus.OK);
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron preguntas.");
			datos.put("general", datoGeneral);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Registra una nueva pregunta en la base de datos.")
	@PostMapping("/guardarPregunta")
	public ResponseEntity<Object> guardarPregunta(@Valid @RequestBody PreguntaDTO pregunta,
			BindingResult bidBindingResult) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("pregunta", null);
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				PreguntaDTO preg = preguntaService.guardar(pregunta);
				datos.put("pregunta", preg);
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				return new ResponseEntity<Object>(datos, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("pregunta", null);
			datos.put("message", "Ha ocurrido un error interno con los datos.");
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Actualiza una pregunta existente en la base de datos.")
	@PutMapping("/actualizarPregunta")
	public ResponseEntity<Object> actualizarPregunta(@Valid @RequestBody PreguntaDTO pregunta,
			BindingResult bidBindingResult) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				preguntaService.actualizar(pregunta);
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
