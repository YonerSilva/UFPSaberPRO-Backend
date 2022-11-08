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

import com.ufps.UFPSaberPRO.dto.DatogeneralDTO;
import com.ufps.UFPSaberPRO.dto.SimulacroDTO;
import com.ufps.UFPSaberPRO.serviceImpl.SimulacroServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/simulacros")
@CrossOrigin("*")
public class SimulacroRestController {

	@Autowired
	private SimulacroServiceImpl simulacroService;

	private DatogeneralDTO datoGeneral;

	public SimulacroRestController() {
		datoGeneral = new DatogeneralDTO();
	}

	@Operation(summary = "Obtiene una lista de simulacros.")
	@GetMapping("/getSimulacros")
	public ResponseEntity<Object> getSimulacros() {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			List<SimulacroDTO> simulacros = simulacroService.getSimulacros();
			if (simulacros.size() > 0) {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("simulacros", simulacros);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			} else {
				datos.put("error", null);
				datos.put("message", "No se encontraron simulacros.");
				datos.put("simulacros", null);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron simulacros.");
			datos.put("simulacros", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Obtiene un simulacro en especifico por el id.")
	@GetMapping("/getSimulacro")
	public ResponseEntity<Object> getSimulacro(@Valid @RequestParam String id_simulacro) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			Long id_simu = Long.parseLong(id_simulacro);
			SimulacroDTO simulacro = simulacroService.buscar(id_simu);
			if (simulacro == null) {
				datos.put("error", "El identificador del simulacro no existe.");
				datos.put("message", "No existe un simulacro con ese identificador.");
				datos.put("simulacro", null);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			} else {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("simulacro", simulacro);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "Ha ocurrido un error al buscar la simulacro.");
			datos.put("simulacro", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(datos, HttpStatus.OK);
	}

	@Operation(summary = "Registra un nuevo simulacro en la base de datos.")
	@PostMapping("/guardarSimulacro")
	public ResponseEntity<Object> guardarSimulacro(@Valid @RequestBody SimulacroDTO nuevoSimulacro,
			BindingResult bidBindingResult) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				simulacroService.guardar(nuevoSimulacro);
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

	@Operation(summary = "Actualiza un simulacro existente en la base de datos.")
	@PostMapping("/actualizarSimulacro")
	public ResponseEntity<Object> actualizarSimulacro(@Valid @RequestBody SimulacroDTO simulacro,
			BindingResult bidBindingResult) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				simulacroService.update(simulacro);
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
