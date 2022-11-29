package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import java.util.Date;

import lombok.Data;

@Data
public class SimulacroDTO {
	private Long id_simulacro;
    
	@NotBlank
	@NotEmpty
	private String simu_nombre;
    
	@NotBlank
	@NotEmpty
    private String simu_descripcion;
	
	@NotNull
	private Integer simu_puntaje_maximo;
		
    private String simu_estado;

	@NotNull
	private Long programa;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", shape = Shape.STRING)
    private Date simu_fecha_inicial;
	
	@JsonFormat(pattern = "hh:mm", shape = Shape.STRING)
    private Date simu_duracion;
	
	public SimulacroDTO() {
		
	}

	public SimulacroDTO(Long id_simulacro,String simu_nombre,
			String simu_descripcion,Integer simu_puntaje_maximo, String simu_estado,
			Long programa, Date simu_fecha_inicial, Date simu_duracion) {
		this.id_simulacro = id_simulacro;
		this.simu_nombre = simu_nombre;
		this.simu_descripcion = simu_descripcion;
		this.simu_puntaje_maximo = simu_puntaje_maximo;
		this.simu_estado = simu_estado;
		this.programa = programa;
		this.simu_fecha_inicial = simu_fecha_inicial;
		this.simu_duracion = simu_duracion;
	}
	
	
}
