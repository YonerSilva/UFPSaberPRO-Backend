package com.ufps.UFPSaberPRO.dto;

import lombok.Data;

@Data
public class EstadisticaDTO {
	private Long id_pregunta;
	
	private Integer preg_tipo;
	
	private Long id_subcategoria;
	
	private Long id_categoria;
	
	private Integer puntaje_obtenido;
}
