package com.indra.crudtask.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.crudtask.app.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

}
