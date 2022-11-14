package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.converter.OpcionConverter;
import com.ufps.UFPSaberPRO.converter.PreguntaConverter;
import com.ufps.UFPSaberPRO.dao.OpcionRepository;
import com.ufps.UFPSaberPRO.dto.OpcionDTO;
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.entity.Opcion;
import com.ufps.UFPSaberPRO.entity.Pregunta;
import com.ufps.UFPSaberPRO.service.OpcionService;

@Service
public class OpcionServiceImpl implements OpcionService{
	
	@Autowired
	private OpcionRepository opcionDao;

	@Override
	public OpcionDTO buscar(Long id_opcion) {
		Opcion opc = opcionDao.findById(id_opcion).get();
		OpcionDTO opcion = new OpcionConverter().converterToDTO(opc);
		return opcion;
	}

	@Override
	public OpcionDTO guardar(OpcionDTO opcion) {
		OpcionConverter converter = new OpcionConverter();
		Opcion opc = converter.converterToEntity(opcion);
		return converter.converterToDTO(opcionDao.save(opc));
	}
	
	@Override
	public void actualizar(OpcionDTO opcion) {
		Opcion opc = new OpcionConverter().converterToEntity(opcion);
		opcionDao.update(opc.getId_opcion(), opc.getOpc_imagen(), opc.getOpc_descripcion(),
				opc.getOpc_respuesta());
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
	
	@Override
	public List<OpcionDTO> getOpcionesByPregunta(Long id_pregunta) {
		List<OpcionDTO> opciones = new ArrayList<>();
		OpcionConverter converter = new OpcionConverter();
		for (Opcion opc : opcionDao.findAllByPregunta(id_pregunta)) {
			opciones.add(converter.converterToDTO(opc));
		}
		return opciones;
	}
}
