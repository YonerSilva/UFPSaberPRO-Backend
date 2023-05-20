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

import com.ufps.UFPSaberPRO.dto.SimulacroDTO;
import com.ufps.UFPSaberPRO.security.dto.UsuarioDTO;
import com.ufps.UFPSaberPRO.serviceImpl.Simu_UsuServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/simu_usu")
public class Simu_UsuRestController {

	@Autowired
	private Simu_UsuServiceImpl simu_usuService;
	
	@Operation(summary = "Obtiene una lista de usuarios que se encuentren"
			+ "relacionadas a un simulacro.")
	@GetMapping("/getUsuariosSimu")
	public ResponseEntity<Object> getUsuariosSimu(@RequestParam String id_simulacro) {
		Map<String, Object> datos = new LinkedHashMap<>();
		Long id_simu = Long.parseLong(id_simulacro);
		try {
			List<UsuarioDTO> usuarios = simu_usuService.getUsuariosSimu(id_simu);
			if (usuarios.size() > 0) {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("usuarios", usuarios);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			} else {
				datos.put("error", null);
				datos.put("message", "No se encontraron usuarios.");
				datos.put("usuarios", usuarios);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron usuarios.");
			datos.put("usuarios", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
