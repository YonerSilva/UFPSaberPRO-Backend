package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.RespuestaDTO;
import com.ufps.UFPSaberPRO.entity.Pregunta;
import com.ufps.UFPSaberPRO.entity.Respuesta;

@Component
public class RespuestaConverter {
	
	public RespuestaDTO converterToDTO(@NotNull Respuesta entity) {
		RespuestaDTO respuesta = new RespuestaDTO();
		respuesta.setId_respuesta(entity.getId_respuesta());
		respuesta.setPregunta(entity.getPregunta().getId_pregunta());
		respuesta.setOpciones(entity.getOpciones());
		respuesta.setRta_puntajeObtenido(entity.getRta_puntajeObtenido());
		return respuesta;
	}

	public Respuesta converterToEntity(@NotNull RespuestaDTO dto) {
		Respuesta respuesta = new Respuesta();
		respuesta.setId_respuesta(dto.getId_respuesta());
		respuesta.setPregunta(new Pregunta(dto.getId_respuesta()));
		respuesta.setOpciones(dto.getOpciones());
		respuesta.setRta_puntajeObtenido(dto.getRta_puntajeObtenido());
		return respuesta;
	}
}
