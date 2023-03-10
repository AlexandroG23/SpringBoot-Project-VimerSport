package com.aasencios.demo.model.servicio;

import java.util.List;

import com.aasencios.demo.model.entidad.Producto;

public interface IProductoService {

	public String guardarProducto(Producto producto);
	public List<Producto> cargarProductos();
	//public Producto buscaProducto(Long id);
	public String eliminarProducto(Long id);
}
