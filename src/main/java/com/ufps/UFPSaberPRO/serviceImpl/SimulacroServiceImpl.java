package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ufps.UFPSaberPRO.converter.SimulacroConverter;
import com.ufps.UFPSaberPRO.dao.SimulacroRepository;
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.dto.SimulacroDTO;
import com.ufps.UFPSaberPRO.entity.Simulacro;
import com.ufps.UFPSaberPRO.security.dto.UsuarioDTO;
import com.ufps.UFPSaberPRO.security.entity.Usuario;
import com.ufps.UFPSaberPRO.service.SimulacroService;

@Service
public class SimulacroServiceImpl implements SimulacroService{
	
	@Autowired
	private SimulacroRepository simulacroDao;

	@Transactional
	@Override
	public SimulacroDTO buscar(Long id_simulacro) {
		Simulacro simu = simulacroDao.findById(id_simulacro).get();
		SimulacroDTO simulacro = new SimulacroConverter().converterToDTO(simu);
		return simulacro;
	}

	@Transactional
	@Override
	public void guardar(SimulacroDTO simulacro) {
		Simulacro simu = new SimulacroConverter().converterToEntity(simulacro);
		simulacroDao.save(simu);
	}
	
	@Transactional
	@Override
	public void update(SimulacroDTO simulacro) {
		Simulacro s = new SimulacroConverter().converterToEntity(simulacro);
		simulacroDao.update(s.getId_simulacro(), s.getSimu_nombre(), s.getSimu_descripcion(),
				s.getSimu_puntaje_maximo(), s.getSimu_estado(), s.getPrograma());
	}

	@Transactional
	@Override
	public void eliminar(Long id_simulacro) {
		// TODO Auto-generated method stub
	}

	@Transactional
	@Override
	public List<SimulacroDTO> getSimulacros() {
		List<SimulacroDTO> simulacros = new ArrayList<>();
		SimulacroConverter converter = new SimulacroConverter();
		for (Simulacro simu : simulacroDao.findAll()) {
			simulacros.add(converter.converterToDTO(simu));
		}
		return simulacros;
	}
	
	@Transactional
	@Override
	public List<SimulacroDTO> getSimulacrosUsuPrg(Long id_usuario, Long id_programa) {
		List<SimulacroDTO> simulacros = new ArrayList<>();
		SimulacroConverter converter = new SimulacroConverter();
		for (Simulacro simu : simulacroDao.findAllByUsuPrg(id_usuario, id_programa)) {
			simulacros.add(converter.converterToDTO(simu));
		}
		return simulacros;
	}
	
	@Transactional
	@Override
	public List<SimulacroDTO> getSimulacrosConvo(Long id_usuario, String estado) {
		return simulacroDao.findAllByConvoUsuEst(new Usuario(id_usuario), estado);
	}
}
