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

import com.indra.crudtask.app.models.Rol;
import com.indra.crudtask.app.services.RolService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/Api")
@Api(value = "/Api", description = "Servicio para tareas")
public class RolController {
	
	@Autowired
	private RolService rolService;

	@GetMapping("/rol")
	@ApiOperation(value = "Obtiene todos los Roles", produces = "application/json")
	public ResponseEntity<?> buscarTodos(){
		Map<String,Object> response = new HashMap<>();
		List<Rol> rol = null;
		try {
			rol = rolService.buscarTodo();
			if(rol.isEmpty()) {
				response.put("mensaje", "No existen tareas");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Rol>>(rol,HttpStatus.OK);
	}
	
	@GetMapping("/obtener/{id}")
	@ApiOperation(value = "Obtiene Rol segun id", produces = "application/json")
	public ResponseEntity<?> buscarPorId(@ApiParam(value = "Parametro id Rol", required = true) @PathVariable Long id) {
		Map<String,Object> response = new HashMap<>();
		Rol rol = null;
		try {
			rol = rolService.buscarPorId(id);
			if (rol==null) {
				response.put("mensaje", "Rol no existe");
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Rol>(rol,HttpStatus.OK);
	}
	
	@PostMapping("/rolinsert")
	@ApiOperation(value = "Registra tareas", produces = "application/json")
	@Transactional
	public ResponseEntity<?> crearRol(@ApiParam(value = "Datos de entrada del llamado a la capacidad registrar Rol", required = true) @RequestBody Rol rol){
		Map<String,Object> response = new HashMap<>();
		Rol newRol = null;
		try {
		 
			newRol = rolService.guardar(rol);
		} catch (Exception e) {
			response.put("error", e.getLocalizedMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Rol>(newRol,HttpStatus.OK);
	}
	
	@DeleteMapping("/roldelete/{id}")
	@ApiOperation(value = "Elimina una tarea", produces = "application/json")
	public ResponseEntity<?> eliminarRol(@ApiParam(value = "Parametro id Rol", required = true) @PathVariable Long id){
		Map<String,Object> response = new HashMap<>();
		try {
			rolService.eliminarRolPorId(id);
			response.put("mensaje", "Rol ".concat(id.toString()).concat(" Rol eliminado con exito"));
		} catch (Exception e) {
			response.put("mensaje", e.getLocalizedMessage());
		}
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	@PutMapping("/rolupdate/{id}")
	@ApiOperation(value = "Actualiza una tarea", produces = "application/json")
	public ResponseEntity<?> actualizarRol(@PathVariable Long id, @RequestBody Rol rol){
		Map<String, Object> response = new HashMap<>();
		Rol Actual = null;
		Rol Rolresponse = null;
		
		try {
			Actual = rolService.buscarPorId(id);
			
			Actual.setDescripcion(rol.getDescripcion());			
			Actual.setNombreRol(rol.getNombreRol());	
			
			Rolresponse = rolService.guardar(Actual);
		} catch (Exception e) {
			response.put("mensaje", e.getLocalizedMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Rol>(Rolresponse,HttpStatus.OK);
	}
}
