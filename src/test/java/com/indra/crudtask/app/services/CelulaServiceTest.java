package com.indra.crudtask.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.indra.crudtask.app.models.Celula;

class CelulaServiceTest {

	Celula celulaTest;
	
	@BeforeEach
	void setup() {
		
		System.out.println("Inició test.");
		
		celulaTest = new Celula();
		celulaTest.setNombre("Celula Recaudo");
		celulaTest.setProductOwner("David");
		celulaTest.setProyecto("Indra");
	}
	
	@AfterEach
	void stop() {
		System.out.println("Finalizó test.");
	}
	
	@Test
	@DisplayName("Test nombre celula.")
	void nombreCelula() {
		String nombreEsperado = "CELULA RECAUDO";
		assertEquals(celulaTest.getNombre().toUpperCase(),nombreEsperado);
	}
	
	@Test
	@DisplayName("Test nombre productOwner.")
	void testSetSprint() {
		assertFalse(celulaTest.getNombre().length() < 0L);
	}
	
	@Test
	@DisplayName("Test nombre proyecto")
	void testPorcentaje() {
		String proyectoEsperado = "Keralty";
		assertNotEquals(celulaTest.getProyecto(), proyectoEsperado);
	}
}
