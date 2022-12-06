package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import com.ufps.UFPSaberPRO.dto.Simu_UsuDTO;
import com.ufps.UFPSaberPRO.entity.Simu_Usu;
import com.ufps.UFPSaberPRO.entity.Simulacro;
import com.ufps.UFPSaberPRO.security.entity.Usuario;

public class Simu_UsuConverter {

	public Simu_UsuDTO converterToDTO(@NotNull Simu_Usu entity) {
		Simu_UsuDTO simu_usu = new Simu_UsuDTO();
		simu_usu.setId_simu_usu(entity.getId_simu_usu());
		simu_usu.setSimu_usu_presentado(entity.getSimu_usu_presentado());
		simu_usu.setSimu_usu_codigo(entity.getSimu_usu_codigo());
		simu_usu.setSimu_usu_puntaje_total(entity.getSimu_usu_puntaje_total());
		simu_usu.setSimulacro(entity.getSimulacro().getId_simulacro());
		simu_usu.setUsuario(entity.getUsuario().getId_usuario());
		return simu_usu;
	}
	
	public Simu_Usu converterEntity(@NotNull Simu_UsuDTO dto) {
		Simu_Usu simu_usu = new Simu_Usu();
		simu_usu.setId_simu_usu(dto.getId_simu_usu());
		simu_usu.setSimu_usu_presentado(dto.getSimu_usu_presentado());
		simu_usu.setSimu_usu_codigo(dto.getSimu_usu_codigo());
		simu_usu.setSimu_usu_puntaje_total(dto.getSimu_usu_puntaje_total());
		simu_usu.setSimulacro(new Simulacro(dto.getSimulacro()));
		simu_usu.setUsuario(new Usuario(dto.getUsuario()));
		return simu_usu;
	}
	
	
}
