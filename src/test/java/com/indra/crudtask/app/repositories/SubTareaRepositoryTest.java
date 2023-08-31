package com.indra.crudtask.app.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.indra.crudtask.app.exceptions.DuracionInvalidaException;
import com.indra.crudtask.app.models.SubTarea;
import com.indra.crudtask.app.models.SubTareaTest;

class SubTareaRepositoryTest {

	private static final Logger logger = LogManager.getLogger(SubTareaRepository.class);
	private SubTarea subTareaTest = new SubTarea();
	
	@Autowired (required = true)
	private SubTareaRepository subTareaRepository;
	
	@BeforeEach
	public void setup() {
		logger.info("inicia BeforeEach");
		
		subTareaTest.setId(4L);
		subTareaTest.setHoras(53L);
		subTareaTest.setEstado("en Proceso");
		subTareaTest.setNombre("Analisis");
		subTareaTest.setPorcentaje(17);
	}
	
	@Test
	@DisplayName("Test para guardar una subtarea")
	void saveSubTarea() {
//		SubTarea newSubTarea = new SubTarea();
		
//		newSubTarea.setId(4L);
//		newSubTarea.setHoras(53L);
//		newSubTarea.setEstado("en Proceso");
//		newSubTarea.setNombre("Analisis");
//		newSubTarea.setPorcentaje(17);
		assertThat(subTareaRepository.save(subTareaTest)).isNotNull();
	}
}
