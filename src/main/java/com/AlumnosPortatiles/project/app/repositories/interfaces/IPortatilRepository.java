package com.AlumnosPortatiles.project.app.repositories.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AlumnosPortatiles.project.app.entities.Portatil;


@Repository(value = "IPortatilRepository")
public interface IPortatilRepository extends CrudRepository<Portatil, Long> {

}