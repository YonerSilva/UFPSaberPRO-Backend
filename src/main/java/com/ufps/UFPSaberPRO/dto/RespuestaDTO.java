package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ufps.UFPSaberPRO.entity.Pregunta;

import lombok.Data;

@Data
public class RespuestaDTO {
	private Long id_respuesta;

	@NotNull
	private Long pregunta;

	@NotBlank
	@NotEmpty
	private String opciones;

	@NotNull
	private Integer rta_puntaje_obtenido;
}
