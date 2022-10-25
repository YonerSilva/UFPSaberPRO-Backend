package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.RespuestaDTO;

public interface RespuestaService {
	
	public RespuestaDTO buscar(Long id_respuesta);

	public void guardar(RespuestaDTO respuesta);

	public void eliminar(Long id_respuesta);

	public List<RespuestaDTO> getRespuestas();
}
