package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.PreguntaDTO;

public interface PreguntaService {
	
	public PreguntaDTO buscar(Long id_pregunta);

	public PreguntaDTO guardar(PreguntaDTO pregunta);
	
	public void actualizar(PreguntaDTO pregunta);

	public void eliminar(Long id_pregunta);

	public List<PreguntaDTO> getPreguntas();
	
	public List<PreguntaDTO> getPreguntasByUsuPrg(Long id_usuario, Long id_programa);
	
	public List<PreguntaDTO> getPreguntasBySimulacro(Long id_simulacro);
	
	public List<PreguntaDTO> getPreguntasByDifferentSimu(Long id_simulacro);
}
