package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Simu_PregDTO {
	private Long id_simu_preg;
	
	private Integer simu_usu_puntaje;
	
	@NotNull
	private Long simulacro;
	
	private Long pregunta;
	
	@NotNull
	private PreguntaDTO[] preguntas;

}
