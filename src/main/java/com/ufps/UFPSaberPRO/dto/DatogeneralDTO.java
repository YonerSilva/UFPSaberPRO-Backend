package com.ufps.UFPSaberPRO.dto;

import java.util.List;

import com.ufps.UFPSaberPRO.security.entity.Rol;

import lombok.Data;

@Data
public class DatogeneralDTO {
	
	/**
	 * Datos del Registro de la aplicación.
	 */
	private List<Rol> roles; 
	private List<ProgramaDTO> programas; 
	
	/**
	 * Datos de las convocatorias por programa (ADMINISTRADOR) de la aplicación.
	 */
	private List<ConvocatoriaDTO> convocatorias_programa;
	
	/**
	 * Datos de los simulacros por programa (ADMINISTRADOR) de la aplicación.
	 */
	private List<SimulacroDTO> simulacros_programa;
}
