package com.ufps.UFPSaberPRO.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.UFPSaberPRO.dao.Simu_PregRepository;

@Service
public class Simu_PregServiceImpl {

	@Autowired 
	private Simu_PregRepository simu_pregDao;
}
