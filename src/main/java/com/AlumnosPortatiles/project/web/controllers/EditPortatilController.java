package com.AlumnosPortatiles.project.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.AlumnosPortatiles.project.app.entities.Portatil;
import com.AlumnosPortatiles.project.web.dto.implementations.PortatilToDTOimpl;
import com.AlumnosPortatiles.project.web.dto.interfaces.IPortatilToDTO;
import com.AlumnosPortatiles.project.web.dto.models.PortatilDTO;
import com.AlumnosPortatiles.project.web.services.implementations.PortatilServiceImpl;
import com.AlumnosPortatiles.project.web.services.interfaces.IPortatilService;


@Controller(value = "EditPortatilController")
public class EditPortatilController {

	
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	IPortatilService portatilService = new PortatilServiceImpl();
	
	@Autowired
	IPortatilToDTO portatilToDTO = new PortatilToDTOimpl();
	
	

	@RequestMapping(value="/formEditPortatil", method = RequestMethod.POST)
	public ModelAndView formEditPortatil(HttpServletRequest request) {
		logger.info("\nEntrando en el metodo --> formCreatePortatil()");
	
		long portatil_id = Long.parseLong(request.getParameter("portatil_id"));
		Portatil portatil = portatilService.buscarPortatilPorId(portatil_id);
		
		portatil.setPortatil_marca(request.getParameter("portatil_marca"));
		portatil.setPortatil_modelo(request.getParameter("portatil_modelo"));
		
		portatilService.editarPortatil(portatil.getPortatil_id(), portatil.getPortatil_marca(), portatil.getPortatil_modelo());
		
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
	
/*
	@RequestMapping(value="/formEditPortatil", method = RequestMethod.POST)
	public ModelAndView formEditPortatil(@ModelAttribute("portatilModel") Portatil portatilModel) throws Exception {
		logger.info("\nEntrando en el metodo --> formCreatePortatil()");
		portatilService.editarPortatil(portatilModel.getPortatil_id(), portatilModel.getPortatil_marca(), portatilModel.getPortatil_modelo());
		
		logger.info("\nVolvemos a la vista de los Portatiles");
		List<Portatil> portatilesList = portatilService.listarPortatiles();
		
		logger.info("\nLa lista de portatiles contiene " + portatilesList.size() + " portatiles");
		logger.info(portatilModel);
		System.out.println();
		return new ModelAndView("portatiles", "listaPortatiles", portatilesList);
	}
*/
}