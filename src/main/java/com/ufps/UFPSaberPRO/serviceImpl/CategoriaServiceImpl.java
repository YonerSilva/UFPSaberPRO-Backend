package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
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
	@Transactional
	public CategoriaDTO buscar(Long id_categoria) {
		Categoria cate = categoriaDao.findById(id_categoria).get();
		CategoriaDTO categoria = new CategoriaConverter().converterToDTO(cate);
		return categoria;
	}

	@Override
	@Transactional
	public void guardar(CategoriaDTO categoria) {
		Categoria cate = new CategoriaConverter().converterToEntity(categoria);
		categoriaDao.save(cate);
	}

	@Override
	@Transactional
	public void eliminar(Long id_categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<CategoriaDTO> getCategorias() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public List<CategoriaDTO> getCategoriasByUsuPrg(Long id_usuario,Long id_programa) {
		List<CategoriaDTO> categorias = new ArrayList<>();
		CategoriaConverter converter = new CategoriaConverter();
		for (Categoria cate : categoriaDao.findAllByUsuPrg(id_usuario,id_programa)) {
			categorias.add(converter.converterToDTO(cate));
		}
		return categorias;
	}
}
