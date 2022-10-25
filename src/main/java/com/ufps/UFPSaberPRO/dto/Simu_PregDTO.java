package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class Simu_PregDTO {
	private Long id_simu_preg;
	
	@NotBlank
	@NotEmpty
	private Integer simu_usu_puntaje;
	
	@NotBlank
	@NotEmpty
	private Long simulacro;
	
	@NotBlank
	@NotEmpty
	private Long pregunta;

	public Simu_PregDTO() {
		
	}

	public Simu_PregDTO(Long id_simu_preg,Integer simu_usu_puntaje,Long simulacro,Long pregunta) {
		this.id_simu_preg = id_simu_preg;
		this.simu_usu_puntaje = simu_usu_puntaje;
		this.simulacro = simulacro;
		this.pregunta = pregunta;
	}
	
	
	
}
