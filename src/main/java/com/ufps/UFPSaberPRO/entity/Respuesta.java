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
	
	@Column(name = "opciones")
	private String opciones;

    @Column(name = "rta_puntaje_obtenido")
    private Integer rta_puntaje_obtenido;

	public Respuesta() {
		
	}
    
    
}
