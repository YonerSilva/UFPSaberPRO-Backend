package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.CategoriaDTO;
import com.ufps.UFPSaberPRO.entity.Categoria;


@Component
public class CategoriaConverter {

	public CategoriaDTO converterToDTO(@NotNull Categoria entity) {
		CategoriaDTO categoria = new CategoriaDTO();
		categoria.setId_categoria(entity.getId_categoria());
		categoria.setCate_nombre(entity.getCate_nombre());
		categoria.setCate_descripcion(entity.getCate_descripcion());
		categoria.setCate_fechaCreacion(entity.getCate_fechaCreacion());
		return categoria;
	}
	
	public Categoria converterToEntity(@NotNull CategoriaDTO dto) {
		Categoria categoria = newCategoria();
		categoria.setId_categoria(dto.getId_categoria());
		categoria.setCate_nombre(dto.getCate_nombre());
		categoria.setCate_descripcion(dto.getCate_descripcion());
		return categoria;
	}
	
}
