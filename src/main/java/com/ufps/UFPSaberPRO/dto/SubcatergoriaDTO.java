package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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

	@NotBlank
	@NotEmpty
	private Long categoria;
	
	@NotBlank
	@NotEmpty
	private Long usu_creacion;
	
	public SubcatergoriaDTO() {
		
	}

	public SubcatergoriaDTO(Long id_subcategoria, String sub_nombre,
			 String sub_descripcion, Long categoria,
			 Long usu_creacion) {
		this.id_subcategoria = id_subcategoria;
		this.sub_nombre = sub_nombre;
		this.sub_descripcion = sub_descripcion;
		this.categoria = categoria;
		this.usu_creacion = usu_creacion;
	}
	
	

}
