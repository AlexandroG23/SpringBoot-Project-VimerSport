package com.aasencios.demo.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aasencios.demo.model.entidad.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long> {

	@Query(value = "SELECT * FROM clientes WHERE cli_apellido like ?1", nativeQuery = true)
	public List<Cliente> buscarCliente(String apellido);
}
