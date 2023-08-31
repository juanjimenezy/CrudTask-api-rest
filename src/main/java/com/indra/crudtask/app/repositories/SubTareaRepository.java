package com.indra.crudtask.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.crudtask.app.models.SubTarea;

@Repository
public interface SubTareaRepository extends JpaRepository<SubTarea,Long>{

}
