package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

import lombok.Data;

@Data
public class ConvocatoriaDTO {
	private Long id_convocatoria;
    
	@NotBlank
	@NotEmpty
	private String convo_nombre;
    
	@NotBlank
	@NotEmpty
    private String convo_descripcion;
	
	@NotBlank
	@NotEmpty
    private Date convo_fechaInicial;
	
	@NotBlank
	@NotEmpty
    private Date convo_fechaFinal;
	
	@NotBlank
	@NotEmpty
    private String convo_estado;
	
	@NotBlank
	@NotEmpty
    private Long programa;
	
	@NotBlank
	@NotEmpty
    private Long simulacro;
	
	public ConvocatoriaDTO() {
		
	}


}
