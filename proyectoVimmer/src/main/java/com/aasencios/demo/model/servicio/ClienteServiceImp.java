package com.aasencios.demo.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aasencios.demo.model.dao.IClienteDAO;
import com.aasencios.demo.model.entidad.Cliente;

@Service
public class ClienteServiceImp implements IClienteService{

	@Autowired
	private IClienteDAO clienteDAO;
	
	@Override
	public String guardarCliente(Cliente cliente) {
		String rpta="";
		
		try {
			clienteDAO.save(cliente);
			rpta="Se guardo datos del cliente correctamente";
		} catch (Exception e) {
			rpta= e.getMessage();
		}
		
		return rpta;
	}

	@Override
	public List<Cliente> cargarClientes() {
		return (List<Cliente>)clienteDAO.findAll();
	}

	@Override
	public Cliente buscarCliente(Long id) {
		return clienteDAO.findById(id).orElse(null);
	}

	@Override
	public String eliminarCliente(Long id) {
		String rpta="";
		
		try {
			clienteDAO.deleteById(id);
			rpta="Se elimino datos del cliente correctamente";
		} catch (Exception e) {
			rpta = e.getMessage();
		}
		return rpta;
	}

	@Override
	public List<Cliente> buscar(String apellido) {
		return clienteDAO.buscarCliente(apellido);
	}

}
