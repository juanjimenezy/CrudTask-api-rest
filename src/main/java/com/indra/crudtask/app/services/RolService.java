package com.indra.crudtask.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.crudtask.app.interfaces.IRolService;
import com.indra.crudtask.app.models.Rol;
import com.indra.crudtask.app.repositories.RolRepository;

@Service
public class RolService implements IRolService{

	@Autowired
	private RolRepository rolRepository;
	
	
	@Override
	public Rol guardar(Rol rol) {
		return rolRepository.save(rol);
	}

	@Override
	public List<Rol> buscarTodo() {
		return rolRepository.findAll();
	}

	@Override
	public Rol buscarPorId(Long id) {
		return rolRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarRolPorId(Long id) {
		rolRepository.deleteById(id);
		
	}


	

}
