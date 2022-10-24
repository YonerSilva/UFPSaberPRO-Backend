package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.SubcatergoriaDTO;
import com.ufps.UFPSaberPRO.entity.Subcategoria;


@Component
public class SubcategoriaConverter {
	
	public SubcatergoriaDTO converterToDTO(@NotNull Subcategoria entity) {
		SubcatergoriaDTO subcategoria = new SubcatergoriaDTO();
		subcategoria.setId_subcategoria(entity.getId_subcategoria());
		subcategoria.setSub_nombre(entity.getSub_nombre());
		subcategoria.setSub_descripcion(entity.getSub_descripcion());
		return subcategoria;
	}
	
	public Subcategoria converterToEntity(@NotNull SubcatergoriaDTO dto) {
		Subcategoria subcategoria = new Subcategoria();
		subcategoria.setId_subcategoria(dto.getId_subcategoria());
		subcategoria.setSub_nombre(dto.getSub_nombre());
		subcategoria.setSub_descripcion(dto.getSub_descripcion());
		return subcategoria;
	}

}
