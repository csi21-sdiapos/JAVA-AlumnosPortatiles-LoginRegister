package com.AlumnosPortatiles.project.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.AlumnosPortatiles.project.app.entities.Alumno;
import com.AlumnosPortatiles.project.app.entities.Portatil;
import com.AlumnosPortatiles.project.web.dto.implementations.AlumnoToDTOimpl;
import com.AlumnosPortatiles.project.web.dto.implementations.PortatilToDTOimpl;
import com.AlumnosPortatiles.project.web.dto.interfaces.IAlumnoToDTO;
import com.AlumnosPortatiles.project.web.dto.interfaces.IPortatilToDTO;
import com.AlumnosPortatiles.project.web.dto.models.PortatilDTO;
import com.AlumnosPortatiles.project.web.services.implementations.PortatilServiceImpl;
import com.AlumnosPortatiles.project.web.services.interfaces.IPortatilService;


@Controller(value = "PortatilesController")
@RequestMapping(value = { "", "portatil" })
public class PortatilesController {

	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	IPortatilService portatilService = new PortatilServiceImpl();
	
	@Autowired
	IAlumnoToDTO alumnoToDTO = new AlumnoToDTOimpl();
	
	@Autowired
	IPortatilToDTO portatilToDTO = new PortatilToDTOimpl();

	
	
	@RequestMapping(value = "/navigateToCreateFormPortatil")
	public ModelAndView navigateToCreateFormPortatil() {
		logger.info("\nNavegamos a la vista del formulario de registro de portatiles, pasando un objeto Portatil");
		PortatilDTO portatilDTO = new PortatilDTO();
		
		return new ModelAndView("createFormPortatil", "portatilModel", portatilDTO);
	}
	
	

	@RequestMapping(value = "/findAlumnoByPortatilId")
	public String findAlumnoByPortatilId(@RequestParam long portatil_id, Model model) {
		logger.info("\nVamos a buscar un alumno a través del id de un portatil");
		
		Portatil portatil = portatilService.buscarPortatilPorId(portatil_id);
		try {
			model.addAttribute("portatilModel", portatilToDTO.toPortatilDTO(portatil));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alumno alumno = portatil.getAlumno();
		try {
			model.addAttribute("alumnoModel", alumnoToDTO.toAlumnoDTO(alumno));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Portatil> portatilesList = portatilService.listarPortatiles();
		logger.info("\nLa lista de portatiles contiene " + portatilesList.size() + " portatiles");
		List<PortatilDTO> portatilesListDTO = new ArrayList<>();
		try {
			portatilesListDTO = portatilToDTO.toListPortatilDTO(portatilesList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("listaPortatiles", portatilesListDTO);
		
		return "portatiles";
	}

	
	
	@RequestMapping(value = "/editPortatil")
	public ModelAndView editPortatil(HttpServletRequest request) {
		logger.info("\nEntrando en el metodo --> editPortatil()");
		
		long id = Long.parseLong(request.getParameter("id"));
		Portatil portatil = portatilService.buscarPortatilPorId(id);
		portatil.setPortatil_marca(request.getParameter("marca").trim());
		portatil.setPortatil_modelo(request.getParameter("modelo").trim());
		portatilService.editarPortatil(portatil.getPortatil_id(), portatil.getPortatil_marca(), portatil.getPortatil_modelo());
		
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



	
	@RequestMapping(value = "/deletePortatil")
	public ModelAndView deletePortatil(HttpServletRequest request) {
		logger.info("\nEntrando en el metodo --> deletePortatil()");
		
		long id = Long.parseLong(request.getParameter("id"));
		portatilService.eliminarPortatilPorId(id);
		
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