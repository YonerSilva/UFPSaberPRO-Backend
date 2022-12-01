package com.ufps.UFPSaberPRO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.UFPSaberPRO.serviceImpl.RespuestaServiceImpl;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaRestController {
	
	@Autowired
	private RespuestaServiceImpl respuestaService;
}
