package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class RespuestaDTO {
private Long id_respuesta;
    
	@NotBlank
	@NotEmpty
    private String opciones;
    
	@NotBlank
	@NotEmpty
    private Integer rta_puntajeObtenido;

	public RespuestaDTO() {
		
	}

	public RespuestaDTO(Long id_respuesta,String opciones, Integer rta_puntajeObtenido) {
		this.id_respuesta = id_respuesta;
		this.opciones = opciones;
		this.rta_puntajeObtenido = rta_puntajeObtenido;
	}
	
	
}
