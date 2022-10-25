package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.ufps.UFPSaberPRO.entity.Programa;

import java.time.LocalDateTime;
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
	
	
    private Long simulacro;
	
	@NotBlank
	@NotEmpty
	private Long usu_creacion;
	
	public ConvocatoriaDTO() {
		
	}
	
	public ConvocatoriaDTO(Long id_convocatoria,String convo_nombre,
			 String convo_descripcion,  Date convo_fechaInicial,
			 Date convo_fechaFinal, String convo_estado,
			Long programa,  Long simulacro, Long usu_creacion) {
		
		this.id_convocatoria = id_convocatoria;
		this.convo_nombre = convo_nombre;
		this.convo_descripcion = convo_descripcion;
		this.convo_fechaInicial = convo_fechaInicial;
		this.convo_fechaFinal = convo_fechaFinal;
		this.convo_estado = convo_estado;
		this.programa = programa;
		this.simulacro = simulacro;
		this.usu_creacion = usu_creacion;
	}


}
