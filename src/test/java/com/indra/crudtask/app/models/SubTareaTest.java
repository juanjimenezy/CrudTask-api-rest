package com.indra.crudtask.app.models;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SubTareaTest {

	private SubTarea subTareaTest = new SubTarea();	
	private static final Logger logger = LogManager.getLogger(SubTareaTest.class);
	
	@BeforeEach
	void initMetodoTest() {
		subTareaTest.setId(4L);
		subTareaTest.setHoras(53L);
		subTareaTest.setEstado("en Proceso");
		subTareaTest.setNombre("Analisis");
		subTareaTest.setPorcentaje(17);
		
		logger.info("testeando...");
	}
	
	@BeforeAll
 	static void beforeAll() {
		logger.info("Inicializando el test");
	}
	
	@AfterAll 
	static void afterAll() {
		logger.info("Finalizando test");
	}

	@Test
	@DisplayName("probando el nombre de la subtarea")
	void testNombreSubTarea() {
		
		String nombreEsperado = "Analisis";
//		String nombreEsperado = null;
		
		assertAll(() -> {
			assertTrue(subTareaTest.getNombre().equals(nombreEsperado), "El nombre NO corresponde al esperado");
		}, () -> {
			assertNotNull(subTareaTest.getNombre(), "El nombre no puede ser null");
		}, () -> {
			assertFalse(subTareaTest.getNombre().length() < 2, "la longitud del nombre no es la permitida");
		});
	}
	
	@Test
	@DisplayName("probando horas de la tarea")
	void testHoras() {
		assertTrue(subTareaTest.getHoras() > 0, "NO tiene asiganadas horas");
	}
	
	@Test
	@DisplayName("Compara dos subtareas")
	void testCuentasIguales() {
		
		SubTarea subTareaTest2 = new SubTarea();
		
		subTareaTest2.setId(5L);
		subTareaTest2.setHoras(53L);
		subTareaTest2.setEstado("en Proceso");
		subTareaTest2.setNombre("Analisis");
		subTareaTest2.setPorcentaje(17);
		
		assertEquals(subTareaTest2, subTareaTest);
	}
}
