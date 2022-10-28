package com.ufps.UFPSaberPRO.security.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.ProgramaDTO;
import com.ufps.UFPSaberPRO.entity.Programa;
import com.ufps.UFPSaberPRO.security.dto.UsuarioDTO;
import com.ufps.UFPSaberPRO.security.entity.Usuario;


@Component
public class UsuarioConverter {
	
	public UsuarioDTO converterToDTO(@NotNull Usuario entity) {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setId_usuario(entity.getId_usuario());
		usuario.setCod_programa(entity.getPrograma().getPrg_codigo());
		usuario.setUsu_codigo(entity.getUsu_codigo());
		usuario.setUsu_nombre(entity.getUsu_nombre());
		usuario.setUsu_apellido(entity.getUsu_apellido());
		usuario.setUsu_email(entity.getUsu_email());
		return usuario;
	}
	
}
