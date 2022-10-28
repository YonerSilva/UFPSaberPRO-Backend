package com.ufps.UFPSaberPRO.dao;

import java.util.Date;

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
			+ "SET simu_descripcion=:descripcion, simu_duracion=:duracion, simu_estado=:estado, simu_fecha_final=:fecha_final, \r\n"
			+ "simu_fecha_inicial=:fecha_inicial, simu_nombre=:nombre, simu_puntaje_maximo=:puntaje \r\n"
			+ "WHERE id_simulacro=:id", nativeQuery = true)
	public void update(@Param("id") Long id,@Param("nombre") String nombre,@Param("descripcion") String descripcion,
			@Param("puntaje") Integer puntaje,@Param("fecha_inicial") Date fecha_inicial,@Param("fecha_final") Date fecha_final, 
			@Param("duracion") String duracion,@Param("estado") String estado);
}
