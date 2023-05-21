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
import com.ufps.UFPSaberPRO.dto.PreguntaDTO;
import com.ufps.UFPSaberPRO.dto.Simu_UsuDTO;
import com.ufps.UFPSaberPRO.dto.SimulacroDTO;
import com.ufps.UFPSaberPRO.serviceImpl.PreguntaServiceImpl;
import com.ufps.UFPSaberPRO.serviceImpl.Simu_UsuServiceImpl;
import com.ufps.UFPSaberPRO.serviceImpl.SimulacroServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/simulacros")
public class SimulacroRestController {

	@Autowired
	private SimulacroServiceImpl simulacroService;
	
	@Autowired
	private PreguntaServiceImpl preguntaService;
	
	@Autowired
	private Simu_UsuServiceImpl simu_usuService;

	private DatogeneralDTO datoGeneral;

	public SimulacroRestController() {
		datoGeneral = new DatogeneralDTO();
	}
	
	@Operation(summary = "Obtiene los datos generales de simulacro para el usuario.")
	@GetMapping("/general")
	public ResponseEntity<Object> general(@RequestParam String id_usuario,@RequestParam String id_programa){
		Map<String,Object> datos = new LinkedHashMap<>();
		Long id_user = Long.parseLong(id_usuario);
		Long id_prg = Long.parseLong(id_programa);
		try {
			List<SimulacroDTO> simulacros_programa = simulacroService.getSimulacrosUsuPrg(id_user,id_prg);
			datoGeneral.setSimulacros_programa(simulacros_programa);
			
			datos.put("error", null);
			datos.put("message", "¡Proceso Exitoso!");
			datos.put("general", datoGeneral);
			return new ResponseEntity<Object>(datos, HttpStatus.OK);
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron simulacros.");
			datos.put("general", datoGeneral);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Obtiene una lista de simulacros.")
	@GetMapping("/getSimulacros")
	public ResponseEntity<Object> getSimulacros() {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			List<SimulacroDTO> simulacros = simulacroService.getSimulacros();
			if (simulacros.size() > 0) {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("simulacros", simulacros);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			} else {
				datos.put("error", null);
				datos.put("message", "No se encontraron simulacros.");
				datos.put("simulacros", null);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron simulacros.");
			datos.put("simulacros", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Obtiene un simulacro en especifico por el id.")
	@GetMapping("/getSimulacro")
	public ResponseEntity<Object> getSimulacro(@Valid @RequestParam String id_simulacro) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			Long id_simu = Long.parseLong(id_simulacro);
			SimulacroDTO simulacro = simulacroService.buscar(id_simu);
			if (simulacro == null) {
				datos.put("error", "El identificador del simulacro no existe.");
				datos.put("message", "No existe un simulacro con ese identificador.");
				datos.put("simulacro", null);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			} else {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("simulacro", simulacro);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "Ha ocurrido un error al buscar la simulacro.");
			datos.put("simulacro", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(datos, HttpStatus.OK);
	}

	@Operation(summary = "Registra un nuevo simulacro en la base de datos.")
	@PostMapping("/guardarSimulacro")
	public ResponseEntity<Object> guardarSimulacro(@Valid @RequestBody SimulacroDTO nuevoSimulacro,
			BindingResult bidBindingResult) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				nuevoSimulacro.setSimu_estado("I");
				simulacroService.guardar(nuevoSimulacro);
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

	@Operation(summary = "Actualiza un simulacro existente en la base de datos.")
	@PutMapping("/actualizarSimulacro")
	public ResponseEntity<Object> actualizarSimulacro(@Valid @RequestBody SimulacroDTO simulacro,
			BindingResult bidBindingResult) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				simulacroService.update(simulacro);
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
	
	@Operation(summary = "Obtiene una lista de preguntas de un simulacro en especifico.")
	@GetMapping("/getPreguntas")
	public ResponseEntity<Object> getPreguntas(@RequestParam String id_simulacro){
		Long id_simu = Long.parseLong(id_simulacro);
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			List<PreguntaDTO> preguntas = preguntaService.getPreguntasBySimulacro(id_simu);
			if(preguntas.size()>0) {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("preguntas", preguntas);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}else {
				datos.put("error", "No se encontraron preguntas");
				datos.put("message", "No se encontraron preguntas registradas.");
				datos.put("preguntas", preguntas);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron preguntas.");
			datos.put("preguntas", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Obtiene una lista de preguntas que no estan relacionadas a un simulacro en especifico.")
	@GetMapping("/getPreguntasDiferentes")
	public ResponseEntity<Object> getPreguntasDiferentes(@RequestParam String id_simulacro){
		Long id_simu = Long.parseLong(id_simulacro);
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			List<PreguntaDTO> preguntas = preguntaService.getPreguntasByDifferentSimu(id_simu);
			if(preguntas.size()>0) {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("preguntas", preguntas);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}else {
				datos.put("error", "No se encontraron preguntas");
				datos.put("message", "No se encontraron preguntas.");
				datos.put("preguntas", preguntas);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron preguntas.");
			datos.put("preguntas", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Obtiene una lista de simulacros de las convocatorias activas que se encuentren"
			+ "relacionadas a un usuario y que esten activas.")
	@GetMapping("/getSimulacrosConvo")
	public ResponseEntity<Object> getSimulacrosConvo(@RequestParam String id_usuario) {
		Map<String, Object> datos = new LinkedHashMap<>();
		Long id_usu = Long.parseLong(id_usuario);
		try {
			List<SimulacroDTO> simulacros = simulacroService.getSimulacrosConvo(id_usu, "A");
			if (simulacros.size() > 0) {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("simulacros", simulacros);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			} else {
				datos.put("error", null);
				datos.put("message", "No se encontraron simulacros.");
				datos.put("simulacros", simulacros);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron simulacros.");
			datos.put("simulacros", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Obtiene una lista de simulacros"
			+ "relacionadas a un usuario y que no esten activas.")
	@GetMapping("/getSimulacrosUsu")
	public ResponseEntity<Object> getSimulacrosUsu(@RequestParam String id_usuario) {
		Map<String, Object> datos = new LinkedHashMap<>();
		Long id_usu = Long.parseLong(id_usuario);
		try {
			List<SimulacroDTO> simulacros = simulacroService.getSimulacrosUsu(id_usu);
			if (simulacros.size() > 0) {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("simulacros", simulacros);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			} else {
				datos.put("error", null);
				datos.put("message", "No se encontraron simulacros.");
				datos.put("simulacros", simulacros);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron simulacros.");
			datos.put("simulacros", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Obtiene una lista de preguntas de un simulacro en especifico.")
	@GetMapping("/getPregOpcSimu")
	public ResponseEntity<Object> getPregOpcSimu(@RequestParam String id_simulacro){
		Long id_simu = Long.parseLong(id_simulacro);
		Map<String,Object> datos = new LinkedHashMap<>();
		try {
			List<PreguntaDTO> preguntas = preguntaService.getPreguntasOpcionesBySimulacro(id_simu);
			if(preguntas.size()>0) {
				datos.put("error", null);
				datos.put("message", "¡Proceso Exitoso!");
				datos.put("preguntas", preguntas);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}else {
				datos.put("error", "No se encontraron preguntas");
				datos.put("message", "No se encontraron preguntas registradas.");
				datos.put("preguntas", preguntas);
				return new ResponseEntity<Object>(datos, HttpStatus.OK);
			}
		} catch (Exception e) {
			datos.put("error", e.getMessage());
			datos.put("message", "No se encontraron preguntas.");
			datos.put("preguntas", null);
			return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Registra un nuevo simulacro en la base de datos.")
	@PostMapping("/presentarSimulacro")
	public ResponseEntity<Object> presentarSimulacro(@Valid @RequestBody Simu_UsuDTO simu_usu,
			BindingResult bidBindingResult) {
		Map<String, Object> datos = new LinkedHashMap<>();
		try {
			if (bidBindingResult.hasErrors()) {
				datos.put("error", bidBindingResult.getFieldError().getDefaultMessage());
				datos.put("message", "Ha ocurrido un error con los datos ingresados, verifique e intente nuevamente.");
				return new ResponseEntity<Object>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				simu_usuService.presentar_simulacro(simu_usu);
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
