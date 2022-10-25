package com.ufps.UFPSaberPRO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.UFPSaberPRO.serviceImpl.Simu_UsuServiceImpl;

@RestController
@RequestMapping("/api/simu_usu")
@CrossOrigin("*")
public class Simu_UsuRestController {

	@Autowired
	private Simu_UsuServiceImpl simu_usuService;
}
