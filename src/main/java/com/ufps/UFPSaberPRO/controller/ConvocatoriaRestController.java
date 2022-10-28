package com.ufps.UFPSaberPRO.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.UFPSaberPRO.dto.ConvocatoriaDTO;
import com.ufps.UFPSaberPRO.dto.DatogeneralDTO;
import com.ufps.UFPSaberPRO.dto.ProgramaDTO;
import com.ufps.UFPSaberPRO.serviceImpl.ConvocatoriaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/convocatorias")
@CrossOrigin("*")
public class ConvocatoriaRestController {
	
	@Autowired
	private ConvocatoriaServiceImpl convocatoriaService;
	
	private DatogeneralDTO datoGeneral;
	
	public ConvocatoriaRestController() {
		datoGeneral = new DatogeneralDTO();
	}
	
	@Operation(summary = "Obtiene los datos generales de convocatoria para el usuario.")
	@GetMapping("/general")
	public ResponseEntity<Object> general(@RequestParam String id_usuario,@RequestParam String prg_codigo){
		Map<String,Object> datos = new LinkedHashMap<>();
		Long id_user = Long.parseLong(id_usuario);
		try {
			List<ConvocatoriaDTO> convocatorias_programa = convocatoriaService.getConvocatoriasByUsuPrg(id_user,prg_codigo);
			datoGeneral.setConvocatorias_programa(convocatorias_programa);
			datos.put("error", null);
			datos.put("message", "¡Proceso Exitoso!");
			datos.put("general", datoGeneral);
			return new ResponseEntity<Object>(datos, HttpStatus.OK);
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron convocatorias.");
			datos.put("general", datoGeneral);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*@Operation(summary = "Obtiene una lista de convocatorias por el programa.")
	@GetMapping("/getConvocatorias")
	public ResponseEntity<Object> getConvocatorias(@Valid @RequestParam String prg_codigo){
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			List<ConvocatoriaDTO> convocatorias = convocatoriaService.getConvocatoriasByPrograma(prg_codigo);
			if(convocatorias.size()>0) {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("convocatorias", convocatorias);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}else {
				datos.put("error", null);
				datos.put("message", "No se encontraron convocatorias.");
				datos.put("convocatorias", null);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron convocatorias.");
			datos.put("convocatorias", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	@Operation(summary = "Obtiene una convocatoria en especifico por el id.")
	@GetMapping("/getConvocatoria")
	public ResponseEntity<Object> getConvocatoria(@Valid @RequestParam String id_convocatoria){
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			Long id_convo = Long.parseLong(id_convocatoria);
			ConvocatoriaDTO convocatoria = convocatoriaService.buscar(id_convo);
			if(convocatoria==null) {
				datos.put("error", "El identificador del convocatoria no existe.");
				datos.put("message", "No existe un convocatoria con ese identificador.");
				datos.put("convocatoria", null);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}else {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("convocatoria", convocatoria);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "Ha ocurrido un error al buscar la convocatoria.");
			datos.put("convocatoria", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(datos, HttpStatus.OK);
	}
	
	@Operation(summary = "Registra una nuevo convocatoria en la base de datos.")
	@PostMapping("/guardarConvocatoria")
	public ResponseEntity<Object> guardarConvocatoria(@Valid @RequestBody ConvocatoriaDTO nuevoConvocatoria, BindingResult bidBindingResult){
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				convocatoriaService.guardar(nuevoConvocatoria);
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				return new ResponseEntity<Object>(datos, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "Ha ocurrido un error interno con los datos.");
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Actualiza una convocatoria existente en la base de datos.")
	@PostMapping("/actualizarConvocatoria")
	public ResponseEntity<Object> actualizarConvocatoria(@Valid @RequestBody ConvocatoriaDTO convocatoria, BindingResult bidBindingResult){
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				convocatoriaService.update(convocatoria);
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				return new ResponseEntity<Object>(datos, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "Ha ocurrido un error interno con los datos.");
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
