package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.OpcionDTO;

public interface OpcionService {
	
	public OpcionDTO buscar(Long id_opcion);

	public void guardar(OpcionDTO opcion);

	public void eliminar(Long id_opcion);

	public List<OpcionDTO> getOpciones();
	
}
