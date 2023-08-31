package com.indra.crudtask.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import com.indra.crudtask.app.models.Rol;

class RolServiceTest {

	Rol rol;
	
	@BeforeEach
	void setup() {
		
		System.out.println("start test.");
		
		rol = new Rol();
		rol.setNombreRol("ScrumMaster");
		rol.setDescripcion("Rol para el cargo de scrum MAster");	
		
	}
	
	@AfterEach
	void stop() {
		System.out.println("End test.");
	}
	
	@Test
	@DisplayName("Test nombre Rol.")
	void nombrerol() {
		rol = new Rol();
		rol.setNombreRol("ScrumMaster");
		
	
		String nombreEsperado = "ScrumMaster";
		assertEquals(rol.getNombreRol(),nombreEsperado);
	}
	
	@Test
	@DisplayName("Test Descripcion Rol.")
	void DescripcionRol() {
		rol = new Rol();
		rol.setDescripcion("Rol para el cargo de scrum MAster");	
		
		
		String descEsperado = "Rol para el cargo de scrum MAster";
		assertEquals(rol.getDescripcion(),descEsperado);
	}
}
