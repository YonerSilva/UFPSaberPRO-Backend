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
}
