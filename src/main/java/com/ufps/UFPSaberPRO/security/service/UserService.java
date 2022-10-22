package com.ufps.UFPSaberPRO.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.ufps.UFPSaberPRO.security.entity.Usuario;
import com.ufps.UFPSaberPRO.security.dao.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Usuario getByCodigo_Email(String codigo,String email){
        return userRepository.findByCodigo_Email(codigo,email);
    }
    
    public Usuario getByEmail(String email){
        return userRepository.findByEmail(email);
    }
    
    public boolean existByEmail(String email){
        return userRepository.existsByEmail(email);
    }
    public void save(Usuario user){
        userRepository.save(user);
    }
    
    public Usuario findUserById(Long id){
        return userRepository.findById(id).get();
    }
    
}
