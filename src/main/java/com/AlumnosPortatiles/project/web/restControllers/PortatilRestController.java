package com.AlumnosPortatiles.project.web.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AlumnosPortatiles.project.app.entities.Portatil;
import com.AlumnosPortatiles.project.web.services.implementations.PortatilServiceImpl;
import com.AlumnosPortatiles.project.web.services.interfaces.IPortatilService;

// esta clase ha sido un intento de implementar la acción de editar con modal y ajax
@RestController(value = "PortatilRestController")
@RequestMapping(value = "api/portatil")
public class PortatilRestController {

	
	@Autowired
	IPortatilService portatilService = new PortatilServiceImpl();
	
	
	
	@RequestMapping(value = "findPortatilById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Portatil> findPortatilById(@PathVariable("id") long id) {
		try {
			return new ResponseEntity<Portatil>(portatilService.buscarPortatilPorId(id), HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<Portatil>(HttpStatus.BAD_REQUEST);
		}
	}

}