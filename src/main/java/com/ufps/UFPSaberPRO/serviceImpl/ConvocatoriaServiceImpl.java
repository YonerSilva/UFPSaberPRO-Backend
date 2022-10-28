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
	@Transactional
	public ConvocatoriaDTO buscar(Long id_convocatoria) {
		Convocatoria convo = convocatoriaDao.findById(id_convocatoria).get();
		ConvocatoriaDTO convocatoria = new ConvocatoriaConverter().converterToDTO(convo);
		return convocatoria;
	}

	@Override
	@Transactional
	public void guardar(ConvocatoriaDTO convocatoria) {
		Convocatoria convo = new ConvocatoriaConverter().converterToEntity(convocatoria);
		convocatoriaDao.save(convo);
	}

	@Override
	@Transactional
	public void eliminar(Long id_convocatoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<ConvocatoriaDTO> getConvocatorias() {
		List<ConvocatoriaDTO> convocatorias = new ArrayList<>();
		ConvocatoriaConverter converter = new ConvocatoriaConverter();
		for (Convocatoria convo : convocatoriaDao.findAll()) {
			convocatorias.add(converter.converterToDTO(convo));
		}
		return convocatorias;
	}
	
}
