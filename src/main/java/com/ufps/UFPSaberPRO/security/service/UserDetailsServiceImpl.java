package com.ufps.UFPSaberPRO.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ufps.UFPSaberPRO.security.config.MainUser;
import com.ufps.UFPSaberPRO.security.entity.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    private final UsuarioService usuarioService;

    @Autowired
    public UserDetailsServiceImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Usuario user = usuarioService.getByEmail(email);
        return MainUser.build(user);
    }
    
}
