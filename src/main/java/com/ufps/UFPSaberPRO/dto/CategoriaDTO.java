package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
	
	@NotBlank
	@NotEmpty
	private Long programa;
	
	@NotBlank
	@NotEmpty
	private Long usu_creacion;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Long id_categoria,String cate_nombre,String cate_descripcion, Long programa,
			 Long usu_creacion) {
		this.id_categoria = id_categoria;
		this.cate_nombre = cate_nombre;
		this.cate_descripcion = cate_descripcion;
		this.programa = programa;
		this.usu_creacion = usu_creacion;
	}

}
