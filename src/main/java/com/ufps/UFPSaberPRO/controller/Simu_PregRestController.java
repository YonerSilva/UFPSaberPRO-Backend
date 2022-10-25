package com.ufps.UFPSaberPRO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.UFPSaberPRO.serviceImpl.Simu_PregServiceImpl;

@RestController
@RequestMapping("/api/simu_preg")
@CrossOrigin("*")
public class Simu_PregRestController {

	@Autowired
	private Simu_PregServiceImpl simu_pregService;
}
