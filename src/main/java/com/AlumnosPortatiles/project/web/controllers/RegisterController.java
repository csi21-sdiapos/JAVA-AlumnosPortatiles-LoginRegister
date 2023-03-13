package com.AlumnosPortatiles.project.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.AlumnosPortatiles.project.app.entities.User;
import com.AlumnosPortatiles.project.app.repositories.interfaces.IUserRepository;
import com.AlumnosPortatiles.project.web.services.implementations.UserServiceImpl;
import com.AlumnosPortatiles.project.web.services.interfaces.IUserService;


@Controller(value = "RegisterController")
public class RegisterController {

	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IUserService userService = new UserServiceImpl();
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("userModel") User userModel, BindingResult bindingResult, @RequestParam String confirmPassword) {
		if (bindingResult.hasErrors())
	        return "/navigateToRegister";
	    
		if (userRepository.findByUsername(userModel.getUsername()) != null)
	        return "redirect:/navigateToRegister?username_already_exists";
	    
		if (userModel.getPassword().equals(confirmPassword)) 
	        userService.insertarUsuario(userModel);
		else
	        return "redirect:/navigateToRegister?passwords_not_match";
	    
	    return "redirect:/navigateToLogin?registered";
	}

}