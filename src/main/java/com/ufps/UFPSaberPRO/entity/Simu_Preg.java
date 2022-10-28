package com.ufps.UFPSaberPRO.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "simu_preg", schema = "public")
@Data
public class Simu_Preg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_simu_preg")
	private Long id_simu_preg;

	@Column(name = "simu_preg_puntaje")
	private Integer simu_usu_puntaje;

	@JoinColumn(name = "id_simulacro", referencedColumnName = "id_simulacro")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Simulacro.class)
	private Simulacro simulacro;

	@JoinColumn(name = "id_pregunta", referencedColumnName = "id_pregunta")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Pregunta.class)
	private Pregunta pregunta;

	public Simu_Preg() {

	}
	
	public Simu_Preg(Long id_simu_preg) {
		this.id_simu_preg=id_simu_preg;
	}

}
