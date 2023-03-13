package com.AlumnosPortatiles.project.web.dto.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.AlumnosPortatiles.project.app.entities.Portatil;
import com.AlumnosPortatiles.project.web.dto.interfaces.IPortatilToDAO;
import com.AlumnosPortatiles.project.web.dto.models.PortatilDTO;


@Service(value = "PortatilToDAOimpl")
public class PortatilToDAOimpl implements IPortatilToDAO {

	
	@Override
	public Portatil toPortatilDAO(PortatilDTO portatilDTO) {
		Portatil portatilDAO = new Portatil();
		
		try {
			portatilDAO.setPortatil_uuid(portatilDTO.getPortatil_uuid());
			portatilDAO.setPortatil_date(portatilDTO.getPortatil_date());
			portatilDAO.setPortatil_id(portatilDTO.getPortatil_id());
			portatilDAO.setPortatil_marca(portatilDTO.getPortatil_marca());
			portatilDAO.setPortatil_modelo(portatilDTO.getPortatil_modelo());
			portatilDAO.setAlumno(portatilDTO.getAlumno());
			return portatilDAO;
			
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al convertir el portatilDTO a portatilDAO (return null): " + e);
			return null;
		}
	}

	
	
	@Override
	public List<Portatil> toListPortatilDAO(List<PortatilDTO> listPortatilDTO) {
		List<Portatil> listPortatilDAO = new ArrayList<>();
		
		try {
			for (PortatilDTO portatilDTO : listPortatilDTO) {
				listPortatilDAO.add(toPortatilDAO(portatilDTO));
			}
			return listPortatilDAO;
		
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al convertir la listAlumnoDTO a listAlumnoDAO (return null): " + e);
			return null;
		}
	}

}