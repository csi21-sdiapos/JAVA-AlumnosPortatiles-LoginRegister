package com.AlumnosPortatiles.project.web.dto.interfaces;

import java.util.List;

import com.AlumnosPortatiles.project.app.entities.Alumno;
import com.AlumnosPortatiles.project.web.dto.models.AlumnoDTO;


public interface IAlumnoToDAO {

	
	/**
	 * To alumno DAO.
	 *
	 * @param alumnoDTO the alumno DTO
	 * @return the alumno
	 */
	public Alumno toAlumnoDAO(AlumnoDTO alumnoDTO);
	
	
	
	/**
	 * To list alumno DAO.
	 *
	 * @param listAlumnoDTO the list alumno DTO
	 * @return the list
	 */
	public List<Alumno> toListAlumnoDAO(List<AlumnoDTO> listAlumnoDTO);
	
}