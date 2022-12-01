package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.RespuestaDTO;
import com.ufps.UFPSaberPRO.entity.Respuesta;

public interface RespuestaService {
	
	public RespuestaDTO buscar(Long id_respuesta);

	public Respuesta guardar(Respuesta respuesta);

	public void eliminar(Long id_respuesta);

	public List<RespuestaDTO> getRespuestas();
}
