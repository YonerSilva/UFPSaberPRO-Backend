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
	private String preg_descripcion;
	
	@NotBlank
	@NotEmpty
    private String preg_estado;
	
	@NotBlank
	@NotEmpty
    private Long subcategoria;
	
	@NotBlank
	@NotEmpty
	private Long usu_creacion;
	
	public PreguntaDTO() {
		
	}

	public PreguntaDTO(Long id_pregunta, String preg_imagen,
			 String preg_descripcion,  String preg_estado,
			 Long subcategoria, Long usu_creacion) {
		this.id_pregunta = id_pregunta;
		this.preg_imagen = preg_imagen;
		this.preg_descripcion = preg_descripcion;
		this.preg_estado = preg_estado;
		this.subcategoria = subcategoria;
		this.usu_creacion = usu_creacion;
	}
	
	

	
}
