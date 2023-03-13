package com.AlumnosPortatiles.project.web.dto.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.AlumnosPortatiles.project.app.entities.Portatil;
import com.AlumnosPortatiles.project.web.dto.interfaces.IPortatilToDTO;
import com.AlumnosPortatiles.project.web.dto.models.PortatilDTO;


@Service(value = "PortatilToDTOimpl")
public class PortatilToDTOimpl implements IPortatilToDTO {

	
	@Override
	public PortatilDTO toPortatilDTO(Portatil portatilDAO) {
		PortatilDTO portatilDTO = new PortatilDTO();
		
		try {
			portatilDTO.setPortatil_uuid(portatilDAO.getPortatil_uuid());
			portatilDTO.setPortatil_date(portatilDAO.getPortatil_date());
			portatilDTO.setPortatil_id(portatilDAO.getPortatil_id());
			portatilDTO.setPortatil_marca(portatilDAO.getPortatil_marca());
			portatilDTO.setPortatil_modelo(portatilDAO.getPortatil_modelo());
			portatilDTO.setAlumno(portatilDAO.getAlumno());
			return portatilDTO;
			
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al convertir el portatilDAO a portatilDTO (return null): " + e);
			return null;
		}
	}

	
	
	@Override
	public List<PortatilDTO> toListPortatilDTO(List<Portatil> listPortatilDAO) {
		List<PortatilDTO> listPortatilDTO = new ArrayList<>();
		
		try {
			for (Portatil portatilDAO : listPortatilDAO) {
				listPortatilDTO.add(toPortatilDTO(portatilDAO));
			}
			return listPortatilDTO;
			
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al convertir la listAlumnoDAO a listAlumnoDTO (return null): " + e);
			return null;
		}
	}

}