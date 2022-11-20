package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.PreguntaDTO;

public interface Simu_PregService {

	public List<PreguntaDTO> getPreguntasBySimulacro(Long id_simulacro);
}
