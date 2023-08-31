package com.indra.crudtask.app.interfaces;

import java.util.List;

import com.indra.crudtask.app.models.SubTarea;

public interface ISubTareaService {
	
	public SubTarea guardar(SubTarea subTarea);
	
	public List<SubTarea> buscarTodas();
	
	public SubTarea buscarPorId(Long id);
	
	public void eliminarSubTareaPorId(Long id);

}
