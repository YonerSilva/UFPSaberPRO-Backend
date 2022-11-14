package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Date;

import lombok.Data;

@Data
public class OpcionDTO {
	private Long id_opcion;
    
	private String opc_imagen;
    
	@NotBlank
	@NotEmpty
    private String opc_descripcion;
	
	@NotNull
    private Boolean opc_respuesta;
	
	@NotNull
	private Long pregunta;
}
