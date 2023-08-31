package com.indra.crudtask.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.crudtask.app.interfaces.ICelulaService;
import com.indra.crudtask.app.interfaces.IPersonaService;
import com.indra.crudtask.app.interfaces.ITareaService;
import com.indra.crudtask.app.models.Tarea;
import com.indra.crudtask.app.models.Persona;
import com.indra.crudtask.app.repositories.TareaRepository;

import lombok.AllArgsConstructor;

@Service
@Scope
@Transactional
@AllArgsConstructor
public class TareaService implements ITareaService{
	
	@Autowired
	private TareaRepository tareaRepository;
	@Autowired	
	private IPersonaService personaService;
	
	@Autowired
	private ICelulaService celulaService;
	
	@Override
	public Tarea guardar(Tarea tarea) {
		return tareaRepository.save(tarea);
	}
	
	@Override
	public Tarea actualizar(Tarea tarea) {
							
		Tarea tareaActual = tareaRepository.findById(tarea.getId()).get();
			tareaActual.setNombre(tarea.getNombre());
			tareaActual.setEstado(tarea.getEstado());
			tareaActual.setPorcentaje(tarea.getPorcentaje());
			tareaActual.setSprint(tarea.getSprint());
			if(tarea.getPersona() != null) {
			Persona persona = personaService.buscarPorId(tarea.getPersona().getId());
			
			tareaActual.setPersona(persona);
			}
			if(tarea.getCelula() != null)
			tareaActual.setCelula(celulaService.buscarPorId(tarea.getCelula().getId()));
		return tareaRepository.save(tareaActual);
	}

	@Override
	public List<Tarea> buscarTodas() {
		return tareaRepository.findAll();
	}

	@Override
	public Tarea buscarPorId(Long id) {
		return tareaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarTareaPorId(Long id) {
		tareaRepository.deleteById(id);
	}

}
