package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.SubcatergoriaDTO;

public interface SubcategoriaService {
	
	public SubcatergoriaDTO buscar(Long id_subcategoria);

	public void guardar(SubcatergoriaDTO subcategoria);

	public void eliminar(Long id_subcategoria);

	public List<SubcatergoriaDTO> getSubcategorias();
}
