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
	
	
	public OpcionDTO() {
		
	}

}
