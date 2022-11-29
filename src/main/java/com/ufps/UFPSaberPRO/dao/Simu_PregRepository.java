package com.ufps.UFPSaberPRO.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ufps.UFPSaberPRO.entity.Simu_Preg;

public interface Simu_PregRepository extends CrudRepository<Simu_Preg, Long> {
	
	@Modifying
	@Query(value = "DELETE FROM public.simu_preg\r\n"
			+ "WHERE id_simulacro=:simulacro and id_pregunta in :preguntas", nativeQuery = true)
	public void eliminar(@Param("simulacro") Long simulacro, @Param("preguntas") List<Long> preguntas);
}
