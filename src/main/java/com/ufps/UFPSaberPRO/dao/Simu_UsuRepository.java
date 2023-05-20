package com.ufps.UFPSaberPRO.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.entity.Simu_Usu;
import com.ufps.UFPSaberPRO.security.entity.Usuario;

public interface Simu_UsuRepository extends CrudRepository<Simu_Usu, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "SELECT u.* FROM public.simu_usu su \r\n"
			+ "INNER JOIN public.usuario u on u.id_usuario = su.id_usuario \r\n"
			+ "WHERE su.id_simulacro=:id_simulacro", nativeQuery = true)
	public List<Usuario> getUsuariosSimu(@Param("id_simulacro") Long simulacro);
}
