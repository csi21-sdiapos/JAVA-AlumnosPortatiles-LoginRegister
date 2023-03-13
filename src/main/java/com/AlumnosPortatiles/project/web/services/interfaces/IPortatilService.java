package com.AlumnosPortatiles.project.web.services.interfaces;

import java.util.List;

import com.AlumnosPortatiles.project.app.entities.Portatil;


public interface IPortatilService {

	
	/**
	 * Listar portatiles.
	 *
	 * @return the list
	 */
	public List<Portatil> listarPortatiles();
	
	
	
	/**
	 * Buscar portatil por id.
	 *
	 * @param portatil_id the portatil id
	 * @return the portatil
	 */
	public Portatil buscarPortatilPorId(long portatil_id);
	
	
	
	/**
	 * Insertar portatil.
	 *
	 * @param portatil the portatil
	 */
	public void insertarPortatil(Portatil portatil);

	
	
	/**
	 * Editar portatil.
	 *
	 * @param portatil_id the portatil id
	 * @param portatil_marca the portatil marca
	 * @param portatil_modelo the portatil modelo
	 */
	public void editarPortatil(long portatil_id, String portatil_marca, String portatil_modelo);
	
	
	
	/**
	 * Eliminar portatil por id.
	 *
	 * @param portatil_id the portatil id
	 */
	public void eliminarPortatilPorId(long portatil_id);
	
}