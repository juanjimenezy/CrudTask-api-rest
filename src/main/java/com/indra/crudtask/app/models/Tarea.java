package com.indra.crudtask.app.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.indra.crudtask.app.enums.EstadoTarea;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "tareas")
@Getter @Setter
@NoArgsConstructor
public class Tarea implements Serializable{

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

	public Long getSprint() {
		return sprint;
	}

	public void setSprint(Long sprint) {
		this.sprint = sprint;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public EstadoTarea getEstado() {
		return estado;
	}

	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}

	public List<SubTarea> getSubTareas() {
		return subTareas;
	}

	public void setSubTareas(List<SubTarea> subTareas) {
		this.subTareas = subTareas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Celula getCelula() {
		return celula;
	}

	public void setCelula(Celula celula) {
		this.celula = celula;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_sequence_tarea")
	@SequenceGenerator(name="id_sequence_tarea", sequenceName = "sq_id_tarea", allocationSize = 1, initialValue = 1)
	private Long id;

	private String nombre;

	private Long sprint;

	private Double porcentaje;

	@Enumerated(EnumType.STRING)
	private EstadoTarea estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarea" , cascade = CascadeType.ALL)
	private List<SubTarea> subTareas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name="persona_id")
	private Persona persona;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name="celula_id")
	private Celula celula;
	
	@PreUpdate
	public void preUpdate () {
		this.calcularPorcentaje();
	}
	
	private void calcularPorcentaje () {
		int cant = 0;
		try {
			
		
		for (SubTarea subtarea : this.subTareas) {
			cant = cant+subtarea.getPorcentaje();
		}
		this.porcentaje = (double) (cant / this.subTareas.size());
		} catch (Exception e) {
		}
	}
	
	private static final long serialVersionUID = 1L;

}
