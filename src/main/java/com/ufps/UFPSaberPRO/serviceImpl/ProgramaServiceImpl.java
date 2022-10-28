package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.converter.ProgramaConverter;
import com.ufps.UFPSaberPRO.dao.ProgramaRepository;
import com.ufps.UFPSaberPRO.dto.ProgramaDTO;
import com.ufps.UFPSaberPRO.entity.Programa;
import com.ufps.UFPSaberPRO.service.ProgramaService;

@Service
public class ProgramaServiceImpl implements ProgramaService{
	
	@Autowired
	private ProgramaRepository programaDao;
	
	@Override
	public ProgramaDTO buscarPorId(Long id_programa){
		Programa prg = programaDao.findById(id_programa).get();
		ProgramaDTO programa = new ProgramaConverter().converterToDTO(prg);
		return programa;
	}
	
	@Override
	public ProgramaDTO buscarPorCodigo(String codigo){
		Programa prg = programaDao.findByPrg_codigo(codigo);
		ProgramaDTO programa = new ProgramaConverter().converterToDTO(prg);
		return programa;
	}

	@Transactional
	@Override
	public void update(ProgramaDTO programa) {
		Programa prg = new ProgramaConverter().converterToEntity(programa);
		programaDao.update(prg.getId_programa(),prg.getPrg_codigo(), prg.getPrg_email(), prg.getPrg_nombre());
	}
	
	@Transactional
	@Override
	public void guardar(ProgramaDTO programa) {
		Programa prg = new ProgramaConverter().converterToEntity(programa);
		programaDao.save(prg);
	}

	@Transactional
	@Override
	public void eliminar(Long id_programa) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public List<ProgramaDTO> getProgramas() {
		List<ProgramaDTO> programas = new ArrayList<>();
		ProgramaConverter converter = new ProgramaConverter();
		for (Programa prg : programaDao.findAll()) {
			programas.add(converter.converterToDTO(prg));
		}
		return programas;
	}

}
