package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Date;

import lombok.Data;

@Data
public class CategoriaDTO {
	private Long id_categoria;
    
	@NotBlank
	@NotEmpty
	private String cate_nombre;
    
	@NotBlank
	@NotEmpty
	private String cate_descripcion;
	
	@NotNull
	private Long programa;
	
	private Long usu_creacion;
	
}
