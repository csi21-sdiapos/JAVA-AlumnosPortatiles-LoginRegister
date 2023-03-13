package com.AlumnosPortatiles.project.web.dto.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.AlumnosPortatiles.project.app.entities.Alumno;
import com.AlumnosPortatiles.project.web.dto.interfaces.IAlumnoToDAO;
import com.AlumnosPortatiles.project.web.dto.models.AlumnoDTO;


@Service(value = "AlumnoToDAOimpl")
public class AlumnoToDAOimpl implements IAlumnoToDAO {

	
	@Override
	public Alumno toAlumnoDAO(AlumnoDTO alumnoDTO) {
		Alumno alumnoDAO = new Alumno();
		
		try {
			alumnoDAO.setAlumno_uuid(alumnoDTO.getAlumno_uuid());
			alumnoDAO.setAlumno_date(alumnoDTO.getAlumno_date());
			alumnoDAO.setAlumno_id(alumnoDTO.getAlumno_id());
			alumnoDAO.setAlumno_nombre(alumnoDTO.getAlumno_nombre());
			alumnoDAO.setAlumno_apellidos(alumnoDTO.getAlumno_apellidos());
			alumnoDAO.setAlumno_telefono(alumnoDTO.getAlumno_telefono());
			alumnoDAO.setPortatil(alumnoDTO.getPortatil());
			return alumnoDAO;
			
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al convertir el alumnoDTO a alumnoDAO (return null): " + e);
			return null;
		}
	}

	
	
	@Override
	public List<Alumno> toListAlumnoDAO(List<AlumnoDTO> listAlumnoDTO) {
		List<Alumno> listAlumnoDAO = new ArrayList<>();
		
		try {
			for (AlumnoDTO alumnoDTO : listAlumnoDTO) {
				listAlumnoDAO.add(toAlumnoDAO(alumnoDTO));
			}
			return listAlumnoDAO;
			
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al convertir la listAlumnoDTO a listAlumnoDAO (return null): " + e);
			return null;
		}
	}

}