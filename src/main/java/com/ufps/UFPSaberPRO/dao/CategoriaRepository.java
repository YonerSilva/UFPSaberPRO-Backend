package com.ufps.UFPSaberPRO.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.entity.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "SELECT c.* FROM public.programa p \r\n"
			+ "INNER JOIN public.categoria c on c.id_programa = p.id_programa \r\n"
			+ "WHERE p.id_programa = :id_programa and EXISTS (SELECT u.* FROM usuario u WHERE u.id_usuario = :id_usuario and u.id_rol = 1 or u.id_rol= 2 or u.id_rol= 3)", nativeQuery = true)
	public List<Categoria> findAllByUsuPrg(@Param("id_usuario") Long usuario,@Param("id_programa") Long programa);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE public.categoria\r\n"
			+ "SET cate_descripcion=:descripcion, cate_nombre=:nombre\r\n"
			+ "WHERE id_categoria=:id", nativeQuery = true)
	public void update(@Param("id") Long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);
}
