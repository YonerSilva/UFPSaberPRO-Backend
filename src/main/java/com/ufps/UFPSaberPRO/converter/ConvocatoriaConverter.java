package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.ConvocatoriaDTO;
import com.ufps.UFPSaberPRO.entity.Convocatoria;


@Component
public class ConvocatoriaConverter {

	public ConvocatoriaDTO converterToDTO(@NotNull Convocatoria entity) {
		ConvocatoriaDTO convocatoria = new ConvocatoriaDTO();
		convocatoria.setId_convocatoria(entity.getId_convocatoria());
		convocatoria.setConvo_nombre(entity.getConvo_nombre());
		convocatoria.setConvo_descripcion(entity.getConvo_descripcion());
		convocatoria.setConvo_fechaInicial(entity.getConvo_fechaInicial());
		convocatoria.setConvo_fechaFinal(entity.getConvo_fechaFinal());
		convocatoria.setConvo_estado(entity.getConvo_estado);
		convocatoria.setConvo_fechaCreacion(entity.getConvo_fechaCreacion());
		return convocatoria;
	}
	
	public Convocatoria converterToEntity(@NotNull ConvocatoriaDTO dto) {
		Convocatoria convocatoria = new Convocatoria();
		convocatoria.setId_convocatoria(dto.getId_convocatoria());
		convocatoria.setConvo_nombre(dto.getConvo_nombre());
		convocatoria.setConvo_descripcion(dto.getConvo_descripcion());
		convocatoria.setConvo_fechaInicial(dto.getConvo_fechaInicial());
		convocatoria.setConvo_fechaFinal(dto.getConvo_fechaFinal());
		convocatoria.setConvo_estado(dto.getConvo_estado);
		return convocatoria;
	}
}
