package com.ufps.UFPSaberPRO.dto;

import java.util.List;

import com.ufps.UFPSaberPRO.security.entity.Rol;

import lombok.Data;

@Data
public class DatogeneralDTO {
	
	private List<Rol> roles; 
	private List<ProgramaDTO> programas; 
}
