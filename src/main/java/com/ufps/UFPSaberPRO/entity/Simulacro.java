package com.ufps.UFPSaberPRO.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "simulacro", schema = "public")
@Data
public class Simulacro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_simulacro")
	private Long id_simulacro;

	@Column(name = "simu_nombre", length = 100)
	private String simu_nombre;

	@Column(name = "simu_descripcion", length = 256)
	private String simu_descripcion;

	@Column(name = "simu_puntaje_maximo")
	private Integer simu_puntaje_maximo;

	@Column(name = "simu_fecha_inicial")
	private Date simu_fecha_inicial;

	@Column(name = "simu_fecha_final")
	private Date simu_fecha_final;

	@Column(name = "simu_duracion", length = 10)
	private String simu_duracion;

	@Column(name = "simu_estado", length = 5)
	private String simu_estado;
	
	@JoinColumn(name = "id_programa")
	private Long programa;

	@CreationTimestamp
	@Column(name = "simu_fecha_creacion")
	private LocalDateTime simu_fecha_creacion;

	public Simulacro() {

	}

	public Simulacro(Long id_simulacro) {
		this.id_simulacro = id_simulacro;
	}
}
