package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.SubcategoriaDTO;
import com.ufps.UFPSaberPRO.entity.Subcategoria;


@Component
public class SubcategoriaConverter {
	
	public SubcategoriaDTO converterToDTO(@NotNull Subcategoria entity) {
		SubcategoriaDTO subcategoria = new SubcategoriaDTO();
		subcategoria.setId_subcategoria(entity.getId_subcategoria());
		subcategoria.setSub_nombre(entity.getSub_nombre());
		subcategoria.setSub_descripcion(entity.getSub_descripcion());
		subcategoria.setSub_fechaCreado(entity.getSub_fechaCreado);
		return subcategoria;
	}
	
	public Subcategoria converterToEntity(@NotNull SubcategoriaDTO dto) {
		Subcategoria subcategoria = new Subcategoria();
		subcategoria.setId_subcategoria(dto.getId_subcategoria());
		subcategoria.setSub_nombre(dto.getSub_nombre());
		subcategoria.setSub_descripcion(dto.getSub_descripcion());
		subcategoria.setSub_fechaCreado(dto.getSub_fechaCreado);
		return subcategoria;
	}

}
