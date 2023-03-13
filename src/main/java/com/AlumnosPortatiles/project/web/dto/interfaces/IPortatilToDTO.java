package com.AlumnosPortatiles.project.web.dto.interfaces;

import java.util.List;

import com.AlumnosPortatiles.project.app.entities.Portatil;
import com.AlumnosPortatiles.project.web.dto.models.PortatilDTO;


public interface IPortatilToDTO {

	
	/**
	 * To portatil DTO.
	 *
	 * @param portatilDAO the portatil DAO
	 * @return the portatil DTO
	 */
	public PortatilDTO toPortatilDTO(Portatil portatilDAO);
	
	
	
	/**
	 * To list portatil DTO.
	 *
	 * @param listPortatilDAO the list portatil DAO
	 * @return the list
	 */
	public List<PortatilDTO> toListPortatilDTO(List<Portatil> listPortatilDAO);
	
}