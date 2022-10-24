package com.ufps.UFPSaberPRO.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufps.UFPSaberPRO.security.entity.Usuario;


import lombok.Data;

@Entity
@Table(name = "convocatoria", schema = "public")
@Data
public class Convocatoria implements Serializable{
private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_convocatoria")
	private Long id_convocatoria;
	
	@Column(name = "convo_nombre", length = 100)
	private String convo_nombre;

    @Column(name = "convo_descripcion", length = 256)
    private String convo_descripcion;
    
    @Column(name = "convo_fechaInicial")
    private Date convo_fechaInicial;
    
    @Column(name = "convo_fechaFinal")
    private Date convo_fechaFinal;
    
    @Column(name = "convo_estado", length = 5)
    private String convo_estado;
    
    @JoinColumn(name = "id_programa",referencedColumnName = "id_programa")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Programa.class)
    private Programa programa;
    
    @JoinColumn(name = "id_simulacro",referencedColumnName = "id_simulacro")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Simulacro.class)
    private Simulacro simulacro;
    
    @Column(name = "usu_creacion")
    private Long usu_creacion;
    
    @CreationTimestamp
    @Column(name = "convo_fechaCreacion")
    private LocalDateTime convo_fechaCreacion;
    
    public Convocatoria() {
    	
    }
    
}
