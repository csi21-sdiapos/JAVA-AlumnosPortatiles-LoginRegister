package com.AlumnosPortatiles.project.web.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.AlumnosPortatiles.project.app.entities.Portatil;
import com.AlumnosPortatiles.project.app.repositories.interfaces.IPortatilRepository;
import com.AlumnosPortatiles.project.web.services.interfaces.IPortatilService;


@Service(value = "PortatilServiceImpl")
public class PortatilServiceImpl implements IPortatilService {

	
	@Autowired
	IPortatilRepository portatilRepository;
	
	
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true, timeout = 10)
	@Override
	public List<Portatil> listarPortatiles() {
		try {
			return (List<Portatil>) portatilRepository.findAll();
			
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al listar los portatiles (return null): " + e);
			return null;
		}
	}
	
	

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true, timeout = 10)
	@Override
	public Portatil buscarPortatilPorId(long portatil_id) {
		try {
			return portatilRepository.findById(portatil_id).orElse(null);
			
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al buscar el portatil (return null): " + e);
			return null;
		}
	}

	
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = { Exception.class }, timeout = 10)
	@Override
	public void insertarPortatil(Portatil portatil) {
		try {
			portatilRepository.save(portatil);
			
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al insertar el nuevo portatil: " + e);
		}
	}

	
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = { Exception.class }, timeout = 10)
	@Override
	public void editarPortatil(long portatil_id, String portatil_marca, String portatil_modelo) {
		Portatil portatil = portatilRepository.findById(portatil_id).orElse(null);
		portatil.setPortatil_marca(portatil_marca);
		portatil.setPortatil_modelo(portatil_modelo);
		
		try {
			portatilRepository.save(portatil);
			
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al editar el portatil seleccionado: " + e);
		}
	}

	
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = { Exception.class }, timeout = 10)
	@Override
	public void eliminarPortatilPorId(long portatil_id) {
		try {
			portatilRepository.deleteById(portatil_id);
			
		} catch (Exception e) {
			System.out.println("\n[ERROR] - Error al eliminar el portatil seleccionado: " + e);
		}
	}

}