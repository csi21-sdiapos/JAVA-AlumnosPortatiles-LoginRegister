package com.AlumnosPortatiles.project.web.dto.interfaces;

import java.util.List;

import com.AlumnosPortatiles.project.app.entities.Alumno;
import com.AlumnosPortatiles.project.web.dto.models.AlumnoDTO;


public interface IAlumnoToDTO {

	
	/**
	 * To alumno DTO.
	 *
	 * @param AlumnoDAO the alumno DAO
	 * @return the alumno DTO
	 */
	public AlumnoDTO toAlumnoDTO(Alumno AlumnoDAO);
	
	
	
	/**
	 * To list alumno DTO.
	 *
	 * @param listAlumnoDAO the list alumno DAO
	 * @return the list
	 */
	public List<AlumnoDTO> toListAlumnoDTO(List<Alumno> listAlumnoDAO);
	
}