package com.AlumnosPortatiles.project.web.services.interfaces;

import java.util.List;

import com.AlumnosPortatiles.project.app.entities.Alumno;


public interface IAlumnoService {

	
	/**
	 * Listar alumnos.
	 *
	 * @return the list
	 */
	public List<Alumno> listarAlumnos();
	
	
	
	/**
	 * Buscar alumno por id.
	 *
	 * @param alumno_id the alumno id
	 * @return the alumno
	 */
	public Alumno buscarAlumnoPorId(long alumno_id);
	
	
	
	/**
	 * Insertar alumno.
	 *
	 * @param alumno the alumno
	 */
	public void insertarAlumno(Alumno alumno);
	
	
	
	/**
	 * Editar alumno.
	 *
	 * @param alumno_id the alumno id
	 * @param alumno_nombre the alumno nombre
	 * @param alumno_apellidos the alumno apellidos
	 * @param alumno_telefono the alumno telefono
	 */
	public void editarAlumno(long alumno_id, String alumno_nombre, String alumno_apellidos, String alumno_telefono);
	
	
	
	/**
	 * Eliminar alumno porid.
	 *
	 * @param alumno_id the alumno id
	 */
	public void eliminarAlumnoPorid(long alumno_id);
	
}