package com.indra.crudtask.app.services;

import com.indra.crudtask.app.interfaces.IPersonaService;
import com.indra.crudtask.app.models.Persona;
import com.indra.crudtask.app.repositories.PersonaRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


@Service
@Scope
@Transactional
@AllArgsConstructor
public class PersonaService implements IPersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public List<Persona> buscarTodas() {
		return personaRepository.findAll();
	}

	@Override
	public Persona buscarPorId(Long id) {
		return personaRepository.findById(id).orElse(null);
	}

	@Override
	public Persona buscarPorId2(Long id) {
		return personaRepository.findById(id).get();
	}

	@Override
	public Persona guardar(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public void eliminarPorId(Long id) {
		personaRepository.deleteById(id);
	}

	@Override
	public Persona actualizar(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public Persona actualizarPorId(Long id, Persona persona) {
		Persona update = personaRepository.findById(id).get();
		update.setNombre(persona.getNombre());
		update.setNumeroIdentificacion(persona.getNumeroIdentificacion());
		update.setEmail(persona.getEmail());
		update.setNickName(persona.getNickName());
		update.setIdRol(persona.getIdRol());
		personaRepository.save(update);
		return update;
	}

}
