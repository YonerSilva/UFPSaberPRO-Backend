package com.ufps.UFPSaberPRO.security.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.ufps.UFPSaberPRO.security.dao.RoleRepository;
import com.ufps.UFPSaberPRO.security.entity.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
    @Autowired
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    
    public List<Rol> getRoles(){
    	return roleRepository.findAll();
    }
}
