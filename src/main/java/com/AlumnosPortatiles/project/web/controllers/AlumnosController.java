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
import com.AlumnosPortatiles.project.web.dto.models.AlumnoDTO;
import com.AlumnosPortatiles.project.web.dto.models.PortatilDTO;
import com.AlumnosPortatiles.project.web.services.implementations.AlumnoServiceImpl;
import com.AlumnosPortatiles.project.web.services.implementations.PortatilServiceImpl;
import com.AlumnosPortatiles.project.web.services.interfaces.IAlumnoService;
import com.AlumnosPortatiles.project.web.services.interfaces.IPortatilService;


@Controller(value = "AlumnosController")
@RequestMapping(value = { "", "alumno" })
public class AlumnosController {
	

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	IAlumnoService alumnoService = new AlumnoServiceImpl();
	
	@Autowired
	IPortatilService portatilService = new PortatilServiceImpl();
	
	@Autowired
	IAlumnoToDTO alumnoToDTO = new AlumnoToDTOimpl();
	
	@Autowired
	IPortatilToDTO portatilToDTO = new PortatilToDTOimpl();
	

	
	@RequestMapping(value = "/navigateToCreateFormAlumno")
	public String navigateToCreateFormAlumno(Model model) {
		logger.info("\nNavegamos a la vista del formulario de registro de alumnos, pasando un objeto Alumno");
		
		AlumnoDTO alumnoDTO = new AlumnoDTO();
		model.addAttribute("alumnoModel", alumnoDTO);
		
		List<Portatil> portatilesList = portatilService.listarPortatiles();
		logger.info("\nLa lista de portatiles contiene " + portatilesList.size() + " portatiles");
		List<PortatilDTO> portatilesListDTO = new ArrayList<>();
		try {
			portatilesListDTO = portatilToDTO.toListPortatilDTO(portatilesList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("listaPortatiles" ,portatilesListDTO);

		return "createFormAlumno";
	}
	
	

	@RequestMapping(value = "/findPortatilByAlumnoId")
	public String findPortatilByAlumnoId(@RequestParam long alumno_id, Model model) {
		logger.info("\nVamos a buscar un portatil a través del id de un alumno");
		
		Alumno alumno = alumnoService.buscarAlumnoPorId(alumno_id);
		try {
			model.addAttribute("alumnoModel", alumnoToDTO.toAlumnoDTO(alumno));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Portatil portatil = alumno.getPortatil();
		try {
			model.addAttribute("portatilModel", portatilToDTO.toPortatilDTO(portatil));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Alumno> alumnosList = alumnoService.listarAlumnos();
		logger.info("\nLa lista de alumnos contiene " + alumnosList.size() + " alumnos");
		List<AlumnoDTO> alumnosListDTO = new ArrayList<>();
		try {
			alumnosListDTO = alumnoToDTO.toListAlumnoDTO(alumnosList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("listaAlumnos", alumnosListDTO);
		
		return "alumnos";
	}



	@RequestMapping(value = "/navigateToEditFormAlumno")
	public ModelAndView navigateToEditFormAlumno(@RequestParam long alumno_id) {
		logger.info("\nNavegamos a la vista del formulario de edicion de alumnos, pasando un objeto Alumno");
		Alumno alumno = alumnoService.buscarAlumnoPorId(alumno_id);
		
		return new ModelAndView("editFormAlumno", "alumnoModel", alumno);
	}

	

	@RequestMapping(value = "/deleteAlumno")
	public ModelAndView deleteAlumno(HttpServletRequest request) {
		logger.info("\nEntrando en el metodo --> deleteAlumno()");

		long id = Long.parseLong(request.getParameter("id"));
		alumnoService.eliminarAlumnoPorid(id);
		
		List<Alumno> alumnosList = alumnoService.listarAlumnos();
		logger.info("\nLa lista de alumnos contiene " + alumnosList.size() + " alumnos");
		List<AlumnoDTO> alumnosListDTO = new ArrayList<>();
		try {
			alumnosListDTO = alumnoToDTO.toListAlumnoDTO(alumnosList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("alumnos", "listaAlumnos", alumnosListDTO);
	}

}