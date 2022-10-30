package com.ufps.UFPSaberPRO.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.ConvocatoriaDTO;
import com.ufps.UFPSaberPRO.entity.Convocatoria;
import com.ufps.UFPSaberPRO.entity.Programa;
import com.ufps.UFPSaberPRO.entity.Simulacro;
import com.ufps.UFPSaberPRO.security.converter.UsuarioConverter;
import com.ufps.UFPSaberPRO.security.dto.UsuarioDTO;
import com.ufps.UFPSaberPRO.security.entity.Usuario;


@Component
public class ConvocatoriaConverter {

	public ConvocatoriaDTO converterToDTO(@NotNull Convocatoria entity) {
		ConvocatoriaDTO convocatoria = new ConvocatoriaDTO();
		convocatoria.setId_convocatoria(entity.getId_convocatoria());
		convocatoria.setConvo_nombre(entity.getConvo_nombre());
		convocatoria.setConvo_descripcion(entity.getConvo_descripcion());
		convocatoria.setConvo_fecha_inicial(entity.getConvo_fecha_inicial());
		convocatoria.setConvo_fecha_final(entity.getConvo_fecha_final());
		convocatoria.setConvo_estado(entity.getConvo_estado());
		convocatoria.setPrograma(entity.getPrograma().getId_programa());
		convocatoria.setSimulacro(entity.getSimulacro()!=null?entity.getSimulacro().getId_simulacro():null);
		List<UsuarioDTO> usuarios = new ArrayList<>();
		for (Usuario user : entity.getUsuarios()) {
			usuarios.add(new UsuarioConverter().converterToDTO(user));
		}
		convocatoria.setUsuarios(usuarios);
		convocatoria.setUsu_creacion(entity.getUsu_creacion());
		return convocatoria;
	}
	
	public Convocatoria converterToEntity(@NotNull ConvocatoriaDTO dto) {
		Convocatoria convocatoria = new Convocatoria();
		convocatoria.setId_convocatoria(dto.getId_convocatoria());
		convocatoria.setConvo_nombre(dto.getConvo_nombre());
		convocatoria.setConvo_descripcion(dto.getConvo_descripcion());
		convocatoria.setConvo_fecha_inicial(dto.getConvo_fecha_inicial());
		convocatoria.setConvo_fecha_final(dto.getConvo_fecha_final());
		convocatoria.setConvo_estado(dto.getConvo_estado());
		convocatoria.setPrograma(new Programa(dto.getPrograma()));
		if(dto.getSimulacro()!=null) {
			convocatoria.setSimulacro(new Simulacro(dto.getSimulacro()));
		}
		convocatoria.setUsu_creacion(dto.getUsu_creacion());
		return convocatoria;
	}
}
