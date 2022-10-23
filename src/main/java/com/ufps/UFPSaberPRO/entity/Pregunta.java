    package com.ufps.UFPSaberPRO.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufps.UFPSaberPRO.security.entity.Usuario;

import lombok.Data;

@Entity
@Table(name = "opcion", schema = "public")
@Data
public class Pregunta implements Serializable{
private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pregunta")
	private Long id_pregunta;
	
	@Column(name = "preg_imagen", length = 256)
	private String preg_imagen;
       
    @Column(name = "preg_descripcion", length = 500)
    private String preg_descripcion;
    
    
    @CreationTimestamp
    @Column(name = "preg_fechaCreacion")
    private Date preg_fechaCreacion;
    
    @Column(name = "preg_estado", length = 5)
    private String preg_estado;
    
    public Pregunta() {
    	
    }
    
}
