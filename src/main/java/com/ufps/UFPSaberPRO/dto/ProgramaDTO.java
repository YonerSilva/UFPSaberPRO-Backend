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
}
