package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.converter.CategoriaConverter;
import com.ufps.UFPSaberPRO.dao.CategoriaRepository;
import com.ufps.UFPSaberPRO.dto.CategoriaDTO;
import com.ufps.UFPSaberPRO.entity.Categoria;
import com.ufps.UFPSaberPRO.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaDao;

	@Override
	public CategoriaDTO buscar(Long id_categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(CategoriaDTO categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id_categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoriaDTO> getCategorias() {
		// TODO Auto-generated method stub
		return null;
	}
}
