package com.ufps.UFPSaberPRO.security.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class NuevoUsuario {

    @NotEmpty
    private String usu_nombre;
    
    @NotEmpty
    private String usu_apellido;
    
    @NotEmpty
    private String usu_codigo;
    
    @NotBlank
    private String usu_email;
    
    @NotBlank
    private String usu_password;
    
    @NotBlank
    private Long programa;
    
    private Set<Long> usu_roles = new HashSet<>();
    
    public NuevoUsuario() {
    	
    }
    
    public NuevoUsuario(@NotBlank String nombre, @NotBlank String apellido, @NotBlank String codigo, @NotBlank String email, @NotBlank String password,
            @NotBlank Long programa, Set<Long> roles) {
        this.usu_nombre = nombre;
        this.usu_apellido = apellido;
        this.usu_codigo = codigo;
        this.usu_email = email;
        this.usu_password = password;
        this.programa = programa;
        this.usu_roles = roles;
    } 
}
