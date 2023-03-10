package com.aasencios.demo.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aasencios.demo.model.dao.IProductoDAO;
import com.aasencios.demo.model.entidad.Producto;

@Service
public class ProductoServiceImp implements IProductoService{

	@Autowired
	private IProductoDAO productoDAO;
	
	@Override
	public String guardarProducto(Producto producto) {
		String rpta="";
		
		try {
			productoDAO.save(producto);
			rpta="Se guardo el producto correctamente";
		} catch (Exception e) {
			rpta= e.getMessage();
		}
		
		return rpta;
	}

	@Override
	public List<Producto> cargarProductos() {
		return productoDAO.findAllByOrderByNombreAsc();
	}

	/*@Override
	public Producto buscaProducto(Long id) {
		return productoDAO.findById(id).orElse(null);
	}*/

	@Override
	public String eliminarProducto(Long id) {
		String rpta="";
		
		try {
			productoDAO.deleteById(id);
			rpta="Se elimino el producto  correctamente";
		} catch (Exception e) {
			rpta = e.getMessage();
		}
		return rpta;
	}

}
