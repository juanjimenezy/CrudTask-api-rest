package com.indra.crudtask.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_usuarios")
	@SequenceGenerator(name = "id_sequence_usuarios", sequenceName = "sq_id_usuarios", allocationSize = 1, initialValue = 1)
	private Long id;
	
	private String nombre;
	
	private String user;
	
	private String password;
	
	@OneToOne
	@JoinColumn(name="celula_id")
	private Celula id_celula;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Celula getId_celula() {
		return id_celula;
	}

	public void setId_celula(Celula id_celula) {
		this.id_celula = id_celula;
	}

	private static final long serialVersionUID = 1L;
}
