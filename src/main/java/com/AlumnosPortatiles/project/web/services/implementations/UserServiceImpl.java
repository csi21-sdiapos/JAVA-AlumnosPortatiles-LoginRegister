package com.AlumnosPortatiles.project.web.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.AlumnosPortatiles.project.app.entities.Authority;
import com.AlumnosPortatiles.project.app.entities.User;
import com.AlumnosPortatiles.project.app.repositories.interfaces.IAuthorityRepository;
import com.AlumnosPortatiles.project.app.repositories.interfaces.IUserRepository;
import com.AlumnosPortatiles.project.web.services.interfaces.IUserService;


@Service(value = "UserServiceImpl")
public class UserServiceImpl implements IUserService {

	
	@Autowired
    private IUserRepository userRepository;
	
	@Autowired
    private IAuthorityRepository authorityRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	
	@Override
	public void insertarUsuario(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled((short)1);
        userRepository.save(user);
        
        authorityRepository.save(new Authority("ROLE_USER", user));
        authorityRepository.save(new Authority("ROLE_EMPLOYEE", user)); // para testear mejor (el ROLE_USER tan solo se queda en el index)
        // authorityRepository.save(new Authority("ROLE_ADMIN", user));
	}

	
	
	@Override
	public User buscarUsuarioPorNombre(String username) {
		return userRepository.findByUsername(username);
	}

}