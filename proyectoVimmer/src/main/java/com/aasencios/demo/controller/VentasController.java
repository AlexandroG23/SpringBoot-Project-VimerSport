package com.aasencios.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aasencios.demo.model.entidad.Cliente;
import com.aasencios.demo.model.servicio.IClienteService;

@Configuration
@RequestMapping("/ventas")
public class VentasController {

	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping("/")
	public String inicio() {
		return "ventas/index";
	}
	
	@RequestMapping(value = "/buscarCliente", method = RequestMethod.POST)
	public String buscar(String apellido, Model model) {
		//System.out.println("Apellido: "+apellido);
		List<Cliente> listaClientes = clienteService.buscar("%"+apellido+"%");
		if(listaClientes != null && listaClientes.size() > 0) {
			model.addAttribute("listaClientes", listaClientes);
		}else {
			model.addAttribute("warning", "No se encontraron resultados");
		}
		return "ventas/index";
	}
}
