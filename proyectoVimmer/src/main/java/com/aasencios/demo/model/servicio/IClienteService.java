package com.aasencios.demo.model.servicio;

import java.util.List;

import com.aasencios.demo.model.entidad.Cliente;

public interface IClienteService {
	
	public List<Cliente> buscar(String apellido);

	public String guardarCliente(Cliente cliente);
	public List<Cliente> cargarClientes();
	public Cliente buscarCliente(Long id);
	public String eliminarCliente(Long id);
}
