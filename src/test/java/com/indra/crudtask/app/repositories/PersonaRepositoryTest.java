package com.indra.crudtask.app.repositories;

import com.indra.crudtask.app.models.Rol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import com.indra.crudtask.app.models.Persona;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
public class PersonaRepositoryTest {

    @Autowired
    public PersonaRepository personaRepository;

    public Persona persona;

    public Rol desarrollador, liderTecnico;

    @BeforeEach
    public void setup() {
        System.out.println("Inicio test PersonaRepository");

        desarrollador = new Rol();
        desarrollador.setId(Long.valueOf(2));
        desarrollador.setNombreRol("DESARROLLADOR");
        desarrollador.setDescripcion("DESARROLLADOR");

        liderTecnico = new Rol();
        liderTecnico.setId(Long.valueOf(2));
        liderTecnico.setNombreRol("LIDER_TECNICO");
        liderTecnico.setDescripcion("LIDER TECNICO");

        persona = new Persona();
        persona.setNombre("Guardian");
        persona.setNumeroIdentificacion("2022");
        persona.setEmail("codex@mail.com");
        persona.setNickName("codex");
        persona.setIdRol(desarrollador);
    }


    @Test
    @DisplayName("Guardar persona")
    void save() {

        Rol rol = new Rol();
        rol.setId(Long.valueOf(1));
        rol.setNombreRol("LIDER_TECNICO");
        rol.setDescripcion("LIDER TECNICO");

        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Luz");
        nuevaPersona.setNumeroIdentificacion("1234");
        nuevaPersona.setEmail("luz@mail.com");
        nuevaPersona.setNickName("luz");
        nuevaPersona.setIdRol(rol);

        Persona personaGuardada = personaRepository.save(nuevaPersona);

        assertThat(personaGuardada).isNotNull();
    }

    @Test
    @DisplayName("Atributos persona")
    void verificar() {
        assertThat(persona.getNombre()).isNotEmpty();
        assertThat(persona.getNombre()).isEqualTo("Guardian");
        assertThat(persona.getEmail()).isNotEmpty();
        assertThat(persona.getEmail()).isEqualTo("codex@mail.com");
        assertThat(persona.getNickName()).isNotEmpty();
        assertThat(persona.getNickName()).isEqualTo("codex");
        assertThat(persona.getNumeroIdentificacion()).isNotEmpty();
        assertThat(persona.getNumeroIdentificacion()).isEqualTo("2022");
        assertThat(persona.getIdRol()).isNotNull();
        assertThat(persona).isNotNull();
    }

}
