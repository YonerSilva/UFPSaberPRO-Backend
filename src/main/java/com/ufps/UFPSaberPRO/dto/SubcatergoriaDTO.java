package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ufps.UFPSaberPRO.entity.Categoria;

import java.util.Date;

import lombok.Data;

@Data
public class SubcatergoriaDTO {
	private Long id_subcategoria;
    
	@NotBlank
	@NotEmpty
	private String sub_nombre;
    
	@NotBlank
	@NotEmpty
	private String sub_descripcion;

	@NotNull
	private Long categoria;
	
	private Long usu_creacion;
	
	@NotNull
	private Long programa;
}
