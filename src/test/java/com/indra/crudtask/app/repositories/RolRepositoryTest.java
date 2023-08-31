package com.indra.crudtask.app.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.indra.crudtask.app.models.Celula;
import com.indra.crudtask.app.models.Rol;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
class RolRepositoryTest {

	@Autowired (required = true)
	public RolRepository rolRepository;
	
	public Rol rol;
	@BeforeEach
	public void setup() {
		System.out.println("Inicio antes");
		rol = new Rol();
		rol.setNombreRol("ScrumMaster");
		rol.setDescripcion("Rol para el cargo de scrum MAster");	
		
	}

	@Test
	@DisplayName("Test para guardar un nuevo Rol.")
	void saveCelula() {
		Rol newRol = new Rol();
		newRol.setNombreRol("ScrumMaster");
		newRol.setDescripcion("Rol para el cargo de scrum MAster");
		
		
		Rol RolSave = rolRepository.save(newRol);
		
		assertThat(RolSave).isNotNull();
	}
	
	@Test
	@DisplayName("Test Buscar Roles")
	void listarRoles() {
		Rol newRol2 = new Rol();
		newRol2.setNombreRol("ScrumMaster");
		newRol2.setDescripcion("Rol para el cargo de scrum Master");
		
		rolRepository.save(newRol2);
		rolRepository.save(rol);
		
		List<Rol> Listrol = rolRepository.findAll();
		assertThat(Listrol).isNotNull().hasSize(2);
		
	}
	
	@Test
	@DisplayName("Test para eliminar Roles")
	void eliminarRol() {
		
		rolRepository.save(rol);
		
		List<Rol> listrol = rolRepository.findAll();

        List<Rol> rolL = listrol.stream()               
                .filter(nombreRol -> "ScrumMaster".equals(this.rol.getNombreRol()))     
                .collect(Collectors.toList());    
        rolRepository.deleteById(rolL.get(0).getId());
        
		assertThat(rolRepository.findById(rolL.get(0).getId())).isEmpty();
	
	}
}
