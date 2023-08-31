package com.indra.crudtask.app.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.indra.crudtask.app.models.Celula;
import com.indra.crudtask.app.repositories.CelulaRepository;
import com.indra.crudtask.app.utility.Utilidades;

@RestController
@RequestMapping("/celula")
@CrossOrigin(value = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class CelulaController {

	@Autowired (required = true)
	private CelulaRepository celulaRepository;
	

	@GetMapping("/get/all")
	public ResponseEntity<List<Celula>> getAllCelula() {
		return ResponseEntity.ok(celulaRepository.findAll());

	}

	@PostMapping
	public ResponseEntity<Celula> saveCelula(@RequestBody String peticion) {
		try {
			Utilidades utilidades= new Utilidades();
			String param = utilidades.decode(peticion);
			Gson gson = new Gson();
			Celula celula = gson.fromJson(param, Celula.class);
			
			celula.setNombre(celula.getNombre());
			celula.setProductOwner(celula.getProductOwner());
			celula.setProyecto(celula.getProyecto());
			Celula celulaGuardado = celulaRepository.saveAndFlush(celula);
			return ResponseEntity.created(new URI("/celula/" + celulaGuardado.getId())).body(celulaGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<Boolean> deleteCelula(@PathVariable("id") Long id) {
		celulaRepository.deleteById(id);
		return ResponseEntity.ok(!(celulaRepository.findById(id).isPresent()));

	}

	@PutMapping()
	public ResponseEntity<Celula> updateCelula(@RequestBody Celula celula) {
		try {
			celula.setId(celula.getId());
			celula.setNombre(celula.getNombre());
			celula.setProductOwner(celula.getProductOwner());
			celula.setProyecto(celula.getProyecto());
			celulaRepository.save(celula);
			return ResponseEntity.created(new URI("/celula/" + celula.getId())).body(celula);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		}
	}
}
