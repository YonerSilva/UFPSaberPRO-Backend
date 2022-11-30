package com.ufps.UFPSaberPRO.serviceImpl;

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
import com.ufps.UFPSaberPRO.service.Simu_UsuService;

@Service
public class Simu_UsuServiceImpl implements Simu_UsuService{

	@Autowired
	private Simu_UsuRepository simu_usuDao;
	
	@Autowired
	private RespuestaRepository respuestaDao;
	
	@Autowired
	private OpcionRepository opcionDao;
	
	@Autowired
	private Rta_Simu_UsuRepository rta_simu_usuDao;

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
		List<Opcion> opciones_preg;
		if(sm!=null) {
			Respuesta respuesta;
			OpcionDTO opcion = new OpcionDTO();
			Integer rta_puntaje = 0;
			Integer puntaje_total = 0;
			for (PreguntaDTO preg : simu_usu.getPreguntas_respondidas()) {
				opciones_preg = opcionDao.findAllByPregunta(preg.getId_pregunta());
				for (OpcionDTO opc : preg.getOpciones()) {
					if(opc.getOpc_respuesta()) {
						opcion = opc;
						break;
					}
				}
				
				for (Opcion opc : opciones_preg) {
					if(opc.getId_opcion()==opcion.getId_opcion()) {
						if(opc.getOpc_respuesta() && opcion.getOpc_respuesta()) {
							rta_puntaje = preg.getSimu_preg_puntaje();
							puntaje_total += rta_puntaje;
						}else {
							rta_puntaje = 0;
						}
					}
				}
				respuesta = respuestaDao.save(new Respuesta(new Pregunta(preg.getId_pregunta()), new Opcion(opcion.getId_opcion())));
				if(respuesta != null) {
					rta_simu_usuDao.save(new Rta_Simu_Usu(rta_puntaje, sm, new Pregunta(preg.getId_pregunta())));
					simu_usu.setSimu_usu_puntaje_total(puntaje_total);
					this.actualizar(simu_usu);
				}
			}
		}
		
	}
	
	
}
