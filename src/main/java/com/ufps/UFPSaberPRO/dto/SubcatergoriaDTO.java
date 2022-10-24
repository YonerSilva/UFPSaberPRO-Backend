package com.ufps.UFPSaberPRO.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

import lombok.Data;

@Data
public class SubcatergoriaDTO {
	private Long id_subcategoria;
    
	@NotBlank
	@NotEmpty
	private String sub_nombre;
    
	@NotBlank
	@NotEmpty
	private String sub_descripcion;
	
	public SubcatergoriaDTO() {
		
	}

}
