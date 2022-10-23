package com.ufps.UFPSaberPRO.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UsuarioDTO {

    @NotEmpty
    private String usu_nombre;
    
    @NotEmpty
    private String usu_apellido;
    
    @NotEmpty
    private String usu_codigo;
    
    @NotEmpty
    @Email
    private String usu_email;
    
    @NotEmpty
    private String usu_password;
    
    @NotEmpty
    private Long programa;
    
    @NotEmpty
    private Long rol;
    
    public UsuarioDTO(String nombre,  String apellido, String codigo, String email, String password,
             Long programa, Long rol) {
        this.usu_nombre = nombre;
        this.usu_apellido = apellido;
        this.usu_codigo = codigo;
        this.usu_email = email;
        this.usu_password = password;
        this.programa = programa;
        this.rol = rol;
    } 
}
