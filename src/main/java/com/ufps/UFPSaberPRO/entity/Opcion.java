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
    
    @Column(name = "opc_respuesta", unique = true, nullable = false, length = 50)
    private Boolean opc_respuesta;
    
    //FK programa
    
    @CreationTimestamp
    @Column(name = "opc_fechaCreacion")
    private Date opc_fechaCreacion;
    
    public Opcion() {
    	
    }
    
}
