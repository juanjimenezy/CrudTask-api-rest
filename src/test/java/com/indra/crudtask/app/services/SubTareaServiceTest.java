package com.indra.crudtask.app.services;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.indra.crudtask.app.exceptions.DuracionInvalidaException;
import com.indra.crudtask.app.interfaces.ISubTareaService;
import com.indra.crudtask.app.models.SubTarea;
import com.indra.crudtask.app.models.SubTareaTest;
import com.indra.crudtask.app.repositories.SubTareaRepository;

class SubTareaServiceTest {

	static final Logger logger = LogManager.getLogger(SubTareaServiceTest.class);
	SubTarea subTareaTest = new SubTarea();
	
	@Autowired (required = true)
	private ISubTareaService subTareaService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		subTareaTest.setId(4L);
		subTareaTest.setHoras(0L);
		subTareaTest.setEstado("en Proceso");
		subTareaTest.setNombre("Analisis");
		subTareaTest.setPorcentaje(17);
	}

	@AfterEach
	void tearDown() throws Exception {
		logger.info("End test.");
	}
	
	@Test
	@DisplayName("Test guardar subtarea")
	void testGuardarSubTarea() {
		Exception exception = assertThrows(DuracionInvalidaException.class, () -> {
			subTareaService.guardar(subTareaTest);
		});
		
		String msgActual = exception.getMessage();
		String msgEsperado = "la duracion en horas debe ser mayor a ro";
		
		assertEquals(msgEsperado, msgActual);
	}
}
