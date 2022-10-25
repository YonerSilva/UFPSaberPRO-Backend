package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.SimulacroDTO;

public interface SimulacroService {
	
	public SimulacroDTO buscar(Long id_simulacro);

	public void guardar(SimulacroDTO simulacro);

	public void eliminar(Long id_simulacro);

	public List<SimulacroDTO> getSimulacros();
}
