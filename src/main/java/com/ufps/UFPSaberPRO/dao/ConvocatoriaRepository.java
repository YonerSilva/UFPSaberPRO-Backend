package com.ufps.UFPSaberPRO.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ufps.UFPSaberPRO.entity.Convocatoria;

@Repository
public interface ConvocatoriaRepository extends CrudRepository<Convocatoria, Long>{

}
