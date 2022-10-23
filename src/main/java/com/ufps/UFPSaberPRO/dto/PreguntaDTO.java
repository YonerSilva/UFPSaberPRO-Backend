package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

import lombok.Data;

@Data
public class PreguntaDTO {
	private Long id_pregunta;
    
	@NotBlank
	@NotEmpty
	private String preg_imagen;
    
	@NotBlank
	@NotEmpty
    private String prg_codigo;
    
	@NotBlank
	@NotEmpty
	private String preg_descripcion;
	
	@NotBlank
	@NotEmpty
    private String preg_estado;
	
	
	public PreguntaDTO() {
		
	}

	
}
