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

import com.ufps.UFPSaberPRO.dto.CategoriaDTO;
import com.ufps.UFPSaberPRO.dto.DatogeneralDTO;
import com.ufps.UFPSaberPRO.serviceImpl.CategoriaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin("*")
public class CategoriaRestController {
	
	@Autowired
	private CategoriaServiceImpl categoriaService;
	
	private DatogeneralDTO datoGeneral;
	
	public CategoriaRestController() {
		datoGeneral = new DatogeneralDTO();
	}
	
	@Operation(summary = "Obtiene los datos generales de categoria para el usuario.")
	@GetMapping("/general")
	public ResponseEntity<Object> general(@RequestParam String id_usuario,@RequestParam String id_programa){
		Map<String,Object> datos = new LinkedHashMap<>();
		Long id_user = Long.parseLong(id_usuario);
		Long id_prg = Long.parseLong(id_programa);
		try {
			List<CategoriaDTO> categorias_programa = categoriaService.getCategoriasByUsuPrg(id_user,id_prg);
			datoGeneral.setCategorias_programa(categorias_programa);
			
			datos.put("error", null);
			datos.put("message", "¡Proceso Exitoso!");
			datos.put("general", datoGeneral);
			return new ResponseEntity<Object>(datos, HttpStatus.OK);
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron categorias.");
			datos.put("general", datoGeneral);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Obtiene una categoria en especifico por el id.")
	@GetMapping("/getCategoria")
	public ResponseEntity<Object> getCategoria(@Valid @RequestParam String id_categoria){
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			Long id_cate = Long.parseLong(id_categoria);
			CategoriaDTO categoria = categoriaService.buscar(id_cate);
			if(categoria==null) {
				datos.put("error", "El identificador del categoria no existe.");
				datos.put("message", "No existe un categoria con ese identificador.");
				datos.put("categoria", null);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}else {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("categoria", categoria);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "Ha ocurrido un error al buscar la categoria.");
			datos.put("categoria", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(datos, HttpStatus.OK);
	}
	
	@Operation(summary = "Registra una nueva categoria en la base de datos.")
	@PostMapping("/guardarCategoria")
	public ResponseEntity<Object> guardarCategoria(@Valid @RequestBody CategoriaDTO nuevaCategoria, BindingResult bidBindingResult){
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				categoriaService.guardar(nuevaCategoria);
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
	
	@Operation(summary = "Actualiza una categoria existente en la base de datos.")
	@PostMapping("/actualizarCategoria")
	public ResponseEntity<Object> actualizarCategoria(@Valid @RequestBody CategoriaDTO categoria, BindingResult bidBindingResult){
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				//categoriaService.update(categoria);
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
