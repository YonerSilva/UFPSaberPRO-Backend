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
import lombok.Data;

@Entity
@Table(name = "categoria", schema = "public")
@Data
public class Categoria implements Serializable{
private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long id_categoria;
	
	@Column(name = "cate_nombre", length = 100)
	private String cate_nombre;

    @Column(name = "cate_descripcion", length = 256)
    private String cate_descripcion;
    
    /* FK programa
     * FK usu_creacion
    */
    @CreationTimestamp
    @Column(name = "cate_fechaCreacion")
    private Date cate_fechaCreacion;
    
    public Categoria() {
    	
    }
    
}
