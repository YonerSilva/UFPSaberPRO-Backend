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
@Table(name = "rta_simu_usu", schema = "public")
@Data
public class Rta_Simu_Usu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rta_simu_usu")
	private Long id_rta_simu_usu;

	@Column(name = "rta_puntaje")
	private Integer rta_puntaje;

	@JoinColumn(name = "id_simu_usu", referencedColumnName = "id_simu_usu")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Simu_Usu.class)
	private Simu_Usu simu_usu;

	@JoinColumn(name = "id_respuesta", referencedColumnName = "id_respuesta")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Respuesta.class)
	private Respuesta respuesta;

	public Rta_Simu_Usu() {

	}
	
	public Rta_Simu_Usu(Long id_rta_simu_usu) {
		this.id_rta_simu_usu=id_rta_simu_usu;
	}

	public Rta_Simu_Usu(Integer rta_puntaje, Simu_Usu simu_usu, Respuesta respuesta) {
		this.rta_puntaje = rta_puntaje;
		this.simu_usu = simu_usu;
		this.respuesta = respuesta;
	}
}
