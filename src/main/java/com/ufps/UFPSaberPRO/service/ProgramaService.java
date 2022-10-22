package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.ProgramaDTO;

public interface ProgramaService {
	
	public ProgramaDTO buscarPorId(Long id_programa);
	
	public ProgramaDTO buscarPorCodigo(String codigo);
	
	public void guardar(ProgramaDTO programa);
	
	public void eliminar(Long id_programa);
	
	public List<ProgramaDTO> getProgramas();
}
