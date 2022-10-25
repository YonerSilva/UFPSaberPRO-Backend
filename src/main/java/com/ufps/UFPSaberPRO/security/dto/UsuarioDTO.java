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
    
    @NotEmpty
    @NotBlank
    private String usu_password;
    
    @NotEmpty
    @NotBlank
    private String cod_programa;
    
    @NotNull
    private Long rol;
        
    public UsuarioDTO(Long id_usuario, String nombre,  String apellido, String codigo, String email, String password,
             String cod_programa, Long rol) {
    	this.id_usuario = id_usuario;
        this.usu_nombre = nombre;
        this.usu_apellido = apellido;
        this.usu_codigo = codigo;
        this.usu_email = email;
        this.usu_password = password;
        this.cod_programa = cod_programa;
        this.rol = rol;
    } 
}
