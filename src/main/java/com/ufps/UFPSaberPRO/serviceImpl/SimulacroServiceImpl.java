package com.ufps.UFPSaberPRO.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ufps.UFPSaberPRO.converter.SimulacroConverter;
import com.ufps.UFPSaberPRO.dao.SimulacroRepository;
import com.ufps.UFPSaberPRO.dto.EstadisticaDTO;
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.dto.SimulacroDTO;
import com.ufps.UFPSaberPRO.entity.Simulacro;
import com.ufps.UFPSaberPRO.security.dto.UsuarioDTO;
import com.ufps.UFPSaberPRO.security.entity.Usuario;
import com.ufps.UFPSaberPRO.service.SimulacroService;

@Service
public class SimulacroServiceImpl implements SimulacroService{
	
	@Autowired
	private SimulacroRepository simulacroDao;
	
	@PersistenceUnit
	EntityManagerFactory emf;

	@Transactional
	@Override
	public SimulacroDTO buscar(Long id_simulacro) {
		Simulacro simu = simulacroDao.findById(id_simulacro).get();
		SimulacroDTO simulacro = new SimulacroConverter().converterToDTO(simu);
		return simulacro;
	}

	@Transactional
	@Override
	public void guardar(SimulacroDTO simulacro) {
		Simulacro simu = new SimulacroConverter().converterToEntity(simulacro);
		simulacroDao.save(simu);
	}
	
	@Transactional
	@Override
	public void update(SimulacroDTO simulacro) {
		Simulacro s = new SimulacroConverter().converterToEntity(simulacro);
		simulacroDao.update(s.getId_simulacro(), s.getSimu_nombre(), s.getSimu_descripcion(),
				s.getSimu_puntaje_maximo(), s.getSimu_estado(), s.getPrograma());
	}

	@Transactional
	@Override
	public void eliminar(Long id_simulacro) {
		// TODO Auto-generated method stub
	}

	@Transactional
	@Override
	public List<SimulacroDTO> getSimulacros() {
		List<SimulacroDTO> simulacros = new ArrayList<>();
		SimulacroConverter converter = new SimulacroConverter();
		for (Simulacro simu : simulacroDao.findAll()) {
			simulacros.add(converter.converterToDTO(simu));
		}
		return simulacros;
	}
	
	@Transactional
	@Override
	public List<SimulacroDTO> getSimulacrosUsuPrg(Long id_usuario, Long id_programa) {
		List<SimulacroDTO> simulacros = new ArrayList<>();
		SimulacroConverter converter = new SimulacroConverter();
		for (Simulacro simu : simulacroDao.findAllByUsuPrg(id_usuario, id_programa)) {
			simulacros.add(converter.converterToDTO(simu));
		}
		return simulacros;
	}
	
	@Transactional
	@Override
	public List<SimulacroDTO> getSimulacrosConvo(Long id_usuario, String estado) {
		return simulacroDao.findAllByConvoUsuEst(new Usuario(id_usuario), estado);
	}
	
	@Transactional
	@Override
	public List<SimulacroDTO> getSimulacrosUsu(Long id_usuario) {
		return simulacroDao.findAllByUsuario(new Usuario(id_usuario));
	}
	
	public List<EstadisticaDTO> getEstadisticasSimuUsu(Long id_simulacro, Long id_usuario, Long id_convocatoria){
		EntityManager em = emf.createEntityManager();
		String sql = "select p.id_pregunta, p.preg_tipo, sub.id_subcategoria, cate.id_categoria, rsu.rta_puntaje puntaje_obtenido\r\n"
				+ "from simu_usu su \r\n"
				+ "inner join rta_simu_usu rsu on rsu.id_simu_usu = su.id_simu_usu\r\n"
				+ "inner join respuesta r on r.id_respuesta = rsu.id_respuesta\r\n"
				+ "inner join pregunta p on p.id_pregunta = r.id_pregunta \r\n"
				+ "inner join subcategoria sub on sub.id_subcategoria = p.id_subcategoria \r\n"
				+ "inner join categoria cate on cate.id_categoria = sub.id_categoria \r\n"
				+ "inner join simu_preg sp on sp.id_simulacro = su.id_simulacro and sp.id_pregunta = p.id_pregunta \r\n"
				+ "where su.id_simulacro = :id_simulacro and su.id_usuario = :id_usuario and su.id_convocatoria = :id_convocatoria ";
		Query q = em.createNativeQuery(sql).setParameter("id_simulacro", id_simulacro).setParameter("id_usuario", id_usuario).setParameter("id_convocatoria", id_convocatoria);
		List<Object[]> respuestas = q.getResultList();
		List<EstadisticaDTO> estadisticas = new ArrayList<>();
		for (Object[] item : respuestas) {
			EstadisticaDTO itemDto = new EstadisticaDTO();
			itemDto.setId_pregunta(Long.parseLong(item[0].toString()));
			itemDto.setPreg_tipo(Integer.parseInt(item[1].toString()));
			itemDto.setId_subcategoria(Long.parseLong(item[2].toString()));
			itemDto.setId_categoria(Long.parseLong(item[3].toString()));
			itemDto.setPuntaje_obtenido(Integer.parseInt(item[4].toString()));
			estadisticas.add(itemDto);
		}
		return estadisticas;
	}
}
