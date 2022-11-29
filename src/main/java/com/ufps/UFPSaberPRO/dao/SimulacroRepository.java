package com.ufps.UFPSaberPRO.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.dto.SimulacroDTO;
import com.ufps.UFPSaberPRO.entity.Simulacro;
import com.ufps.UFPSaberPRO.security.entity.Usuario;

@Repository
public interface SimulacroRepository extends CrudRepository<Simulacro, Long>{
	
	@Modifying
	@Query(value = "UPDATE public.simulacro\r\n"
			+ "SET simu_descripcion=:descripcion, simu_estado=:estado, \r\n"
			+ "simu_nombre=:nombre, simu_puntaje_maximo=:puntaje, programa=:programa \r\n"
			+ "WHERE id_simulacro=:id", nativeQuery = true)
	public void update(@Param("id") Long id,@Param("nombre") String nombre,@Param("descripcion") String descripcion,
			@Param("puntaje") Integer puntaje,@Param("estado") String estado, @Param("programa") Long programa);
	
	@Modifying
	@Query(value = "SELECT s.* from public.simulacro s\r\n"
			+ "WHERE s.programa = :id_programa and EXISTS(SELECT u.* from public.usuario u WHERE u.id_usuario = :id_usuario and u.id_rol = 1)", nativeQuery = true)
	public List<Simulacro> findAllByUsuPrg(@Param("id_usuario") Long usuario, @Param("id_programa") Long programa);
	
	@Transactional
	@Modifying
	@Query("SELECT new com.ufps.UFPSaberPRO.dto.SimulacroDTO(s.id_simulacro,s.simu_nombre,\r\n"
			+ "s.simu_descripcion,s.simu_puntaje_maximo,s.simu_estado,\r\n"
			+ "s.programa, c.simu_fecha_inicial, c.simu_duracion) FROM Convo_Usu cu \r\n"
			+ "INNER JOIN Convocatoria c on c.id_convocatoria = cu.convocatoria \r\n"
			+ "INNER JOIN Simulacro s on s.id_simulacro = c.simulacro \r\n"
			+ "WHERE cu.usuario=:usuario and s.simu_estado=:estado")
	public List<SimulacroDTO> findAllByConvoUsuEst(Usuario usuario,String estado);
}
