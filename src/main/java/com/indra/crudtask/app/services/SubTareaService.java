package com.indra.crudtask.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.crudtask.app.interfaces.ISubTareaService;
import com.indra.crudtask.app.models.SubTarea;
import com.indra.crudtask.app.repositories.SubTareaRepository;

@Service
public class SubTareaService implements ISubTareaService{

	@Autowired
	private SubTareaRepository subTareaRepository;
	
	@Override
	public SubTarea guardar(SubTarea subTarea) {
		return subTareaRepository.save(subTarea);
	}

	@Override
	public List<SubTarea> buscarTodas() {
		return subTareaRepository.findAll();
	}

	@Override
	public SubTarea buscarPorId(Long id) {
		return subTareaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarSubTareaPorId(Long id) {
		subTareaRepository.deleteById(id);
	}

}
