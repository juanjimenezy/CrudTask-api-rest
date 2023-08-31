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

public class RolTest {

	Rol rol;

	@BeforeEach
	void initMetodoTest() {
		this.rol = new Rol();
		this.rol.setDescripcion("Rol scrum master");
		this.rol.setNombreRol("ScrumMaster");
		this.rol.setId(Long.valueOf("1"));
		
	}


	@Test
	@DisplayName("validando El rol de la persona")
	void testNombreRol() {
		String nombrerol = "ScrumMaster";
		assertAll(() -> {
			assertTrue(this.rol.getNombreRol().equals(nombrerol), "El rol es incorrecto");
		}, () -> {
			assertNotNull(this.rol.getNombreRol(), "El rol es null");
		}, () -> {
			assertFalse(this.rol.getNombreRol().length()< 5, "El nombre del rol debe contener mas 5 caracteres");
		});
	}


	@Test
	@DisplayName("validando La descripcion del rol")
	void testDescripcionRol() {
		String descripcion = "Rol scrum master";
		assertAll(() -> {
			assertTrue(this.rol.getDescripcion().equals(descripcion), "La descripcion es incorrecta");
		}, () -> {
			assertNotNull(this.rol.getNombreRol(), "La descripcion es null");
		}, () -> {
			assertFalse(this.rol.getNombreRol().length()< 10, "La descripcion del rol debe contener mas 10 caracteres");
		});
	}

	
	@Test
	@DisplayName("validando ID del rol")
	void testIdRol() {
		Long idRol = Long.valueOf("1");
		assertAll(() -> {
			assertTrue(this.rol.getId().equals(idRol), "El rol Id es incorrecta");
		}, () -> {
			assertNotNull(this.rol.getId(), "El Id rol es null");
		});
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("Finalizando  prueba.");
	}

	@BeforeAll
	static void beforeAll() {
		System.out.println("Inicializando  test");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("Finalizando test");
	}

}
