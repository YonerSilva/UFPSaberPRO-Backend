package com.ufps.UFPSaberPRO.converter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ufps.UFPSaberPRO.dto.ProgramaDTO;
import com.ufps.UFPSaberPRO.entity.Programa;


@Component
public class ProgramaConverter {
	
	public ProgramaDTO converterToDTO(@NotNull Programa entity) {
		ProgramaDTO programa = new ProgramaDTO();
		programa.setId_programa(entity.getId_programa());
		programa.setPrg_nombre(entity.getPrg_nombre());
		programa.setPrg_codigo(entity.getPrg_codigo());
		programa.setPrg_email(entity.getPrg_email());
		return programa;
	}
	
	public Programa converterToEntity(@NotNull ProgramaDTO dto) {
		Programa programa = new Programa();
		programa.setId_programa(dto.getId_programa());
		programa.setPrg_nombre(dto.getPrg_nombre());
		programa.setPrg_codigo(dto.getPrg_codigo());
		programa.setPrg_email(dto.getPrg_email());
		return programa;
	}
}
