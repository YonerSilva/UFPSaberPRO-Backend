package com.ufps.UFPSaberPRO.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController(value = "/api/general")
@Slf4j
public class GeneralRestController {
    
    @GetMapping("/getDatos")
    public String getGeneral() {
        try {
        	
        } catch (Exception e) {
        	
        }
        return "inicio";
    }
     
}
