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
	
	@NotBlank
	@NotEmpty
    private String simu_codigo;
	
	
	public SimulacroDTO() {
		
	}

}
