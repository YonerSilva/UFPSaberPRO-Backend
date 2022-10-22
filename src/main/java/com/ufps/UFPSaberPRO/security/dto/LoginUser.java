package com.ufps.UFPSaberPRO.security.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUser {
	@NotBlank
    private String codigo;
	
    @NotBlank
    private String email;
    
    @NotBlank
    private String password;
}
