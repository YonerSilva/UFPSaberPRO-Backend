package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.converter.SubcategoriaConverter;
import com.ufps.UFPSaberPRO.dao.SubcategoriaRepository;
import com.ufps.UFPSaberPRO.dto.SubcatergoriaDTO;
import com.ufps.UFPSaberPRO.entity.Subcategoria;
import com.ufps.UFPSaberPRO.service.SubcategoriaService;

@Service
public class SubcategoriaServiceImpl implements SubcategoriaService{
	
	@Autowired
	private SubcategoriaRepository subcategoriaDao;

	@Override
	public SubcatergoriaDTO buscar(Long id_subcategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(SubcatergoriaDTO subcategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id_subcategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SubcatergoriaDTO> getSubcategorias() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
