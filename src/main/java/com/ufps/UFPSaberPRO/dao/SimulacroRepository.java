package com.ufps.UFPSaberPRO.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufps.UFPSaberPRO.entity.Simulacro;

@Repository
public interface SimulacroRepository extends CrudRepository<Simulacro, Long>{
	
	@Modifying
	@Query(value = "UPDATE public.simulacro\r\n"
			+ "SET simu_descripcion=:descripcion, simu_estado=:estado, \r\n"
			+ "simu_nombre=:nombre, simu_puntaje_maximo=:puntaje, programa=:programa \r\n"
			+ "WHERE id_simulacro=:id", nativeQuery = true)
	public void update(@Param("id") Long id,@Param("nombre") String nombre,@Param("descripcion") String descripcion,
			@Param("puntaje") Integer puntaje,@Param("estado") String estado, @Param("programa") Long programa);
	
	@Modifying
	@Query(value = "SELECT s.* from public.simulacro s\r\n"
			+ "WHERE s.programa = :id_programa and EXISTS(SELECT u.* from public.usuario u WHERE u.id_usuario = :id_usuario and u.id_rol = 1)", nativeQuery = true)
	public List<Simulacro> findAllByUsuPrg(@Param("id_usuario") Long usuario, @Param("id_programa") Long programa);
}
