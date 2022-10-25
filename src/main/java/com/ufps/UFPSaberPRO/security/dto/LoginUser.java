package com.ufps.UFPSaberPRO.security.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginUser {
	@NotBlank
	@NotEmpty
    private String codigo;
	
    @NotBlank
    @NotEmpty
    private String email;
    
    @NotBlank
    @NotEmpty
    private String password;
}
