package com.indra.crudtask.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.crudtask.app.models.SubTarea;
import com.indra.crudtask.app.models.Tarea;
import com.indra.crudtask.app.services.SubTareaService;
import com.indra.crudtask.app.services.TareaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("Api")
@Api(value = "/Api", description = "Servicio para subtareas")
public class SubTareaController {

	@Autowired
	private SubTareaService subTareaService;
	
	@Autowired
	private TareaService tareaService;
	
	@GetMapping("/subtareas")
	@ApiOperation(value = "Obtiene todas las subtareas", produces = "application/json")
	public ResponseEntity<?> buscarTodos() {
		Map<String, Object> response = new HashMap<>();
		List<SubTarea> subTareas = null;
		try {
			subTareas = subTareaService.buscarTodas();
			if (subTareas.isEmpty()) {
				response.put("mensaje", "No existen subtareas");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<SubTarea>>(subTareas, HttpStatus.OK);
	}
	
	@GetMapping("/subtarea/{id}")
	@ApiOperation(value = "Obtiene subtarea segun id", produces = "application/json")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Parametro id subtarea", required = true) @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		SubTarea subTarea = null;
		try {
			subTarea = subTareaService.buscarPorId(id);
			if (subTarea == null) {
				response.put("mensaje", "subTarea no existe");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<SubTarea>(subTarea, HttpStatus.OK);
	}
	
	@PostMapping("/subtarea/{id}")
	@ApiOperation(value = "crea subtareas", produces = "application/json")
	@Transactional
	public ResponseEntity<?> crearSubTarea(@ApiParam(value = "Datos de entrada del llamado a la capacidad crear subtarea", required = true) @RequestBody SubTarea subTarea,
														@ApiParam(value = "Parametro id tarea", required = true) @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Tarea tarea = null;
		SubTarea newSubTarea = null;
		try {
			tarea = tareaService.buscarPorId(id);
			subTarea.setTarea(tarea);
			newSubTarea = subTareaService.guardar(subTarea);
		} catch (Exception e) {
			response.put("error", e.getLocalizedMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<SubTarea>(newSubTarea, HttpStatus.OK);
	}
	
	@DeleteMapping("/subtarea/{id}")
	@ApiOperation(value = "Elimina una subtarea", produces = "application/json")
	public ResponseEntity<?> eliminarSubTarea(@ApiParam(value = "Parametro id subtarea", required = true) @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			subTareaService.eliminarSubTareaPorId(id);
			response.put("mensaje", " subtarea ".concat(id.toString()).concat(" fue eliminada con exito"));
		} catch (Exception e) {
			response.put("mensaje", e.getLocalizedMessage());
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PutMapping("/subtarea/{id}")
	@ApiOperation(value = "Actualiza una subtarea", produces = "application/json")
	public ResponseEntity<?> actualizarSubTarea(@PathVariable Long id, @RequestBody SubTarea subTarea) {
		Map<String, Object> response = new HashMap<>();
		SubTarea actual = new SubTarea();
		SubTarea subTareaResponse = null;
		try {
			actual = subTareaService.buscarPorId(id);
			actual.setNombre(subTarea.getNombre());
			actual.setHoras(subTarea.getHoras());
			actual.setEstado(subTarea.getEstado());
			actual.setPorcentaje(subTarea.getPorcentaje());
			subTareaResponse = subTareaService.guardar(actual);
			subTareaResponse.getTarea().preUpdate();
			tareaService.guardar(subTareaResponse.getTarea());
		} catch (Exception e) {
			response.put("mensaje", e.getLocalizedMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<SubTarea>(subTareaResponse, HttpStatus.OK);
	}
}
