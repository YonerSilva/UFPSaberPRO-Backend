package com.ufps.UFPSaberPRO.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.ufps.UFPSaberPRO.security.entity.Rol;
import com.ufps.UFPSaberPRO.security.dao.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
