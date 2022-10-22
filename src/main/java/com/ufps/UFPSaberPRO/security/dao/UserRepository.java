package com.ufps.UFPSaberPRO.security.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ufps.UFPSaberPRO.security.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
	
    @Query(value = "SELECT * FROM public.usuario u WHERE u.usu_codigo = :codigo and u.usu_email = :email",nativeQuery = true)
	public Usuario findByCodigo_Email(String codigo,String email);
    
    @Query(value = "SELECT * FROM public.usuario u WHERE u.usu_email = :email",nativeQuery = true)
	public Usuario findByEmail(String email);
    
    @Transactional
    @Modifying
    @Query(value = "SELECT EXISTS(SELECT * FROM public.usuario u WHERE u.usu_email = :email);",nativeQuery = true)
    public boolean existsByEmail(String email);
    
}
