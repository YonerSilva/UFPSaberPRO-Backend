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
		simulacro.setSimu_puntajeMaximo(entity.getSimu_puntajeMaximo());
		simulacro.setSimu_fechaInicial(entity.getSimu_fechaInicial());
		simulacro.setSimu_fechaFinal(entity.getSimu_fechaFinal());
		simulacro.setSimu_duracion(entity.getSimu_duracion());
		simulacro.setSimu_estado(entity.getSimu_estado());
		//simulacro.setSimu_fechaCreacion(entity.getSimu_fechaCreacion());
		return simulacro;
	}
	
	public Simulacro converterToEntity(@NotNull SimulacroDTO dto) {
		Simulacro simulacro = new Simulacro();
		simulacro.setId_simulacro(dto.getId_simulacro());
		simulacro.setSimu_nombre(dto.getSimu_nombre());
		simulacro.setSimu_descripcion(dto.getSimu_descripcion());
		simulacro.setSimu_puntajeMaximo(dto.getSimu_puntajeMaximo());
		simulacro.setSimu_fechaInicial(dto.getSimu_fechaInicial());
		simulacro.setSimu_fechaFinal(dto.getSimu_fechaFinal());
		simulacro.setSimu_duracion(dto.getSimu_duracion());
		simulacro.setSimu_estado(dto.getSimu_estado());
		return simulacro;
	}
}
