package com.ufps.UFPSaberPRO.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UsuarioDTO {
	private Long id_usuario;

    @NotEmpty
    @NotBlank
    private String usu_nombre;
    
    @NotEmpty
    @NotBlank
    private String usu_apellido;
    
    @NotEmpty
    @NotBlank
    private String usu_codigo;
    
    @NotEmpty
    @NotBlank
    @Email
    private String usu_email;
    

    private String usu_password;
    
    @NotEmpty
    @NotBlank
    private String cod_programa;
    
    @NotNull
    private Long rol;
        
}
