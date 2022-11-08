package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.CategoriaDTO;

public interface CategoriaService {
	
	public CategoriaDTO buscar(Long id_categoria);

	public void guardar(CategoriaDTO categoria);

	public void eliminar(Long id_categoria);

	public List<CategoriaDTO> getCategorias();
	
	public List<CategoriaDTO> getCategoriasByUsuPrg(Long id_usuario,Long id_programa);
}
