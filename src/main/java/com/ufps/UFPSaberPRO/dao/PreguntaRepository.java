package com.ufps.UFPSaberPRO.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
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
			+ "preg_estado=:estado, preg_tipo=:tipo, id_subcategoria=:subcategoria \r\n"
			+ "WHERE id_pregunta=:id", nativeQuery = true)
	public void update(@Param("id") Long id, @Param("imagen") String imagen, @Param("descripcion") String descripcion,
			@Param("estado") String estado, @Param("tipo") Long tipo, @Param("subcategoria") Long subcategoria);
	
	@Transactional
	@Modifying
	@Query("SELECT new com.ufps.UFPSaberPRO.dto.PreguntaDTO(p.id_pregunta, p.preg_imagen, p.preg_descripcion, p.preg_estado, p.preg_tipo, p.subcategoria.id_subcategoria, sp.simu_preg_puntaje) FROM Pregunta p \r\n"
			+ "INNER JOIN Simu_Preg sp on sp.pregunta = p.id_pregunta \r\n"
			+ "WHERE sp.simulacro.id_simulacro = :simulacro and p.preg_estado='A' order by p.preg_tipo")
	public List<PreguntaDTO> findAllBySimulacro(Long simulacro);
	
	@Transactional
	@Modifying
	@Query(value = "SELECT p.* FROM public.pregunta p \r\n"
			+ "WHERE not exists (SELECT SP.* from public.simu_preg sp \r\n"
			+ "WHERE sp.id_pregunta = p.id_pregunta and sp.id_simulacro = :id_simulacro) and p.preg_estado='A'", nativeQuery = true)
	public List<Pregunta> findAllByDifferentSimu(@Param("id_simulacro") Long simulacro);
}
