package com.ufps.UFPSaberPRO.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

import com.ufps.UFPSaberPRO.entity.Convocatoria;

@Repository
public interface ConvocatoriaRepository extends CrudRepository<Convocatoria, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE public.convocatoria\r\n"
			+ "SET convo_descripcion=:descripcion, convo_estado=:estado, convo_fecha_final=:fecha_final, convo_fecha_inicial=:fecha_inicial, convo_nombre=:nombre, id_programa=:programa, id_simulacro=:simulacro\r\n"
			+ "WHERE id_convocatoria=:id", nativeQuery = true)
	public void update(@Param("id") Long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion,
			@Param("fecha_inicial") Date fecha_inicial, @Param("fecha_final") Date fecha_final, @Param("estado") String estado,
			@Param("programa") Long programa, @Param("simulacro") Long simulacro);
	
	@Transactional
	@Modifying
	@Query(value = "SELECT c.* FROM public.programa p \r\n"
			+ "INNER JOIN public.convocatoria c on c.id_programa = p.id_programa \r\n"
			+ "WHERE p.prg_codigo = :codigo and EXISTS (SELECT u.* FROM usuario u WHERE u.id_usuario = :id_usuario and u.id_rol = 1)", nativeQuery = true)
	public List<Convocatoria> findAllByUsuPrg(@Param("id_usuario") Long usuario,@Param("codigo") String codigo);
	
}
