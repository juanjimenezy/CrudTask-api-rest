package com.indra.crudtask.app.interfaces;

import java.util.List;

import com.indra.crudtask.app.models.Rol;

public interface IRolService {
	
	public Rol guardar(Rol rol);
	
	public List<Rol> buscarTodo();
	
	public Rol buscarPorId(Long id);
	
	public void eliminarRolPorId(Long id);

}
