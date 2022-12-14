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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.UFPSaberPRO.dto.DatogeneralDTO;
import com.ufps.UFPSaberPRO.dto.SubcatergoriaDTO;
import com.ufps.UFPSaberPRO.serviceImpl.SubcategoriaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/subcategorias")
public class SubcategoriaRestController {

	@Autowired
	private SubcategoriaServiceImpl subcategoriaService;

	private DatogeneralDTO datoGeneral;

	public SubcategoriaRestController() {
		datoGeneral = new DatogeneralDTO();
	}
	
	@Operation(summary = "Obtiene una subcategoria por el id.")
	@GetMapping("/getSubcategoria")
	public ResponseEntity<Object> getSubcategoria(@RequestParam String id_subcategoria) {
		Map<String, Object> datos = new LinkedHashMap<>();
		Long id_sub = Long.parseLong(id_subcategoria);
		try {
			SubcatergoriaDTO subcategoria = subcategoriaService.buscar(id_sub);
			if(subcategoria!=null) {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("subcategoria", subcategoria);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}else {
				datos.put("error", "No se encontró la subcategoria.");
				datos.put("message", "No se encontró la subcategoria.");
				datos.put("subcategoria", null);
				return new ResponseEntity<Object>(datos, HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "Ha ocurrido un error interno.");
			datos.put("subcategoria", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Obtiene los datos generales de subcategoria para el usuario.")
	@GetMapping("/general")
	public ResponseEntity<Object> general(@RequestParam String id_usuario, @RequestParam String id_programa) {
		Map<String, Object> datos = new LinkedHashMap<>();
		Long id_user = Long.parseLong(id_usuario);
		Long id_prg = Long.parseLong(id_programa);
		try {
			List<SubcatergoriaDTO> subcategorias_programa = subcategoriaService.getSubcategoriasByUsuPrg(id_user,id_prg);
			datoGeneral.setSubcategorias_programa(subcategorias_programa);

			datos.put("error", null);
			datos.put("message", "¡Proceso Exitoso!");
			datos.put("general", datoGeneral);
			return new ResponseEntity<Object>(datos, HttpStatus.OK);
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron subcategorias.");
			datos.put("general", datoGeneral);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Registra una nueva subcategoria en la base de datos.")
	@PostMapping("/guardarSubcategoria")
	public ResponseEntity<Object> guardarSubcategoria(@Valid @RequestBody SubcatergoriaDTO subcatergoria,
			BindingResult bidBindingResult) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				subcategoriaService.guardar(subcatergoria);
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

	@Operation(summary = "Actualiza una subcategoria existente en la base de datos.")
	@PutMapping("/actualizarSubcategoria")
	public ResponseEntity<Object> actualizarSubcategoria(@Valid @RequestBody SubcatergoriaDTO subcategoria,
			BindingResult bidBindingResult) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				subcategoriaService.update(subcategoria);
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
