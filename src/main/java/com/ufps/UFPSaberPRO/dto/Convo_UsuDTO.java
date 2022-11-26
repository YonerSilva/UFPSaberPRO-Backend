package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Convo_UsuDTO {
	@NotNull
	private Long id_convocatoria;
	
	@NotNull
	private Long id_usuario;

}
