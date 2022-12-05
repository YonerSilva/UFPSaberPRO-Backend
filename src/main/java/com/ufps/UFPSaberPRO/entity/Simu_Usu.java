package com.ufps.UFPSaberPRO.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ufps.UFPSaberPRO.security.entity.Usuario;

import lombok.Data;

@Entity
@Table(name = "simu_usu", schema = "public")
@Data
public class Simu_Usu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_simu_usu")
	private Long id_simu_usu;

	@Column(name = "simu_usu_presentado")
	private Boolean simu_usu_presentado;

	@Column(name = "simu_usu_codigo", length = 120)
	private String simu_usu_codigo;

	@Column(name = "simu_usu_puntaje_total")
	private Integer simu_usu_puntaje_total;

	@JoinColumn(name = "id_simulacro", referencedColumnName = "id_simulacro")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Simulacro.class)
	private Simulacro simulacro;

	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Usuario.class)
	private Usuario usuario;

	public Simu_Usu() {

	}

	public Simu_Usu(Long id_simu_usu) {
		this.id_simu_usu=id_simu_usu;
	}
}
