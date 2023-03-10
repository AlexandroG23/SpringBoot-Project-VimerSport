package com.aasencios.demo.model.servicio;

import java.util.List;

import com.aasencios.demo.model.entidad.Proveedor;

public interface IProveedorService {

	public String guardarProveedores(Proveedor proveedor);
	public List<Proveedor> cargarProveedor();
	public Proveedor buscarProveedor(Long id);
	public String eliminarProveedor(Long id);
}
