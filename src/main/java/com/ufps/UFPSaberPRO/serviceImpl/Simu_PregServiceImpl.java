package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.converter.PreguntaConverter;
import com.ufps.UFPSaberPRO.converter.SubcategoriaConverter;
import com.ufps.UFPSaberPRO.dao.Simu_PregRepository;
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.dto.Simu_PregDTO;
import com.ufps.UFPSaberPRO.entity.Pregunta;
import com.ufps.UFPSaberPRO.entity.Simu_Preg;
import com.ufps.UFPSaberPRO.entity.Simulacro;
import com.ufps.UFPSaberPRO.service.Simu_PregService;

@Service
public class Simu_PregServiceImpl implements Simu_PregService{

	@Autowired 
	private Simu_PregRepository simu_pregDao;

	@Override
	public void guardar(Simu_PregDTO simu_preg) {
		Long id_simulacro = simu_preg.getSimulacro();
		Simu_Preg dato;
		for (PreguntaDTO pregunta : simu_preg.getPreguntas()) {
			dato = new Simu_Preg();
			dato.setSimulacro(new Simulacro(id_simulacro));
			dato.setPregunta(new PreguntaConverter().converterToEntity(pregunta));
			dato.setSimu_preg_puntaje(pregunta.getSimu_preg_puntaje());
			simu_pregDao.save(dato);
		}
	}
}
