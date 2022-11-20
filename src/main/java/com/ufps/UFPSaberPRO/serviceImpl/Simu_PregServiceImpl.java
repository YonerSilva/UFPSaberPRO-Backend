package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.dao.Simu_PregRepository;
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.service.Simu_PregService;

@Service
public class Simu_PregServiceImpl implements Simu_PregService{

	@Autowired 
	private Simu_PregRepository simu_pregDao;

	@Override
	@Transactional
	public List<PreguntaDTO> getPreguntasBySimulacro(Long id_simulacro) {
		List<PreguntaDTO> preguntas = simu_pregDao.findAllBySimulacro(id_simulacro);
		return preguntas;
	}
	
	@Override
	@Transactional
	public List<PreguntaDTO> getPreguntasByDifferentSimu(Long id_simulacro) {
		List<PreguntaDTO> preguntas = simu_pregDao.findAllByDifferentSimu(id_simulacro);
		return preguntas;
	}
}
