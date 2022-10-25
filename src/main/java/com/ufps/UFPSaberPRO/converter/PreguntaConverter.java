package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.entity.Pregunta;
import com.ufps.UFPSaberPRO.entity.Subcategoria;


@Component
public class PreguntaConverter {

	public PreguntaDTO converterToDTO(@NotNull Pregunta entity) {
		PreguntaDTO pregunta = new PreguntaDTO();
		pregunta.setId_pregunta(entity.getId_pregunta());
		pregunta.setPreg_imagen(entity.getPreg_imagen());
		pregunta.setPreg_descripcion(entity.getPreg_descripcion());
		pregunta.setPreg_estado(entity.getPreg_estado());
		pregunta.setSubcategoria(entity.getSubcategoria().getId_subcategoria());
		pregunta.setUsu_creacion(entity.getUsu_creacion());
		return pregunta;
	}
	
	public Pregunta converterToEntity(@NotNull PreguntaDTO dto) {
		Pregunta pregunta = new Pregunta();
		pregunta.setId_pregunta(dto.getId_pregunta());
		pregunta.setPreg_imagen(dto.getPreg_imagen());
		pregunta.setPreg_descripcion(dto.getPreg_descripcion());
		pregunta.setPreg_estado(dto.getPreg_estado());
		pregunta.setSubcategoria(new Subcategoria(dto.getId_pregunta()));
		pregunta.setUsu_creacion(dto.getUsu_creacion());
		return pregunta;
	}

}
