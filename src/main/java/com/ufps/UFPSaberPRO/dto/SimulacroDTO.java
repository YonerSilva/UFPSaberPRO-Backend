package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
	
	@NotBlank
	@NotEmpty
	private Integer simu_puntajeMaximo;
    
	@NotBlank
	@NotEmpty
    private Date simu_fechaInicial;
	
	@NotBlank
	@NotEmpty
    private Date simu_fechaFinal;
	
	@NotBlank
	@NotEmpty
    private String simu_duracion;
	
	@NotBlank
	@NotEmpty
    private String simu_estado;
	

	public SimulacroDTO() {
		
	}


	public SimulacroDTO(Long id_simulacro, String simu_nombre,
			 String simu_descripcion, Integer simu_puntajeMaximo,
			 Date simu_fechaInicial, Date simu_fechaFinal,
			 String simu_duracion, String simu_estado) {
		this.id_simulacro = id_simulacro;
		this.simu_nombre = simu_nombre;
		this.simu_descripcion = simu_descripcion;
		this.simu_puntajeMaximo = simu_puntajeMaximo;
		this.simu_fechaInicial = simu_fechaInicial;
		this.simu_fechaFinal = simu_fechaFinal;
		this.simu_duracion = simu_duracion;
		this.simu_estado = simu_estado;
	}
	
	

}
