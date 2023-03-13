package com.AlumnosPortatiles.project.app.repositories.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AlumnosPortatiles.project.app.entities.Alumno;


@Repository(value = "IAlumnoRepository")
public interface IAlumnoRepository extends CrudRepository<Alumno, Long> {
	
}