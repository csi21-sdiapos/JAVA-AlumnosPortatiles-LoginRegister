package com.AlumnosPortatiles.project.web.dto.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.AlumnosPortatiles.project.app.entities.Alumno;
import com.AlumnosPortatiles.project.web.dto.interfaces.IAlumnoToDTO;
import com.AlumnosPortatiles.project.web.dto.models.AlumnoDTO;


@Service(value = "AlumnoToDTOimpl")
public class AlumnoToDTOimpl implements IAlumnoToDTO {

	
	@Override
	public AlumnoDTO toAlumnoDTO(Alumno AlumnoDAO) {
		AlumnoDTO alumnoDTO = new AlumnoDTO();
		
		try {
			alumnoDTO.setAlumno_uuid(AlumnoDAO.getAlumno_uuid());
			alumnoDTO.setAlumno_date(AlumnoDAO.getAlumno_date());
			alumnoDTO.setAlumno_id(AlumnoDAO.getAlumno_id());
			alumnoDTO.setAlumno_nombre(AlumnoDAO.getAlumno_nombre());
			alumnoDTO.setAlumno_apellidos(AlumnoDAO.getAlumno_apellidos());
			alumnoDTO.setAlumno_telefono(AlumnoDAO.getAlumno_telefono());
			alumnoDTO.setPortatil(AlumnoDAO.getPortatil());
			return alumnoDTO;
			
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al convertir el alumnoDAO a alumnoDTO (return null): " + e);
			return null;
		}
	}

	
	
	@Override
	public List<AlumnoDTO> toListAlumnoDTO(List<Alumno> listAlumnoDAO) {
		List<AlumnoDTO> listAlumnoDTO = new ArrayList<>();
		
		try {
			for (Alumno alumnoDAO : listAlumnoDAO) {
				listAlumnoDTO.add(toAlumnoDTO(alumnoDAO));
			}
			return listAlumnoDTO;
			
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al convertir la listAlumnoDAO a listAlumnoDTO (return null): " + e);
			return null;
		}
	}

}