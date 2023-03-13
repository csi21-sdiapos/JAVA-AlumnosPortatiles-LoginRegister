package com.AlumnosPortatiles.project.app.repositories.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AlumnosPortatiles.project.app.entities.Authority;


@Repository(value = "IAuthorityRepository")
public interface IAuthorityRepository extends CrudRepository<Authority, Long> {

}