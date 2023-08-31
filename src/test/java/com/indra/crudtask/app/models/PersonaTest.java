package com.indra.crudtask.app.models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PersonaTest {

    public Persona persona;

    public Rol desarrollador, liderTecnico;

    @BeforeEach
    public void setup() {
        System.out.println("Inicio test Persona");

        desarrollador = new Rol(Long.valueOf(2), "DESARROLLADOR", "DESARROLLADOR");

        liderTecnico = new Rol(Long.valueOf(2), "LIDER_TECNICO", "LIDER TECNICO");

        persona = new Persona();
        persona.setNombre("Guardian");
        persona.setNumeroIdentificacion("2022");
        persona.setEmail("codex@mail.com");
        persona.setNickName("codex");
        persona.setIdRol(desarrollador);
    }

    @Test
    @DisplayName("Nombre persona")
    void testNombrePersona() {
        String nombrePersona = "Guardian";
        assertEquals(nombrePersona, persona.getNombre());
        assertNotNull(persona.getNombre());
    }

    @Test
    @DisplayName("Numero identificacion persona")
    void testNumeroIdentificacion() {
        String numeroIdentificacion = "2022";
        assertEquals(numeroIdentificacion, persona.getNumeroIdentificacion());
        assertNotNull(persona.getNumeroIdentificacion());
    }

    @Test
    @DisplayName("Atributos Persona")
    void validar() {
        assertEquals("codex@mail.com", persona.getEmail());
        assertNotNull(persona.getEmail());
        assertEquals("codex", persona.getNickName());
        assertNotNull(persona.getNickName());
        assertEquals("DESARROLLADOR", persona.getIdRol().getNombreRol());
        assertEquals("DESARROLLADOR", persona.getIdRol().getDescripcion());
        assertEquals(Long.valueOf(2), persona.getIdRol().getId());
        assertNotNull(persona.getIdRol());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando  prueba");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando  test Persona");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando test Persona");
    }

}
