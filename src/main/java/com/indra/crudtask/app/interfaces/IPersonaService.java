package com.indra.crudtask.app.interfaces;

import java.util.List;

import com.indra.crudtask.app.models.Persona;

public interface IPersonaService {
	
	public List<Persona> buscarTodas();
	
	public Persona buscarPorId(Long id);

	public Persona buscarPorId2(Long id);

	public Persona guardar(Persona persona);

	public void eliminarPorId(Long id);

	public Persona actualizar(Persona persona);

	public Persona actualizarPorId(Long id, Persona persona);

}
