package com.ufps.UFPSaberPRO.dto;

import java.util.ArrayList;
import java.util.List;

import com.ufps.UFPSaberPRO.security.dto.UsuarioDTO;
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
	
	/**
	 * Datos de las categorias por programa (ADMINISTRADOR) de la aplicación.
	 */
	private List<CategoriaDTO> categorias_programa;
	
	
	/**
	 * Datos de las subcategorias por programa (ADMINISTRADOR) de la aplicación.
	 */
	private List<SubcatergoriaDTO> subcategorias_programa;
	
	/**
	 * Datos de las preguntas por programa (ADMINISTRADOR) de la aplicación.
	 */
	private List<PreguntaDTO> preguntas_programa;
	
	/**
	 * Datos de los usuarios por programa (ADMINISTRADOR) de la aplicación.
	 */
	private List<UsuarioDTO> usuarios_programa;
	
	
	
	
	/**
	 * Datos de las convocatorias activas por programa (ESTUDIANTE) de la aplicación.
	 */
	private List<ConvocatoriaDTO> convocatorias_activa;
	
	/**
	 * Datos de las convocatorias en las cuales se ha registrado un usuario (ESTUDIANTE) de la aplicación.
	 */
	private List<ConvocatoriaDTO> convocatorias_usuario;
	
	/**
	 * Datos de los simulacros vinculados a una convocatoria y a un usuario (ESTUDIANTE) de la aplicación.
	 */
	private List<SimulacroDTO> simulacros_usuario;
	
	public DatogeneralDTO() {
		roles = new ArrayList<>();
		programas = new ArrayList<>();
		convocatorias_programa = new ArrayList<>();
		simulacros_programa = new ArrayList<>();
		categorias_programa = new ArrayList<>();
		subcategorias_programa = new ArrayList<>();
		preguntas_programa = new ArrayList<>();
		usuarios_programa = new ArrayList<>();
		convocatorias_activa = new ArrayList<>();
		convocatorias_usuario = new ArrayList<>();
		simulacros_usuario = new ArrayList<>();
	}
}
