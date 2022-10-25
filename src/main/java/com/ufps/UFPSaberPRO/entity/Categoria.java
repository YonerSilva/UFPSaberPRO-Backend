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
@Table(name = "categoria", schema = "public")
@Data
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long id_categoria;

	@Column(name = "cate_nombre", length = 100)
	private String cate_nombre;

	@Column(name = "cate_descripcion", length = 256)
	private String cate_descripcion;

	@JoinColumn(name = "id_programa", referencedColumnName = "id_programa")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Programa.class)
	private Programa programa;

	@Column(name = "usu_creacion")
	private Long usu_creacion;

	@CreationTimestamp
	@Column(name = "cate_fechaCreacion")
	private LocalDateTime cate_fechaCreacion;

	

}
