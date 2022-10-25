package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.converter.OpcionConverter;
import com.ufps.UFPSaberPRO.dao.OpcionRepository;
import com.ufps.UFPSaberPRO.dto.OpcionDTO;
import com.ufps.UFPSaberPRO.entity.Opcion;
import com.ufps.UFPSaberPRO.service.OpcionService;

@Service
public class OpcionServiceImpl implements OpcionService{
	
	@Autowired
	private OpcionRepository opcionDao;

	@Override
	public OpcionDTO buscar(Long id_opcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(OpcionDTO opcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id_opcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OpcionDTO> getOpciones() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
