package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.SimulacroDTO;
import com.ufps.UFPSaberPRO.entity.Simulacro;


@Component
public class SimulacroConverter {

	public SimulacroDTO converterToDTO(@NotNull Simulacro entity) {
		SimulacroDTO simulacro = new SimulacroDTO();
		simulacro.setId_simulacro(entity.getId_simulacro());
		simulacro.setSimu_nombre(entity.getSimu_nombre());
		simulacro.setSimu_descripcion(entity.getSimu_descripcion());
		simulacro.setSimu_puntaje_maximo(entity.getSimu_puntaje_maximo());
		simulacro.setSimu_estado(entity.getSimu_estado());
		simulacro.setPrograma(entity.getPrograma());
		return simulacro;
	}
	
	public Simulacro converterToEntity(@NotNull SimulacroDTO dto) {
		Simulacro simulacro = new Simulacro();
		simulacro.setId_simulacro(dto.getId_simulacro());
		simulacro.setSimu_nombre(dto.getSimu_nombre());
		simulacro.setSimu_descripcion(dto.getSimu_descripcion());
		simulacro.setSimu_puntaje_maximo(dto.getSimu_puntaje_maximo());
		simulacro.setSimu_estado(dto.getSimu_estado());
		simulacro.setPrograma(dto.getPrograma());
		return simulacro;
	}
}
