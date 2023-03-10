package com.aasencios.demo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.aasencios.demo.model.entidad.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
}
