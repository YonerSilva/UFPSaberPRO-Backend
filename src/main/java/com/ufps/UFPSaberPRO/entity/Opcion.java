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
@Table(name = "opcion", schema = "public")
@Data
public class Opcion implements Serializable{
private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_opcion")
	private Long id_opcion;
	
	@Column(name = "opc_imagen", length = 256)
	private String opc_imagen;
       
    @Column(name = "opc_descripcion", length = 500)
    private String opc_descripcion;
    
    @Column(name = "opc_respuesta")
    private Boolean opc_respuesta;
    
    @JoinColumn(name = "id_pregunta",referencedColumnName = "id_pregunta")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Pregunta.class)
    private Pregunta pregunta;
    
    public Opcion() {
    	
    }
    
    public Opcion(Long id_opcion) {
    	this.id_opcion=id_opcion;
    }
}
