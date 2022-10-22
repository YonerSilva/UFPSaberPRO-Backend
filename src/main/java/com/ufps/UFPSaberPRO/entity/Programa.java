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
@Table(name = "programa", schema = "public")
@Data
public class Programa implements Serializable{
private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_programa")
    private Long id_programa;
    
    @Column(name = "prg_nombre", length = 100)
    private String prg_nombre;
    
    @Column(name = "prg_codigo", unique = true, nullable = false, length = 50)
    private String prg_codigo;
    
    @Column(name = "prg_email", unique = true, length = 100)
    private String prg_email;
    
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Usuario> usuarios;
    
    public Programa() {
    	
    }
    
    public Programa(Long id_programa) {
    	this.id_programa = id_programa;
    }
}
