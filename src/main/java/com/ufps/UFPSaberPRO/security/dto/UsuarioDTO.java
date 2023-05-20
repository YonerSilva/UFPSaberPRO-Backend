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
    
    public UsuarioDTO() {
    	
    }

	public UsuarioDTO(Long id_usuario,String usu_nombre, String usu_apellido,
		 String usu_codigo, String usu_email,
		 String cod_programa, Long rol) {
		super();
		this.id_usuario = id_usuario;
		this.usu_nombre = usu_nombre;
		this.usu_apellido = usu_apellido;
		this.usu_codigo = usu_codigo;
		this.usu_email = usu_email;
		this.cod_programa = cod_programa;
		this.rol = rol;
	}
    
    
        
}
