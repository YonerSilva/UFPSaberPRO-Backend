package com.ufps.UFPSaberPRO.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "respuesta", schema = "public")
@Data
public class Respuesta {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_respuesta")
	private Long id_respuesta;      
	
	@Column(name = "opciones", length = 100)
	private String opciones;

    @Column(name = "rta_puntajeObtenido", length = 256)
    private Integer rta_puntajeObtenido;

	public Respuesta() {
		
	}
    
    
}
