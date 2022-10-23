package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.converter.SimulacroConverter;
import com.ufps.UFPSaberPRO.dao.SimulacroRepository;
import com.ufps.UFPSaberPRO.dto.SimulacroDTO;
import com.ufps.UFPSaberPRO.entity.Simulacro;
import com.ufps.UFPSaberPRO.service.SimulacroService;

@Service
public class SimulacroServiceImpl implements SimulacroService{
	
	@Autowired
	private SimulacroRepository simulacroDao;
	
	
}
