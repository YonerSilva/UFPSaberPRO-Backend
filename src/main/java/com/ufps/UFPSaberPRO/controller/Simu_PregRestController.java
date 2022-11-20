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

import com.ufps.UFPSaberPRO.dto.DatogeneralDTO;
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.dto.ProgramaDTO;
import com.ufps.UFPSaberPRO.serviceImpl.Simu_PregServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/simu_preg")
@CrossOrigin("*")
public class Simu_PregRestController {

	@Autowired
	private Simu_PregServiceImpl simu_pregService;
	
	private DatogeneralDTO datoGeneral;

	public Simu_PregRestController() {
		datoGeneral = new DatogeneralDTO();
	}

	@Operation(summary = "Obtiene una lista de preguntas de un simulacro en especifico.")
	@GetMapping("/getPreguntas")
	public ResponseEntity<Object> getPreguntas(@RequestParam String id_simulacro){
		Long id_simu = Long.parseLong(id_simulacro);
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			List<PreguntaDTO> preguntas = simu_pregService.getPreguntasBySimulacro(id_simu);
			if(preguntas.size()>0) {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("preguntas", preguntas);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}else {
				datos.put("error", null);
				datos.put("message", "No se encontraron preguntas.");
				datos.put("preguntas", null);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron preguntas.");
			datos.put("preguntas", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
