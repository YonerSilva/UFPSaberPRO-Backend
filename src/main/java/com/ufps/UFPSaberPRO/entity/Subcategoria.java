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
@Table(name = "subcategoria", schema = "public")
@Data
public class Subcategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_subcategoria")
	private Long id_subcategoria;

	@Column(name = "sub_nombre", length = 100)
	private String sub_nombre;

	@Column(name = "sub_descripcion", length = 256)
	private String sub_descripcion;

	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Categoria.class)
	private Categoria categoria;

	@Column(name = "usu_creacion")
	private Long usu_creacion;

	public Subcategoria() {

	}

}
