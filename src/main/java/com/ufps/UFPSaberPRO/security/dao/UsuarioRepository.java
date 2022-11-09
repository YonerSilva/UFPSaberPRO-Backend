package com.ufps.UFPSaberPRO.security.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufps.UFPSaberPRO.entity.Categoria;
import com.ufps.UFPSaberPRO.security.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
    @Query(value = "SELECT * FROM public.usuario u WHERE u.usu_codigo = :codigo and u.usu_email = :email",nativeQuery = true)
	public Usuario findByCodigo_Email(String codigo,String email);
    
    @Query(value = "SELECT * FROM public.usuario u WHERE u.usu_email = :email",nativeQuery = true)
	public Usuario findByEmail(String email);
    
    @Transactional
    @Modifying
    @Query(value = "SELECT EXISTS(SELECT * FROM public.usuario u WHERE u.usu_email = :email);",nativeQuery = true)
    public boolean existsByEmail(String email);
    
    @Transactional
	@Modifying
	@Query(value = "SELECT u.* FROM public.programa p \r\n"
			+ "INNER JOIN public.usuario u on u.id_programa = p.id_programa  \r\n"
			+ "WHERE p.id_programa = :id_programa and EXISTS (SELECT usu.* FROM usuario usu WHERE usu.id_usuario = :id_usuario and usu.id_rol = 1)", nativeQuery = true)
	public List<Usuario> findAllByUsuPrg(@Param("id_usuario") Long usuario,@Param("id_programa") Long programa);
    
}
