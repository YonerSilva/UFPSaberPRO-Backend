package com.ufps.UFPSaberPRO.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "pregunta", schema = "public")
@Data
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pregunta")
	private Long id_pregunta;

	@Column(name = "preg_imagen", length = 256)
	private String preg_imagen;

	@Column(name = "preg_descripcion", length = 500)
	private String preg_descripcion;

	@Column(name = "preg_estado", length = 5)
	private String preg_estado;

	@JoinColumn(name = "id_subcategoria", referencedColumnName = "id_subcategoria")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Subcategoria.class)
	private Subcategoria subcategoria;

	@CreationTimestamp
	@Column(name = "preg_fechaCreacion")
	private LocalDateTime preg_fechaCreacion;

	@Column(name = "usu_creacion")
	private Long usu_creacion;

	public Pregunta() {

	}

}
