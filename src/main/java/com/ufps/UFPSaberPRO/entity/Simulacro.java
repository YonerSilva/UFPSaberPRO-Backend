package com.ufps.UFPSaberPRO.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufps.UFPSaberPRO.security.entity.Usuario;

import lombok.Data;

@Entity
@Table(name = "simulacro", schema = "public")
@Data
public class Simulacro implements Serializable{
private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_simulacro")
	private Long id_simulacro;
	
	@Column(name = "simu_nombre", length = 100)
	private String simu_nombre;

    @Column(name = "simu_descripcion", length = 256)
    private String simu_descripcion;
    
    @Column(name = "simu_puntajeMaximo")
    private Integer simu_puntajeMaximo;
    
    @Column(name = "simu_fechaInicial")
    private Date simu_fechaInicial;
    
    @Column(name = "simu_fechaFinal")
    private Date simu_fechaFinal;
    
    @Column(name = "simu_duracion", length = 10)
    private String simu_duracion;
    
    @Column(name = "simu_estado", length = 5)
    private String simu_estado;
    
    @CreationTimestamp
    @Column(name = "simu_fechaCreacion")
    private Date simu_fechaCreacion;
    
    public Simulacro() {
    	
    }
    
}
