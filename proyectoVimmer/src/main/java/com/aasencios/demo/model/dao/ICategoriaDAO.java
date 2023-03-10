package com.aasencios.demo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.aasencios.demo.model.entidad.Categoria;

public interface ICategoriaDAO extends CrudRepository<Categoria, Long>{

	
}
