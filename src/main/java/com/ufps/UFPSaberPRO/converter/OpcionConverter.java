package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.OpcionDTO;
import com.ufps.UFPSaberPRO.entity.Opcion;
import com.ufps.UFPSaberPRO.entity.Pregunta;


@Component
public class OpcionConverter {
	
	public OpcionDTO converterToDTO(@NotNull Opcion entity) {
		OpcionDTO opcion = new OpcionDTO();
		opcion.setId_opcion(entity.getId_opcion());
		opcion.setOpc_imagen(entity.getOpc_imagen());
		opcion.setOpc_orden(entity.getOpc_orden());
		opcion.setOpc_descripcion(entity.getOpc_descripcion());
		opcion.setOpc_respuesta(entity.getOpc_respuesta());
		opcion.setPregunta(entity.getPregunta().getId_pregunta());
		return opcion;
	}
	
	public Opcion converterToEntity(@NotNull OpcionDTO dto) {
		Opcion opcion = new Opcion();
		opcion.setId_opcion(dto.getId_opcion());
		opcion.setOpc_imagen(dto.getOpc_imagen());
		opcion.setOpc_orden(dto.getOpc_orden());
		opcion.setOpc_descripcion(dto.getOpc_descripcion());
		opcion.setOpc_respuesta(dto.getOpc_respuesta());
		opcion.setPregunta(new Pregunta(dto.getPregunta()));
		return opcion;
	}

}
