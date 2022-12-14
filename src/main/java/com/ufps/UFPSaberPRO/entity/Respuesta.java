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
@Table(name = "respuesta", schema = "public")
@Data
public class Respuesta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_respuesta")
	private Long id_respuesta;   
	
	@JoinColumn(name = "id_pregunta", referencedColumnName = "id_pregunta")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Pregunta.class)
	private Pregunta pregunta;
	
	@JoinColumn(name = "id_opcion", referencedColumnName = "id_opcion")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Opcion.class)
	private Opcion opcion;

	public Respuesta() {
		
	}

	public Respuesta(Long id_respuesta) {
		this.id_respuesta = id_respuesta;
	}

	public Respuesta(Pregunta pregunta, Opcion opcion) {
		this.pregunta = pregunta;
		this.opcion = opcion;
	}
	
}
