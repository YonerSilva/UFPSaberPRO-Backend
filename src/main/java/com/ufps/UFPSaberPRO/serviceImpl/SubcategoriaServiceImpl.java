package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.converter.CategoriaConverter;
import com.ufps.UFPSaberPRO.converter.SubcategoriaConverter;
import com.ufps.UFPSaberPRO.dao.SubcategoriaRepository;
import com.ufps.UFPSaberPRO.dto.CategoriaDTO;
import com.ufps.UFPSaberPRO.dto.SubcatergoriaDTO;
import com.ufps.UFPSaberPRO.entity.Categoria;
import com.ufps.UFPSaberPRO.entity.Subcategoria;
import com.ufps.UFPSaberPRO.service.SubcategoriaService;

@Service
public class SubcategoriaServiceImpl implements SubcategoriaService{
	
	@Autowired
	private SubcategoriaRepository subcategoriaDao;

	@Override
	@Transactional
	public SubcatergoriaDTO buscar(Long id_subcategoria) {
		Subcategoria sub = subcategoriaDao.findById(id_subcategoria).get();
		SubcatergoriaDTO subcategoria = new SubcategoriaConverter().converterToDTO(sub);
		return subcategoria;
	}

	@Override
	@Transactional
	public void guardar(SubcatergoriaDTO subcategoria) {
		Subcategoria sub = new SubcategoriaConverter().converterToEntity(subcategoria);
		subcategoriaDao.save(sub);
	}

	@Override
	@Transactional
	public void eliminar(Long id_subcategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<SubcatergoriaDTO> getSubcategorias() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public List<SubcatergoriaDTO> getSubcategoriasByUsuCate(Long id_usuario,Long id_categoria) {
		List<SubcatergoriaDTO> subcategorias = new ArrayList<>();
		SubcategoriaConverter converter = new SubcategoriaConverter();
		for (Subcategoria sub : subcategoriaDao.findAllByUsuCate(id_usuario,id_categoria)) {
			subcategorias.add(converter.converterToDTO(sub));
		}
		return subcategorias;
	}
	
	@Override
	@Transactional
	public List<SubcatergoriaDTO> getSubcategoriasByUsuPrg(Long id_usuario,Long id_programa) {
		List<SubcatergoriaDTO> subcategorias = new ArrayList<>();
		SubcategoriaConverter converter = new SubcategoriaConverter();
		for (Subcategoria sub : subcategoriaDao.findAllByUsuPrg(id_usuario,id_programa)) {
			subcategorias.add(converter.converterToDTO(sub));
		}
		return subcategorias;
	}
}
