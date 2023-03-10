package com.aasencios.demo.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aasencios.demo.model.dao.IProveedorDAO;
import com.aasencios.demo.model.entidad.Proveedor;

@Service
public class ProveedorServiceImp implements IProveedorService{

	@Autowired
	private IProveedorDAO proveedorDAO;

	@Override
	public String guardarProveedores(Proveedor proveedor) {
		String rpta="";
		try {
			proveedorDAO.save(proveedor);
			rpta="Se guardo el proveedor correctamente";
		} catch (Exception e) {
			rpta=e.getMessage();
		}
		
		return rpta;
	}

	@Override
	public List<Proveedor> cargarProveedor() {
		return (List<Proveedor>)proveedorDAO.findAll();
	}

	@Override
	public Proveedor buscarProveedor(Long id) {
		return proveedorDAO.findById(id).orElse(null);
	}

	@Override
	public String eliminarProveedor(Long id) {
		String rpta="";
		
		try {
			proveedorDAO.deleteById(id);
			rpta="Se elimino datos del proveedor correctamente";
		} catch (Exception e) {
			rpta = e.getMessage();
		}
		return rpta;
	}

	

	
	
	

}
