package com.ufps.UFPSaberPRO.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.entity.Pregunta;

@Repository
public interface PreguntaRepository extends CrudRepository<Pregunta, Long>{

	@Transactional
	@Modifying
	@Query(value = "SELECT preg.* FROM public.programa p \r\n"
			+ "INNER JOIN public.categoria c on c.id_programa = p.id_programa \r\n"
			+ "INNER JOIN public.subcategoria sub on sub.id_categoria = c.id_categoria \r\n"
			+ "INNER JOIN public.pregunta preg on preg.id_subcategoria = sub.id_subcategoria \r\n"
			+ "WHERE p.id_programa = :id_programa and EXISTS (SELECT u.* FROM usuario u WHERE u.id_usuario = :id_usuario and u.id_rol = 1)", nativeQuery = true)
	public List<Pregunta> findAllByUsuPrg(@Param("id_usuario") Long usuario,@Param("id_programa") Long programa);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE public.pregunta\r\n"
			+ "SET preg_descripcion=:descripcion, preg_imagen = :imagen, \r\n"
			+ "preg_estado=:estado, id_subcategoria=:subcategoria \r\n"
			+ "WHERE id_pregunta=:id", nativeQuery = true)
	public void update(@Param("id") Long id, @Param("imagen") String imagen, @Param("descripcion") String descripcion,
			@Param("estado") String estado, @Param("subcategoria") Long subcategoria);
}
