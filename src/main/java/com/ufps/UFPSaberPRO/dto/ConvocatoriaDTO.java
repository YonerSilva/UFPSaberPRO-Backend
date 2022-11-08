package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.ufps.UFPSaberPRO.security.dto.UsuarioDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ConvocatoriaDTO {
	private Long id_convocatoria;
    
	@NotBlank
	@NotEmpty
	private String convo_nombre;
    
	@NotBlank
	@NotEmpty
    private String convo_descripcion;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm", shape = Shape.STRING)
	@NotNull
    private Date convo_fecha_inicial;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm", shape = Shape.STRING)
	@NotNull
    private Date convo_fecha_final;
	
    private String convo_estado;
	
	@NotNull
	private Long programa;
		
    private Long simulacro;
    	
    @NotNull
	private Long usu_creacion;	
    
    private List<UsuarioDTO> usuarios = new ArrayList<>();
}
