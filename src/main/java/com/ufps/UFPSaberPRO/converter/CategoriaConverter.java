package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.CategoriaDTO;
import com.ufps.UFPSaberPRO.entity.Categoria;
import com.ufps.UFPSaberPRO.entity.Programa;


@Component
public class CategoriaConverter {

	public CategoriaDTO converterToDTO(@NotNull Categoria entity) {
		CategoriaDTO categoria = new CategoriaDTO();
		categoria.setId_categoria(entity.getId_categoria());
		categoria.setCate_nombre(entity.getCate_nombre());
		categoria.setCate_descripcion(entity.getCate_descripcion());
		categoria.setPrograma(entity.getPrograma()!=null?entity.getPrograma().getId_programa():null);
		categoria.setUsu_creacion(entity.getUsu_creacion());
		return categoria;
	}
	
	public Categoria converterToEntity(@NotNull CategoriaDTO dto) {
		Categoria categoria = new Categoria();
		categoria.setId_categoria(dto.getId_categoria());
		categoria.setCate_nombre(dto.getCate_nombre());
		categoria.setCate_descripcion(dto.getCate_descripcion());
		categoria.setPrograma(new Programa(dto.getPrograma()));
		categoria.setUsu_creacion(dto.getUsu_creacion());
		return categoria;
	}
	
}
