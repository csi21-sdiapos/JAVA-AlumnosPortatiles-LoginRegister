package com.AlumnosPortatiles.project.web.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.AlumnosPortatiles.project.app.entities.Portatil;
import com.AlumnosPortatiles.project.web.dto.implementations.PortatilToDAOimpl;
import com.AlumnosPortatiles.project.web.dto.implementations.PortatilToDTOimpl;
import com.AlumnosPortatiles.project.web.dto.interfaces.IPortatilToDAO;
import com.AlumnosPortatiles.project.web.dto.interfaces.IPortatilToDTO;
import com.AlumnosPortatiles.project.web.dto.models.PortatilDTO;
import com.AlumnosPortatiles.project.web.services.implementations.PortatilServiceImpl;
import com.AlumnosPortatiles.project.web.services.interfaces.IPortatilService;


@Controller(value = "CreateFormPortatilController")
public class CreateFormPortatilController {
	
	
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	IPortatilService portatilService = new PortatilServiceImpl();
	
	@Autowired
	IPortatilToDAO portatilToDAO = new PortatilToDAOimpl();
	
	@Autowired
	IPortatilToDTO portatilToDTO = new PortatilToDTOimpl();
	
	
	
	@RequestMapping(value="/formCreatePortatil", method = RequestMethod.POST)
	public ModelAndView formCreatePortatil(@ModelAttribute("portatilModel") PortatilDTO portatilModel) {
		logger.info("\nEntrando en el metodo --> formCreatePortatil()");
		
		portatilModel.setPortatil_uuid(UUID.randomUUID());
		portatilModel.setPortatil_date(Calendar.getInstance());
		try {
			portatilService.insertarPortatil(portatilToDAO.toPortatilDAO(portatilModel));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("\nVolvemos a la vista de los Portatiles");
		List<Portatil> portatilesList = portatilService.listarPortatiles();
		logger.info("\nLa lista de portatiles contiene " + portatilesList.size() + " portatiles");
		List<PortatilDTO> portatilesListDTO = new ArrayList<>();
		try {
			portatilesListDTO = portatilToDTO.toListPortatilDTO(portatilesList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("portatiles", "listaPortatiles", portatilesListDTO);
	}
	
}