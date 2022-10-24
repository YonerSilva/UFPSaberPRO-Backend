package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.entity.Pregunta;


@Component
public class PreguntaConverter {

	public PreguntaDTO converterToDTO(@NotNull Pregunta entity) {
		PreguntaDTO pregunta = new PreguntaDTO();
		pregunta.setId_pregunta(entity.getId_pregunta());
		pregunta.setPreg_imagen(entity.getPreg_imagen());
		pregunta.setPreg_descripcion(entity.getPreg_descripcion());
		pregunta.setPreg_estado(entity.getPreg_estado());
		return pregunta;
	}
	
	public Pregunta converterToEntity(@NotNull PreguntaDTO dto) {
		Pregunta pregunta = new Pregunta();
		pregunta.setId_pregunta(dto.getId_pregunta());
		pregunta.setPreg_imagen(dto.getPreg_imagen());
		pregunta.setPreg_descripcion(dto.getPreg_descripcion());
		pregunta.setPreg_estado(dto.getPreg_estado());
		return pregunta;
	}

}
