package com.indra.crudtask.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.indra.crudtask.app.interfaces.ICelulaService;
import com.indra.crudtask.app.models.Celula;
import com.indra.crudtask.app.repositories.CelulaRepository;

@Service
@Scope
@Component
public class CelulaService implements ICelulaService {

	@Autowired (required=true)
	private CelulaRepository celulaRepository;

	@Override
	public void updateCelula(Celula celula) {
		celulaRepository.save(celula);
	}

	@Override
	public List<Celula> buscarTodas() {
		return celulaRepository.findAll();
	}

	@Override
	public Celula buscarPorId(Long id) {
		return celulaRepository.findById(id).orElse(null);
	}

}
