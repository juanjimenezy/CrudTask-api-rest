package com.indra.crudtask.app.controllers;

import java.util.List;

import com.indra.crudtask.app.interfaces.IPersonaService;
import lombok.AllArgsConstructor;
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

import com.indra.crudtask.app.models.Persona;

@RestController
@RequestMapping("/personas")
@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class PersonaController {

	@Autowired
    private IPersonaService personaService;

    @GetMapping()
    private ResponseEntity<List<Persona>> findAll() {
        return ResponseEntity.ok(personaService.buscarTodas());
    }

    @GetMapping("/{id}")
    public Persona get(@PathVariable Long id){
        return personaService.buscarPorId2(id);
    }

    @PostMapping
    public ResponseEntity<Persona> post(@RequestBody Persona persona) {
        try {
            Persona save = personaService.guardar(persona);
            return ResponseEntity.ok(save);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Long id) {
        personaService.eliminarPorId(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Persona> update(@RequestBody Persona persona) {
        Persona update = personaService.actualizar(persona);
        return ResponseEntity.ok(update);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updateById(@PathVariable("id") Long id, @RequestBody Persona persona) {

        try {
            Persona update = personaService.actualizarPorId(id, persona);
            return ResponseEntity.ok(update);
            //return ResponseEntity.created(new URI("/persona/" + persona.getId())).body(persona);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}