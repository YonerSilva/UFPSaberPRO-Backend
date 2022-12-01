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
import com.ufps.UFPSaberPRO.service.Rta_Simu_UsuService;
import com.ufps.UFPSaberPRO.service.Simu_UsuService;

@Service
public class Rta_Simu_UsuServiceImpl implements Rta_Simu_UsuService{

	@Autowired
	private Rta_Simu_UsuRepository rta_simu_usuDao;

	@Transactional
	@Override
	public Rta_Simu_Usu guardar(Rta_Simu_Usu rta_simu_usu) {
		return rta_simu_usuDao.save(rta_simu_usu);
	}
	
}
