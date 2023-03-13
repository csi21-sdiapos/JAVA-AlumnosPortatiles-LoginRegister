package com.AlumnosPortatiles.project.web.services.interfaces;

import com.AlumnosPortatiles.project.app.entities.User;


public interface IUserService {

	
	/**
	 * Insertar usuario.
	 *
	 * @param user the user
	 */
	void insertarUsuario(User user);

	
	
    /**
     * Buscar usuario por nombre.
     *
     * @param username the username
     * @return the user
     */
    User buscarUsuarioPorNombre(String username);
    
}