package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

import lombok.Data;

@Data
public class OpcionDTO {
	private Long id_opcion;
    
	@NotBlank
	@NotEmpty
	private String opc_imagen;
    
	@NotBlank
	@NotEmpty
    private String opc_descripcion;
	
	@NotBlank
	@NotEmpty
    private Boolean opc_respuesta;
	
	@NotBlank
	@NotEmpty
	private Long pregunta;
	
	
	public OpcionDTO() {
		
	}

	public OpcionDTO(Long id_opcion,  String opc_imagen,  String opc_descripcion,
			 Boolean opc_respuesta,  Long pregunta) {
		this.id_opcion = id_opcion;
		this.opc_imagen = opc_imagen;
		this.opc_descripcion = opc_descripcion;
		this.opc_respuesta = opc_respuesta;
		this.pregunta = pregunta;
	}
	
	

}
