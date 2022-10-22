package com.ufps.UFPSaberPRO.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ufps.UFPSaberPRO.entity.Programa;

@Repository
public interface ProgramaRepository extends CrudRepository<Programa, Long>{
	
	@Query(value = "SELECT prg.* FROM public.programa prg WHERE prg.prg_codigo = :prg_codigo",nativeQuery = true)
	public Programa findByPrg_codigo(String prg_codigo);
}
