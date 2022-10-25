package com.ufps.UFPSaberPRO.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


import lombok.Data;

@Data
public class Simu_UsuDTO {
	private Long id_simu_usu;
	
	@NotBlank
	@NotEmpty
	private Boolean simu_usu_presentado;
	
	@NotBlank
	@NotEmpty
	private String simu_usu_codigo;
	
	@NotBlank
	@NotEmpty
	private Integer simu_usu_puntajeTotal;
	
	@NotBlank
	@NotEmpty
	private Long simulacro;
	
	@NotBlank
	@NotEmpty
	private Long usuario;
	

	public Simu_UsuDTO() {
	
	}

	public Simu_UsuDTO(Long id_simu_usu, Boolean simu_usu_presentado,
			 String simu_usu_codigo,  Integer simu_usu_puntajeTotal,
			 Long simulacro, Long usuario) {
	
		this.id_simu_usu = id_simu_usu;
		this.simu_usu_presentado = simu_usu_presentado;
		this.simu_usu_codigo = simu_usu_codigo;
		this.simu_usu_puntajeTotal = simu_usu_puntajeTotal;
		this.simulacro = simulacro;
		this.usuario = usuario;
	}
	
	
}

