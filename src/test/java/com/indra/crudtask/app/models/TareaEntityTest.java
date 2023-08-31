package com.indra.crudtask.app.models;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.indra.crudtask.app.enums.EstadoTarea;

public class TareaEntityTest {

	Tarea tareaTest;

	@BeforeEach
	void initMetodoTest() {
		this.tareaTest = new Tarea();
		this.tareaTest.setNombre("HU_FCRE_05");
		this.tareaTest.setEstado(EstadoTarea.NUEVA);
		this.tareaTest.setSprint(5L);
		this.tareaTest.setPorcentaje(100.0);
	}

	@AfterEach
	void tearDown() {
		System.out.println("Finalizando metodo de prueba.");
	}

	@BeforeAll
	static void beforeAll() {
		System.out.println("Inicializando el test");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("Finalizando test");
	}

	@Test
	@DisplayName("probando nombre de la tarea")
	void testNombreCuenta() {
		String nombreEsperado = "HU_FCRE_05";
		assertAll(() -> {
			assertTrue(this.tareaTest.getNombre().equals(nombreEsperado), "El nombre no es el esperado");
		}, () -> {
			assertNotNull(this.tareaTest.getNombre(), "El nombre no puede ser null");
		}, () -> {
			assertFalse(this.tareaTest.getNombre().length()< 3, "El nombre no puede ser tan corto");
		});
	}

	@Test
	@DisplayName("probando sprint de la tarea")
	void testSetSprint() {
		assertFalse(tareaTest.getSprint().compareTo(0L) < 0L, "Valor de sprint no puede ser menor a 5");
	}

	@Test
	@DisplayName("probando porcentaje de la tarea")
	void testPorcentaje() {
		assertFalse(this.tareaTest.getPorcentaje().compareTo(0.0) < 0, "Porcentaje no puede ser menor a 0");
		assertTrue(this.tareaTest.getPorcentaje().compareTo(100.1) < 0, "Porcentaje no puede ser mayor a 100");
	}
	
	@Test
	@DisplayName("probando estado de la tarea")
	void testEstado() {
		assertNotNull(tareaTest.getEstado());
	}

}
