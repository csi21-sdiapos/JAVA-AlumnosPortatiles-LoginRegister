package com.AlumnosPortatiles.project.app.repositories.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AlumnosPortatiles.project.app.entities.User;


@Repository(value = "IUserRepository")
public interface IUserRepository extends CrudRepository<User, String>{

	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the user
	 */
	User findByUsername(String username);
	
}