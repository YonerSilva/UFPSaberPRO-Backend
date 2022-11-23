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
    
    private Long preg_tipo;
	
	@NotNull
    private Long id_subcategoria;
	
	private SubcatergoriaDTO subcategoria;
	
	private Long usu_creacion;
	
	private Integer simu_preg_puntaje;

	public PreguntaDTO() {
	}

	public PreguntaDTO(Long id_pregunta, String preg_imagen, String preg_descripcion,
			String preg_estado,Long preg_tipo, Long id_subcategoria,
			Integer simu_preg_puntaje) {
		this.id_pregunta = id_pregunta;
		this.preg_imagen = preg_imagen;
		this.preg_descripcion = preg_descripcion;
		this.preg_estado = preg_estado;
		this.preg_tipo = preg_tipo;
		this.id_subcategoria = id_subcategoria;
		this.simu_preg_puntaje = simu_preg_puntaje;
	} 
}
