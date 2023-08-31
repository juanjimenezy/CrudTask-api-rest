package com.indra.crudtask.app.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.indra.crudtask.app.models.Celula;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
class CelulaRepositoryTest {

	@Autowired (required = true)
	public CelulaRepository celulaRepository;
	
	public Celula celula;
	@BeforeEach
	public void setup() {
		System.out.println("Inicio antes");
		celula = new Celula();
		celula.setNombre("Celula Liliana");
		celula.setProductOwner("David");
		celula.setProyecto("Indra");
		
	}

	@Test
	@DisplayName("Test para guardar una nueva celula.")
	void saveCelula() {
		Celula nuevaCelula = new Celula();
		nuevaCelula.setNombre("Celula David");
		nuevaCelula.setProductOwner("David");
		nuevaCelula.setProyecto("Indra");
		
		Celula celulaGuardado = celulaRepository.save(nuevaCelula);
		
		assertThat(celulaGuardado).isNotNull();
	}
	
	@Test
	@DisplayName("Test para listar celulas")
	void listarCelulas() {
		Celula nuevaCelula = new Celula();
		nuevaCelula.setNombre("Celula Juan");
		nuevaCelula.setProductOwner("Juan");
		nuevaCelula.setProyecto("Indra");
		
		celulaRepository.save(nuevaCelula);
		celulaRepository.save(celula);
		
		List<Celula> lstCelulas = celulaRepository.findAll();
		assertThat(lstCelulas).isNotNull().hasSize(2);
		
	}
	
	@Test
	@DisplayName("Test para listar celulas")
	void eliminarCelula() {
		
		celulaRepository.save(celula);
		
		List<Celula> lstCelulas = celulaRepository.findAll();

        List<Celula> celula = lstCelulas.stream()               
                .filter(nombreCelula -> "Celula Liliana".equals(this.celula.getNombre()))     
                .collect(Collectors.toList());    
        celulaRepository.deleteById(celula.get(0).getId());
        
		assertThat(celulaRepository.findById(celula.get(0).getId())).isEmpty();
	
	}
}
