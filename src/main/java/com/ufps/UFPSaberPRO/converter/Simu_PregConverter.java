package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import com.ufps.UFPSaberPRO.dto.Simu_PregDTO;
import com.ufps.UFPSaberPRO.entity.Pregunta;
import com.ufps.UFPSaberPRO.entity.Simu_Preg;
import com.ufps.UFPSaberPRO.entity.Simulacro;

public class Simu_PregConverter {

	public Simu_PregDTO converterToDTO(@NotNull Simu_Preg entity) {
		Simu_PregDTO simu_preg = new Simu_PregDTO();
		simu_preg.setId_simu_preg(entity.getId_simu_preg());
		simu_preg.setSimu_usu_puntaje(entity.getSimu_preg_puntaje());
		simu_preg.setSimulacro(entity.getSimulacro().getId_simulacro());
		simu_preg.setPregunta(entity.getPregunta().getId_pregunta());
		return simu_preg;
	}
	
	public Simu_Preg converterToEntity(@NotNull Simu_PregDTO dto) {
		Simu_Preg simu_preg = new Simu_Preg();
		simu_preg.setId_simu_preg(dto.getId_simu_preg());
		simu_preg.setSimu_preg_puntaje(dto.getSimu_usu_puntaje());
		simu_preg.setSimulacro(new Simulacro(dto.getSimulacro()));
		simu_preg.setPregunta(new Pregunta(dto.getPregunta()));
		return simu_preg;
	}
}
