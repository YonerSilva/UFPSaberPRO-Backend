package com.ufps.UFPSaberPRO.security.dao;

import com.ufps.UFPSaberPRO.security.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Rol, Long> {
    
}
