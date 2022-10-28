package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    
	@NotNull
    private Date simu_fecha_inicial;
	
	@NotNull
    private Date simu_fecha_final;
	
	@NotBlank
	@NotEmpty
    private String simu_duracion;
	
	@NotBlank
	@NotEmpty
    private String simu_estado;

}
