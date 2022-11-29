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

import com.ufps.UFPSaberPRO.security.entity.Usuario;

import lombok.Data;

@Entity
@Table(name = "convo_usu", schema = "public")
@Data
public class Convo_Usu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_convo_usu")
	private Long id_convo_usu;

	@JoinColumn(name = "id_convocatoria", referencedColumnName = "id_convocatoria")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Convocatoria.class)
	private Convocatoria convocatoria;

	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Usuario.class)
	private Usuario usuario;

	public Convo_Usu() {

	}

	public Convo_Usu(Long id_convo_usu) {
		this.id_convo_usu=id_convo_usu;
	}
}
