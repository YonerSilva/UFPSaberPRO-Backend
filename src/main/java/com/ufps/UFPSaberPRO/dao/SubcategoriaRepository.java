package com.ufps.UFPSaberPRO.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.entity.Categoria;
import com.ufps.UFPSaberPRO.entity.Subcategoria;

@Repository
public interface SubcategoriaRepository extends CrudRepository<Subcategoria, Long>{

	@Transactional
	@Modifying
	@Query(value = "SELECT c.* FROM public.categoria c \r\n"
			+ "INNER JOIN public.subcategoria s on s.id_categoria = c.id_categoria \r\n"
			+ "WHERE c.id_categoria = :id_categoria and EXISTS (SELECT u.* FROM usuario u WHERE u.id_usuario = :id_usuario and u.id_rol = 1)", nativeQuery = true)
	public List<Subcategoria> findAllByUsuCate(@Param("id_usuario") Long usuario,@Param("id_categoria") Long categoria);
	
	@Transactional
	@Modifying
	@Query(value = "SELECT s.* FROM public.programa p \r\n"
			+ "INNER JOIN public.subcategoria s on s.programa = p.id_programa \r\n"
			+ "WHERE p.id_programa = :id_programa and EXISTS (SELECT u.* FROM usuario u WHERE u.id_usuario = :id_usuario and u.id_rol = 1 or u.id_rol = 2)", nativeQuery = true)
	public List<Subcategoria> findAllByUsuPrg(@Param("id_usuario") Long usuario,@Param("id_programa") Long programa);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE public.subcategoria\r\n"
			+ "SET sub_descripcion=:descripcion, sub_nombre=:nombre\r\n"
			+ "WHERE id_subcategoria=:id", nativeQuery = true)
	public void update(@Param("id") Long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);
}
