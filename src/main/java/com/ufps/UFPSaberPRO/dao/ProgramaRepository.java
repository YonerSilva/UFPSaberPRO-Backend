package com.ufps.UFPSaberPRO.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufps.UFPSaberPRO.entity.Programa;

@Repository
public interface ProgramaRepository extends CrudRepository<Programa, Long>{
	
	@Query(value = "SELECT prg.* FROM public.programa prg WHERE prg.prg_codigo = :prg_codigo",nativeQuery = true)
	public Programa findByPrg_codigo(String prg_codigo);
	
	@Modifying
	@Query(value = "UPDATE public.programa\r\n"
			+ "SET prg_email=:email, prg_codigo=:codigo, prg_nombre=:nombre\r\n"
			+ "WHERE id_programa=:id",nativeQuery = true)
	public void update(@Param("id") Long id,@Param("codigo") String codigo,@Param("email") String email,@Param("nombre") String nombre);
}
