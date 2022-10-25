package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.converter.PreguntaConverter;
import com.ufps.UFPSaberPRO.dao.PreguntaRepository;
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.entity.Pregunta;
import com.ufps.UFPSaberPRO.service.PreguntaService;

@Service
public class PreguntaServiceImpl implements PreguntaService{
	
	@Autowired
	private PreguntaRepository preguntaDao;

	@Override
	public PreguntaDTO buscar(Long id_pregunta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(PreguntaDTO pregunta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id_pregunta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PreguntaDTO> getPreguntas() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
