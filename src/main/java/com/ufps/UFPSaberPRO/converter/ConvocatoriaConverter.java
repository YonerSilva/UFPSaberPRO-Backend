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
		convocatoria.setConvo_fecha_inicial(entity.getConvo_fecha_inicial());
		convocatoria.setConvo_fecha_final(entity.getConvo_fecha_final());
		convocatoria.setConvo_estado(entity.getConvo_estado());
		convocatoria.setPrograma(entity.getPrograma().getId_programa());
		convocatoria.setSimulacro(entity.getSimulacro());
		convocatoria.setUsu_creacion(entity.getUsu_creacion());
		return convocatoria;
	}
	
	public Convocatoria converterToEntity(@NotNull ConvocatoriaDTO dto) {
		Convocatoria convocatoria = new Convocatoria();
		convocatoria.setId_convocatoria(dto.getId_convocatoria());
		convocatoria.setConvo_nombre(dto.getConvo_nombre());
		convocatoria.setConvo_descripcion(dto.getConvo_descripcion());
		convocatoria.setConvo_fecha_inicial(dto.getConvo_fecha_inicial());
		convocatoria.setConvo_fecha_final(dto.getConvo_fecha_final());
		convocatoria.setConvo_estado(dto.getConvo_estado());
		convocatoria.setPrograma(new Programa(dto.getPrograma()));
		convocatoria.setSimulacro(dto.getSimulacro());
		convocatoria.setUsu_creacion(dto.getUsu_creacion());
		return convocatoria;
	}
}
