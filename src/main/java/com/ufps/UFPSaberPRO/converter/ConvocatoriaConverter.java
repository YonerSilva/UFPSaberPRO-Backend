package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.ConvocatoriaDTO;
import com.ufps.UFPSaberPRO.entity.Convocatoria;
import com.ufps.UFPSaberPRO.entity.Programa;
import com.ufps.UFPSaberPRO.entity.Simulacro;


@Component
public class ConvocatoriaConverter {

	public ConvocatoriaDTO converterToDTO(@NotNull Convocatoria entity) {
		ConvocatoriaDTO convocatoria = new ConvocatoriaDTO();
		convocatoria.setId_convocatoria(entity.getId_convocatoria());
		convocatoria.setConvo_nombre(entity.getConvo_nombre());
		convocatoria.setConvo_descripcion(entity.getConvo_descripcion());
		convocatoria.setConvo_fechaInicial(entity.getConvo_fechaInicial());
		convocatoria.setConvo_fechaFinal(entity.getConvo_fechaFinal());
		convocatoria.setConvo_estado(entity.getConvo_estado());
		convocatoria.setPrograma(entity.getPrograma().getId_programa());
		convocatoria.setSimulacro(entity.getSimulacro().getId_simulacro());
		convocatoria.setUsu_creacion(entity.getUsu_creacion());
		return convocatoria;
	}
	
	public Convocatoria converterToEntity(@NotNull ConvocatoriaDTO dto) {
		Convocatoria convocatoria = new Convocatoria();
		convocatoria.setId_convocatoria(dto.getId_convocatoria());
		convocatoria.setConvo_nombre(dto.getConvo_nombre());
		convocatoria.setConvo_descripcion(dto.getConvo_descripcion());
		convocatoria.setConvo_fechaInicial(dto.getConvo_fechaInicial());
		convocatoria.setConvo_fechaFinal(dto.getConvo_fechaFinal());
		convocatoria.setConvo_estado(dto.getConvo_estado());
		convocatoria.setPrograma(new Programa(dto.getPrograma()));
		convocatoria.setSimulacro(new Simulacro(dto.getSimulacro()));
		convocatoria.setUsu_creacion(dto.getUsu_creacion());
		return convocatoria;
	}
}
