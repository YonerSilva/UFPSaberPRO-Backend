package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.EstadisticaDTO;
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.dto.ResultadoDTO;
import com.ufps.UFPSaberPRO.dto.SimulacroDTO;

public interface SimulacroService {
	
	public SimulacroDTO buscar(Long id_simulacro);

	public void guardar(SimulacroDTO simulacro);
	
	public void update(SimulacroDTO simulacro);

	public void eliminar(Long id_simulacro);

	public List<SimulacroDTO> getSimulacros();
	
	public List<SimulacroDTO> getSimulacrosUsuPrg(Long id_usuario, Long id_programa);
	
	public List<SimulacroDTO> getSimulacrosConvo(Long usuario, String estado);
	
	public List<SimulacroDTO> getSimulacrosUsu(Long id_usuario);
	
	public ResultadoDTO getEstadisticasSimuUsu(Long id_simulacro, Long id_usuario, Long id_convocatoria);
	
	public void validarSimulacros();
}
