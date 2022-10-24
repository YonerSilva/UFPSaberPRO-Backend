package com.ufps.UFPSaberPRO.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtDTO {
    private String token;
    
    public JwtDTO() {
    	
    }
    
    public JwtDTO(String token) {
    	this.token = token;
    }
}
