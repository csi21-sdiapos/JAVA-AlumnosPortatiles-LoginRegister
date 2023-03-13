package com.AlumnosPortatiles.project.web.dto.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.AlumnosPortatiles.project.app.entities.Portatil;


@Component(value = "AlumnoDTO")
public class AlumnoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/******************************************* ATRIBUTOS *********************************************/
	private UUID alumno_uuid;
	private Calendar alumno_date;
	private long alumno_id;
	private String alumno_nombre;
	private String alumno_apellidos;
	private String alumno_telefono;
	private long portatil_id;	// este campo extra será para obtener de la vista el número de portatil_id que introduzca el usuario para buscar y asignar un portatil en la creación de un alumno
	
	/******************************************* RELACIONES *********************************************/
	private Portatil portatil;
	
	
	/******************************************* CONSTRUCTORES *********************************************/
	// constructor lleno
	public AlumnoDTO(UUID alumno_uuid, Calendar alumno_date, String alumno_nombre, String alumno_apellidos, String alumno_telefono, Portatil portatil) {
		super();
		this.alumno_uuid = alumno_uuid;
		this.alumno_date = alumno_date;
		this.alumno_nombre = alumno_nombre;
		this.alumno_apellidos = alumno_apellidos;
		this.alumno_telefono = alumno_telefono;
		// this.portatil_id
		this.portatil = portatil;
	}

	// constructor vacío
	public AlumnoDTO() {
		super();
	}
	
	
	/******************************************* GETTER Y SETTERS *********************************************/
	public UUID getAlumno_uuid() {
		return alumno_uuid;
	}

	public void setAlumno_uuid(UUID alumno_uuid) {
		this.alumno_uuid = alumno_uuid;
	}
	
	public Calendar getAlumno_date() {
		return alumno_date;
	}

	public void setAlumno_date(Calendar alumno_date) {
		this.alumno_date = alumno_date;
	}

	public long getAlumno_id() {
		return alumno_id;
	}

	public void setAlumno_id(long alumno_id) {
		this.alumno_id = alumno_id;
	}

	public String getAlumno_nombre() {
		return alumno_nombre;
	}

	public void setAlumno_nombre(String alumno_nombre) {
		this.alumno_nombre = alumno_nombre;
	}

	public String getAlumno_apellidos() {
		return alumno_apellidos;
	}

	public void setAlumno_apellidos(String alumno_apellidos) {
		this.alumno_apellidos = alumno_apellidos;
	}

	public String getAlumno_telefono() {
		return alumno_telefono;
	}

	public void setAlumno_telefono(String alumno_telefono) {
		this.alumno_telefono = alumno_telefono;
	}

	public long getPortatil_id() {
		return portatil_id;
	}

	public void setPortatil_id(long portatil_id) {
		this.portatil_id = portatil_id;
	}

	public Portatil getPortatil() {
		return portatil;
	}

	public void setPortatil(Portatil portatil) {
		this.portatil = portatil;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	/******************************************* MÉTODOS *********************************************/


	/******************************************* HashCode y Equals *********************************************/
	@Override
	public int hashCode() {
		return Objects.hash(alumno_apellidos, alumno_date, alumno_id, alumno_nombre, alumno_telefono, alumno_uuid,
				portatil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlumnoDTO other = (AlumnoDTO) obj;
		return Objects.equals(alumno_apellidos, other.alumno_apellidos)
				&& Objects.equals(alumno_date, other.alumno_date) && alumno_id == other.alumno_id
				&& Objects.equals(alumno_nombre, other.alumno_nombre)
				&& Objects.equals(alumno_telefono, other.alumno_telefono)
				&& Objects.equals(alumno_uuid, other.alumno_uuid) && Objects.equals(portatil, other.portatil);
	}
	
	
	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		return "\nAlumnoDTO [" + 
					"alumno_uuid=" + alumno_uuid +
					", alumno_date=" + alumno_date.getTime() +
					", alumno_id=" + alumno_id + 
					", alumno_nombre=" + alumno_nombre + 
					", alumno_apellidos=" + alumno_apellidos + 
					", alumno_telefono=" + alumno_telefono + 
					", portatil=" + portatil + 
				"]";
	}
	
}