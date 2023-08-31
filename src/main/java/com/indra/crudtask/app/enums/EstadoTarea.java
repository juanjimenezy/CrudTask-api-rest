package com.indra.crudtask.app.enums;

public enum EstadoTarea {

	NUEVA("NUEVA"), DESARROLLO("EN DESARROLLO"), TERMINADA("TERMINADA");

	private String value;

	private EstadoTarea() {

	}

	private EstadoTarea(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
