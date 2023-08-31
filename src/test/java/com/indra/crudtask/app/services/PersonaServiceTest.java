package com.indra.crudtask.app.services;

import com.indra.crudtask.app.models.Persona;
import com.indra.crudtask.app.models.Rol;
import org.assertj.core.api.StringAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonaServiceTest {

    public Persona persona;

    public Rol desarrollador, liderTecnico;

    @BeforeEach
    public void setup() {
        System.out.println("Inicio test");

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
    @DisplayName("regex correo")
    void regexCorreo() {
        assertThat(persona.getEmail().matches("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$"));
    }

    @Test
    @DisplayName("tipos de datos")
    void tipoDatos() {
        assertEquals(String.class, persona.getNombre().getClass());
        assertEquals(String.class, persona.getNumeroIdentificacion().getClass());
        assertEquals(String.class, persona.getEmail().getClass());
        assertEquals(String.class, persona.getNickName().getClass());
        assertEquals(Rol.class, persona.getIdRol().getClass());
    }
}
