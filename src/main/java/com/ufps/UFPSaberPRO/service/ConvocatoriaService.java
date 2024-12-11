package com.ufps.UFPSaberPRO.service;

import java.util.List;

import com.ufps.UFPSaberPRO.dto.Convo_UsuDTO;
import com.ufps.UFPSaberPRO.dto.ConvocatoriaDTO;

public interface ConvocatoriaService {
	
	public ConvocatoriaDTO buscar(Long id_convocatoria);

	public void guardar(ConvocatoriaDTO convocatoria);
	
	public void guardarUsuario(Convo_UsuDTO convo_usu);
	
	public void update(ConvocatoriaDTO convocatoria);

	public void eliminar(Long id_convocatoria);

	public List<ConvocatoriaDTO> getConvocatorias();
	
	public List<ConvocatoriaDTO> getConvocatoriasByUsuPrg(Long id_usuario,Long id_programa);
	
	public List<ConvocatoriaDTO> getConvocatoriasByUsu(Long id_usuario);
	
	public List<ConvocatoriaDTO> getConvocatoriasByPrgEstUsu(Long usuario, Long programa, String estado);
	
	public void validarConvocatorias();

}
