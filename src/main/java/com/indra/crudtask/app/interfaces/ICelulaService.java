package com.indra.crudtask.app.interfaces;

import java.util.List;

import com.indra.crudtask.app.models.Celula;

public interface ICelulaService {
	
	public List<Celula> buscarTodas();
	
	public Celula buscarPorId(Long id);

	public void updateCelula(Celula celula);

}
