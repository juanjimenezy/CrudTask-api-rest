package com.indra.crudtask.app.interfaces;

import java.util.List;

import com.indra.crudtask.app.models.Tarea;

public interface ITareaService {
	
	public Tarea guardar(Tarea tarea);
	
	public List<Tarea> buscarTodas();
	
	public Tarea buscarPorId(Long id);
	
	public void eliminarTareaPorId(Long id);

	public Tarea actualizar(Tarea tarea);

}
