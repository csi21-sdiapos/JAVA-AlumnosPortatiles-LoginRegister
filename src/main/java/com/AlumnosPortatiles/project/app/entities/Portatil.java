package com.AlumnosPortatiles.project.app.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "Portatil")
@Table(name = "portatil", schema = "alumnos_portatiles")
public class Portatil implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	/******************************************* ATRIBUTOS *********************************************/
	@Column(table = "portatil", name = "portatil_uuid", insertable = true, updatable = true, unique = false, nullable = false)
	private UUID portatil_uuid;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(table = "portatil", name = "portatil_date", insertable = true, updatable = true, unique = false, nullable = false)
	private Calendar portatil_date;
	
	@Id
	@Column(table = "portatil", name = "portatil_id", insertable = false, updatable = false, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long portatil_id;
	
	@Column(table = "portatil", name = "portatil_marca", insertable = true, updatable = true, unique = false, nullable = false)
	private String portatil_marca;
	
	@Column(table = "portatil", name = "portatil_modelo", insertable = true, updatable = true, unique = false, nullable = false)
	private String portatil_modelo;
	
	/******************************************* RELACIONES *********************************************/
	@OneToOne(mappedBy = "portatil", targetEntity = Alumno.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = false, optional = true)
	private Alumno alumno;
	
	
	/******************************************* CONSTRUCTORES *********************************************/
	// constructor lleno
	public Portatil(String portatil_marca, String portatil_modelo) {
		super();
		this.portatil_uuid = UUID.randomUUID();
		this.portatil_date = Calendar.getInstance();
		this.portatil_marca = portatil_marca;
		this.portatil_modelo = portatil_modelo;
		// this.alumno = null;
	}

	// constructor vacío
	public Portatil() {
		super();
	}
	
	
	/******************************************* GETTER Y SETTERS *********************************************/
	public UUID getPortatil_uuid() {
		return portatil_uuid;
	}

	public void setPortatil_uuid(UUID portatil_uuid) {
		this.portatil_uuid = portatil_uuid;
	}

	public long getPortatil_id() {
		return portatil_id;
	}

	public void setPortatil_id(long portatil_id) {
		this.portatil_id = portatil_id;
	}

	public Calendar getPortatil_date() {
		return portatil_date;
	}

	public void setPortatil_date(Calendar portatil_date) {
		this.portatil_date = portatil_date;
	}

	public String getPortatil_marca() {
		return portatil_marca;
	}

	public void setPortatil_marca(String portatil_marca) {
		this.portatil_marca = portatil_marca;
	}

	public String getPortatil_modelo() {
		return portatil_modelo;
	}

	public void setPortatil_modelo(String portatil_modelo) {
		this.portatil_modelo = portatil_modelo;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	/******************************************* MÉTODOS *********************************************/

	
	/******************************************* HashCode y Equals *********************************************/
	@Override
	public int hashCode() {
		return Objects.hash(alumno, portatil_date, portatil_id, portatil_marca, portatil_modelo, portatil_uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Portatil other = (Portatil) obj;
		return Objects.equals(alumno, other.alumno) && Objects.equals(portatil_date, other.portatil_date)
				&& portatil_id == other.portatil_id && Objects.equals(portatil_marca, other.portatil_marca)
				&& Objects.equals(portatil_modelo, other.portatil_modelo)
				&& Objects.equals(portatil_uuid, other.portatil_uuid);
	}
	
	
	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		if (alumno != null) {
			return "\nPortatil [" + 
					"portatil_uuid=" + portatil_uuid + 
					", portatil_id=" + portatil_id + 
					", portatil_date=" + portatil_date.getTime() + 
					", portatil_marca=" + portatil_marca + 
					", portatil_modelo=" + portatil_modelo + 
					", \nalumno_id=" + alumno.getAlumno_id() +
				"]";
		}
		else {
			return "\nPortatil [" + 
					"portatil_uuid=" + portatil_uuid + 
					", portatil_id=" + portatil_id + 
					", portatil_date=" + portatil_date.getTime() + 
					", portatil_marca=" + portatil_marca + 
					", portatil_modelo=" + portatil_modelo + 
					", \nalumno_id=sin asignar" +
				"]";
		}
	}
	
}