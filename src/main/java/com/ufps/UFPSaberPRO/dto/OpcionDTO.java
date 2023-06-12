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
	
	private Integer opc_orden;
	
	@NotNull
	private Long pregunta;
	
	public OpcionDTO(){
		
	}

	public OpcionDTO(Long id_opcion, String opc_imagen, String opc_descripcion,Long pregunta) {
		this.id_opcion = id_opcion;
		this.opc_imagen = opc_imagen;
		this.opc_descripcion = opc_descripcion;
		this.pregunta = pregunta;
	}
	
	
}
