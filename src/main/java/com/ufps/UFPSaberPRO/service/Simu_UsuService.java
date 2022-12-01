package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.Simu_UsuDTO;
import com.ufps.UFPSaberPRO.entity.Simu_Usu;
import com.ufps.UFPSaberPRO.security.dto.UsuarioDTO;

public interface Simu_UsuService {
	
	public Simu_Usu guardar(Simu_UsuDTO simu_usu);
	
	public Simu_Usu actualizar(Simu_UsuDTO simu_usu);
	
	public void presentar_simulacro(Simu_UsuDTO simu_usu);
	
	public List<UsuarioDTO> getUsuariosSimu(Long id_simulacro, Long id_usuario);
}
