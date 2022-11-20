package com.ufps.UFPSaberPRO.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.entity.Simu_Preg;

public interface Simu_PregRepository extends CrudRepository<Simu_Preg, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "SELECT p.*,sp.simu_preg_puntaje FROM public.simu_preg sp \r\n"
			+ "INNER JOIN public.pregunta p on p.id_pregunta = sp.pregunta \r\n"
			+ "WHERE sp.id_simulacro = :id_simulacro and p.preg_estado='A'", nativeQuery = true)
	public List<PreguntaDTO> findAllBySimulacro(@Param("id_simulacro") Long simulacro);
}
