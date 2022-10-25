package com.ufps.UFPSaberPRO.security.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;

import com.ufps.UFPSaberPRO.entity.Programa;
import com.ufps.UFPSaberPRO.entity.Simulacro;

@Entity
@Data
@Table(name = "usuario", schema = "public")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;
    
    @Column(name = "usu_nombre", length = 100)
    private String usu_nombre;
    
    @Column(name = "usu_apellido", length = 100)
    private String usu_apellido;
        
    @Column(name = "usu_codigo",unique = true, nullable = false, length = 50)
    private String usu_codigo;
    
    @Column(name = "usu_email", unique = true, nullable = false, length = 100)
    private String usu_email;
    
    @Column(name = "usu_password", nullable = false, length = 256)
    private String usu_password;
    
    @JoinColumn(name = "id_programa",referencedColumnName = "id_programa")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Programa.class)
    private Programa programa;

    @CreationTimestamp
    @Column(name = "usu_fechaCreacion")
    private LocalDateTime usu_fechaCreacion;
    
    @JoinColumn(name = "id_rol",referencedColumnName = "id_rol")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Rol.class)
    private Rol rol;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="simu_usu", joinColumns = @JoinColumn(name="id_usuario"),inverseJoinColumns=@JoinColumn(name="id_simulacro"))
    private List<Simulacro> simulacros = new ArrayList<>();

    public Usuario() {
    	
	}
    
	public Usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
    
}
