package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.converter.Simu_UsuConverter;
import com.ufps.UFPSaberPRO.dao.OpcionRepository;
import com.ufps.UFPSaberPRO.dao.RespuestaRepository;
import com.ufps.UFPSaberPRO.dao.Rta_Simu_UsuRepository;
import com.ufps.UFPSaberPRO.dao.Simu_UsuRepository;
import com.ufps.UFPSaberPRO.dto.OpcionDTO;
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.dto.Simu_UsuDTO;
import com.ufps.UFPSaberPRO.entity.Opcion;
import com.ufps.UFPSaberPRO.entity.Pregunta;
import com.ufps.UFPSaberPRO.entity.Respuesta;
import com.ufps.UFPSaberPRO.entity.Rta_Simu_Usu;
import com.ufps.UFPSaberPRO.entity.Simu_Usu;
import com.ufps.UFPSaberPRO.security.converter.UsuarioConverter;
import com.ufps.UFPSaberPRO.security.dto.UsuarioDTO;
import com.ufps.UFPSaberPRO.security.entity.Usuario;
import com.ufps.UFPSaberPRO.service.Simu_UsuService;

@Service
public class Simu_UsuServiceImpl implements Simu_UsuService{

	@Autowired
	private Simu_UsuRepository simu_usuDao;
	
	@Autowired
	private RespuestaServiceImpl respuestaService;
	
	@Autowired
	private OpcionServiceImpl opcionService;
	
	@Autowired
	private Rta_Simu_UsuServiceImpl rta_simu_usuService;

	@Transactional
	@Override
	public Simu_Usu guardar(Simu_UsuDTO simu_usu) {
		return simu_usuDao.save(new Simu_UsuConverter().converterEntity(simu_usu));
	}

	@Transactional
	@Override
	public Simu_Usu actualizar(Simu_UsuDTO simu_usu) {
		return simu_usuDao.save(new Simu_UsuConverter().converterEntity(simu_usu));
	}

	@Transactional
	@Override
	public void presentar_simulacro(Simu_UsuDTO simu_usu) {
		Simu_Usu sm = this.guardar(simu_usu);
		List<OpcionDTO> opciones_preg;
		if(sm!=null) {
			Integer puntaje_total = 0;
			for (PreguntaDTO preg : simu_usu.getPreguntas_respondidas()) {
				Respuesta respuesta;
				OpcionDTO opcion = null;
				Integer rta_puntaje = 0;
				
				opciones_preg = opcionService.getOpcionesByPregunta(preg.getId_pregunta());
				for (OpcionDTO opc : preg.getOpciones()) {
					if(opc.getOpc_respuesta()) {
						opcion = opc;
						break;
					}
				}
				
				if(opcion!=null) {
					for (OpcionDTO opc : opciones_preg) {
						if(opc.getId_opcion()==opcion.getId_opcion()) {
							if(opc.getOpc_respuesta() && opcion.getOpc_respuesta()) {
								rta_puntaje = preg.getSimu_preg_puntaje();
								puntaje_total += rta_puntaje;
							}
						}
					}
					respuesta = respuestaService.guardar(new Respuesta(new Pregunta(preg.getId_pregunta()), new Opcion(opcion.getId_opcion())));
					if(respuesta != null) {
						rta_simu_usuService.guardar(new Rta_Simu_Usu(rta_puntaje, sm, respuesta));
					}
				}
			}
			sm.setSimu_usu_puntaje_total(puntaje_total);
			simu_usuDao.save(sm);
		}
		
	}

	@Override
	public List<UsuarioDTO> getUsuariosSimu(Long id_simulacro) {
		List<UsuarioDTO> usuarios = new ArrayList<>();
		UsuarioConverter converter = new UsuarioConverter();
		for (Usuario user : simu_usuDao.getUsuariosSimu(id_simulacro)) {
			usuarios.add(converter.converterToDTO(user));
		}
		return usuarios;
	}
	
	
}
