package com.ufps.UFPSaberPRO.security.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name="rol", schema = "public")
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long id_rol;   
    
    @Column(name = "rol_name")
    private String rol_name;   
    
    public Rol() {
    	
    }
    
    public Rol(Long id_rol) {
    	this.id_rol = id_rol;
    }
}
