package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.converter.ConvocatoriaConverter;
import com.ufps.UFPSaberPRO.dao.ConvocatoriaRepository;
import com.ufps.UFPSaberPRO.dto.ConvocatoriaDTO;
import com.ufps.UFPSaberPRO.entity.Convocatoria;
import com.ufps.UFPSaberPRO.service.ConvocatoriaService;

@Service
public class ConvocatoriaServiceImpl implements ConvocatoriaService{
	
	@Autowired
	private ConvocatoriaRepository convocatoriaDao;

	@Override
	public ConvocatoriaDTO buscar(Long id_convocatoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(ConvocatoriaDTO convocatoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id_convocatoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ConvocatoriaDTO> getConvocatorias() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
