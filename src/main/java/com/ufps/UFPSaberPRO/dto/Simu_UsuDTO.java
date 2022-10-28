package com.ufps.UFPSaberPRO.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Simu_UsuDTO {
	private Long id_simu_usu;
	
	@NotNull
	private Boolean simu_usu_presentado;
	
	@NotBlank
	@NotEmpty
	private String simu_usu_codigo;
	
	@NotNull
	private Integer simu_usu_puntaje_total;
	
	@NotNull
	private Long simulacro;
	
	@NotNull
	private Long usuario;
	
}

