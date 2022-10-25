package com.ufps.UFPSaberPRO.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.UFPSaberPRO.dao.Simu_UsuRepository;

@Service
public class Simu_UsuServiceImpl {

	@Autowired
	private Simu_UsuRepository simu_usuDao;
}
