package com.aasencios.demo.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aasencios.demo.model.dao.IDistritoDAO;
import com.aasencios.demo.model.entidad.Distrito;

@Service
public class DistritoServiceImp implements IDistritoService{

	@Autowired
	private IDistritoDAO distritoDAO;
	
	@Override
	public String guardarDistrito(Distrito distrito) {
		String rpta="";
		
		try {
			distritoDAO.save(distrito);
			rpta="Se guardo el distrito correctamente";
		} catch (Exception e) {
			rpta= e.getMessage();
		}
		
		return rpta;
	}

	@Override
	public List<Distrito> cargarDistrito() {
		return (List<Distrito>)distritoDAO.findAll();
	}

	@Override
	public Distrito buscarDistrito(Long id) {
		return distritoDAO.findById(id).orElse(null);
	}

	@Override
	public String eliminarDistrito(Long id) {
		String rpta="";
		
		try {
			distritoDAO.deleteById(id);
			rpta="Se elimino el distrito correctamente";
		} catch (Exception e) {
			rpta = e.getMessage();
		}
		return rpta;
	}

	
}
