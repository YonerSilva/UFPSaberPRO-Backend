package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.converter.ConvocatoriaConverter;
import com.ufps.UFPSaberPRO.dao.ConvocatoriaRepository;
import com.ufps.UFPSaberPRO.dto.Convo_UsuDTO;
import com.ufps.UFPSaberPRO.dto.ConvocatoriaDTO;
import com.ufps.UFPSaberPRO.entity.Convocatoria;
import com.ufps.UFPSaberPRO.security.entity.Usuario;
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
	public void guardarUsuario(Convo_UsuDTO convo_usu) {
		convocatoriaDao.guardarUsuario(convo_usu.getId_convocatoria(), convo_usu.getId_usuario());
	}
	
	@Override
	@Transactional
	public void update(ConvocatoriaDTO convocatoria) {
		Convocatoria convo = new ConvocatoriaConverter().converterToEntity(convocatoria);
		convocatoriaDao.update(convo.getId_convocatoria(), convo.getConvo_nombre(), convo.getConvo_descripcion(),
				convo.getConvo_fecha_inicial(), convo.getConvo_fecha_final(), convo.getConvo_estado(), 
				convo.getPrograma().getId_programa(), convocatoria.getSimulacro(), convo.getSimu_fecha_inicial(), convo.getSimu_duracion());
	}

	@Override
	@Transactional
	public void eliminar(Long id_convocatoria) {
		convocatoriaDao.delete(id_convocatoria);
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
	
	@Override
	@Transactional
	public List<ConvocatoriaDTO> getConvocatoriasByUsuPrg(Long id_usuario,Long id_programa) {
		List<ConvocatoriaDTO> convocatorias = new ArrayList<>();
		ConvocatoriaConverter converter = new ConvocatoriaConverter();
		for (Convocatoria convo : convocatoriaDao.findAllByUsuPrg(id_usuario,id_programa)) {
			convocatorias.add(converter.converterToDTO(convo));
		}
		return convocatorias;
	}
	
	@Override
	@Transactional
	public List<ConvocatoriaDTO> getConvocatoriasByUsu(Long id_usuario) {
		List<ConvocatoriaDTO> convocatorias = new ArrayList<>();
		ConvocatoriaConverter converter = new ConvocatoriaConverter();
		for (Convocatoria convo : convocatoriaDao.findAllByUsuario(id_usuario)) {
			convocatorias.add(converter.converterToDTO(convo));
		}
		return convocatorias;
	}
	
	@Override
	@Transactional
	public List<ConvocatoriaDTO> getConvocatoriasByPrgEstUsu(Long usuario,Long programa, String estado) {
		List<ConvocatoriaDTO> convocatorias = new ArrayList<>();
		ConvocatoriaConverter converter = new ConvocatoriaConverter();
		for (Convocatoria convo : convocatoriaDao.findAllByPrgEstUsu(usuario,programa, estado)) {
			convocatorias.add(converter.converterToDTO(convo));
		}
		return convocatorias;
	}
}
