package com.aasencios.demo.model.servicio;

import java.util.List;

import com.aasencios.demo.model.entidad.Distrito;

public interface IDistritoService {

	public String guardarDistrito(Distrito distrito);
	public List<Distrito> cargarDistrito();
	public Distrito buscarDistrito(Long id);
	public String eliminarDistrito(Long id);
	
}
