package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Date;

import lombok.Data;

@Data
public class PreguntaDTO {
	private Long id_pregunta;
    
	private String preg_imagen;
    
	@NotBlank
	@NotEmpty
	private String preg_descripcion;
	
    private String preg_estado;
	
	@NotNull
    private Long id_subcategoria;
	
	private SubcatergoriaDTO subcategoria;
	
	private Long usu_creacion;
}
