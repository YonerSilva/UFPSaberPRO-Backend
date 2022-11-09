package com.ufps.UFPSaberPRO.security.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.ufps.UFPSaberPRO.security.dao.RolRepository;
import com.ufps.UFPSaberPRO.security.entity.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
    @Autowired
    private final RolRepository rolRepository;

    public RoleService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    
    public List<Rol> getRoles(){
    	return rolRepository.findAll();
    }
}
