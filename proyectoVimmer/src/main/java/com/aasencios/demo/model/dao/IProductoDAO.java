package com.aasencios.demo.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aasencios.demo.model.entidad.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long>{
	
	public List<Producto> findAllByOrderByNombreAsc();
}
