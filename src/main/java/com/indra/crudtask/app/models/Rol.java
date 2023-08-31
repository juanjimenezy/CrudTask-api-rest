package com.indra.crudtask.app.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="roles")
@Getter @Setter
public class Rol implements Serializable {

	public Rol(Long id, String nombreRol, String descripcion) {
		super();
		this.id = id;
		this.nombreRol = nombreRol;
		this.descripcion = descripcion;
	}

	public Rol() {
		super();
	}

	private static final long serialVersionUID = 1L;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_sequence_roles")
	@SequenceGenerator(name="id_sequence_roles", sequenceName = "sq_id_roles", allocationSize = 1, initialValue = 1)
	private Long id;
	
	private String nombreRol;
	
	private String descripcion;
	
}
