package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.PreguntaDTO;

public interface PreguntaService {
	
	public PreguntaDTO buscar(Long id_pregunta);

	public void guardar(PreguntaDTO pregunta);

	public void eliminar(Long id_pregunta);

	public List<PreguntaDTO> getPreguntas();
}
