package com.ufps.UFPSaberPRO.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.entity.Simu_Usu;
import com.ufps.UFPSaberPRO.security.dto.UsuarioDTO;

public interface Simu_UsuRepository extends CrudRepository<Simu_Usu, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "SELECT new com.ufps.UFPSaberPRO.security.dto.UsuarioDTO(u.id_usuario,u.usu_nombre,u.usu_apellido,\r\n"
			+ "		 u.usu_codigo, u.usu_email,u.programa.prg_codigo, u.rol.id_rol) FROM Simu_Usu su \r\n"
			+ "INNER JOIN Usuario u on u.id_usuario = su.usuario.id_usuario \r\n"
			+ "WHERE su.simulacro.id_simulacro=:id_simulacro")
	public List<UsuarioDTO> getUsuariosSimu(@Param("id_simulacro") Long simulacro);
}