package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.UFPSaberPRO.dao.RespuestaRepository;
import com.ufps.UFPSaberPRO.dto.RespuestaDTO;
import com.ufps.UFPSaberPRO.service.RespuestaService;

@Service
public class RespuestaServiceImpl implements RespuestaService{

	@Autowired
	private RespuestaRepository respuestaDao;

	@Override
	public RespuestaDTO buscar(Long id_respuesta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(RespuestaDTO respuesta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id_respuesta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RespuestaDTO> getRespuestas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
