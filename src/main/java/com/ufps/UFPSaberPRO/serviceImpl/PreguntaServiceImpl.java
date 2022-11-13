package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
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
	@Transactional
	public PreguntaDTO buscar(Long id_pregunta) {
		Pregunta preg = preguntaDao.findById(id_pregunta).get();
		PreguntaDTO pregunta = new PreguntaConverter().converterToDTO(preg);
		return pregunta;
	}

	@Override
	@Transactional
	public PreguntaDTO guardar(PreguntaDTO pregunta) {
		PreguntaConverter converter = new PreguntaConverter();
		Pregunta preg = converter.converterToEntity(pregunta);
		return converter.converterToDTO(preguntaDao.save(preg));
	}
	
	@Override
	@Transactional
	public void actualizar(PreguntaDTO pregunta) {
		Pregunta preg = new PreguntaConverter().converterToEntity(pregunta);
		preguntaDao.update(preg.getId_pregunta(), preg.getPreg_imagen(), preg.getPreg_descripcion(),
				preg.getPreg_estado(), pregunta.getId_subcategoria());
	}

	@Override
	@Transactional
	public void eliminar(Long id_pregunta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<PreguntaDTO> getPreguntas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public List<PreguntaDTO> getPreguntasByUsuPrg(Long id_usuario, Long id_programa) {
		List<PreguntaDTO> preguntas = new ArrayList<>();
		PreguntaConverter converter = new PreguntaConverter();
		for (Pregunta preg : preguntaDao.findAllByUsuPrg(id_usuario,id_programa)) {
			preguntas.add(converter.converterToDTO(preg));
		}
		return preguntas;
	}
	
}
