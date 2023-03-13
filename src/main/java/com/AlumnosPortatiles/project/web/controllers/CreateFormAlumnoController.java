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

import com.AlumnosPortatiles.project.app.entities.Alumno;
import com.AlumnosPortatiles.project.app.entities.Portatil;
import com.AlumnosPortatiles.project.web.dto.implementations.AlumnoToDAOimpl;
import com.AlumnosPortatiles.project.web.dto.implementations.AlumnoToDTOimpl;
import com.AlumnosPortatiles.project.web.dto.interfaces.IAlumnoToDAO;
import com.AlumnosPortatiles.project.web.dto.interfaces.IAlumnoToDTO;
import com.AlumnosPortatiles.project.web.dto.models.AlumnoDTO;
import com.AlumnosPortatiles.project.web.services.implementations.AlumnoServiceImpl;
import com.AlumnosPortatiles.project.web.services.implementations.PortatilServiceImpl;
import com.AlumnosPortatiles.project.web.services.interfaces.IAlumnoService;
import com.AlumnosPortatiles.project.web.services.interfaces.IPortatilService;


@Controller(value = "CreateFormAlumnoController")
public class CreateFormAlumnoController {

	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	IAlumnoService alumnoService = new AlumnoServiceImpl();
	
	@Autowired
	IPortatilService portatilService = new PortatilServiceImpl();
	
	@Autowired
	IAlumnoToDAO alumnoToDAO = new AlumnoToDAOimpl();
	
	@Autowired
	IAlumnoToDTO alumnoToDTO = new AlumnoToDTOimpl();
	

	
	@RequestMapping(value="/formCreateAlumno", method = RequestMethod.POST)
	public ModelAndView formCreateAlumno(@ModelAttribute("alumnoModel") AlumnoDTO alumnoModel) {
		logger.info("\nEntrando en el metodo --> formCreateAlumno()");
		Portatil portatil = portatilService.buscarPortatilPorId(alumnoModel.getPortatil_id());
		
		alumnoModel.setAlumno_uuid(UUID.randomUUID());
		alumnoModel.setAlumno_date(Calendar.getInstance());
		alumnoModel.setPortatil(portatil);
		try {
			alumnoService.insertarAlumno(alumnoToDAO.toAlumnoDAO(alumnoModel));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("\nVolvemos a la vista de los Alumnos");
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