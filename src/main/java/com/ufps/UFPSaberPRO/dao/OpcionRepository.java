package com.ufps.UFPSaberPRO.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.dto.OpcionDTO;
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.entity.Opcion;

@Repository
public interface OpcionRepository extends CrudRepository<Opcion, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "SELECT o.* FROM public.pregunta p \r\n"
			+ "INNER JOIN public.opcion o on o.id_pregunta = p.id_pregunta \r\n"
			+ "WHERE p.id_pregunta = :id_pregunta order by o.opc_orden asc", nativeQuery = true)
	public List<Opcion> findAllByPregunta(@Param("id_pregunta") Long pregunta);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE public.opcion\r\n"
			+ "SET opc_descripcion=:descripcion, opc_imagen = :imagen, \r\n"
			+ "opc_respuesta=:respuesta \r\n"
			+ "WHERE id_opcion=:id", nativeQuery = true)
	public void update(@Param("id") Long id, @Param("imagen") String imagen, @Param("descripcion") String descripcion,
			@Param("respuesta") Boolean respuesta);
	
	@Transactional
	@Modifying
	@Query("SELECT new com.ufps.UFPSaberPRO.dto.OpcionDTO(o.id_opcion, o.opc_imagen, o.opc_descripcion, o.pregunta.id_pregunta) FROM Opcion o \r\n"
			+ "WHERE o.pregunta.id_pregunta=:pregunta order by o.opc_orden asc")
	public List<OpcionDTO> findAllByPregDTO(Long pregunta);
}
