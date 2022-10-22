package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ProgramaDTO {
	private Long id_programa;
    
	@NotBlank
	@NotEmpty
    private String prg_nombre;
    
	@NotBlank
	@NotEmpty
    private String prg_codigo;
    
	@NotBlank
	@NotEmpty
	@Email
    private String prg_email;
	
	public ProgramaDTO() {
		
	}

	public ProgramaDTO(String prg_nombre, String prg_codigo, String prg_email) {
		this.prg_nombre = prg_nombre;
		this.prg_codigo = prg_codigo;
		this.prg_email = prg_email;
	}
}
