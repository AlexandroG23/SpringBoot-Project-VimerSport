package com.aasencios.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aasencios.demo.model.entidad.Cliente;
import com.aasencios.demo.model.servicio.IClienteService;
import com.aasencios.demo.model.servicio.IDistritoService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private IDistritoService distritoService;
	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping("/")
	public String inicio(Model model) {
		Cliente objCliente = new Cliente();
		model.addAttribute("cliente",objCliente);
		model.addAttribute("listaDistrito", distritoService.cargarDistrito());
		model.addAttribute("listaClientes", clienteService.cargarClientes());
		return "cliente/inicio";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("listaDistrito", distritoService.cargarDistrito());
			model.addAttribute("listaClientes", clienteService.cargarClientes());
			return "cliente/inicio";
		}
		
		String rpta = clienteService.guardarCliente(cliente);
		flash.addFlashAttribute("mensaje",rpta);
		return "redirect:/cliente/";
	}
	
	/*@RequestMapping(value = "/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		Cliente objCliente = clienteService.buscarCliente(id);
		model.addAttribute("cliente",objCliente);
		model.addAttribute("listaDistrito", distritoService.cargarDistrito());
		model.addAttribute("listaClientes", clienteService.cargarClientes());
		return "cliente/inicio";
	}*/
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		String rpta = clienteService.eliminarCliente(id);
		flash.addFlashAttribute("mensaje",rpta);
		return "redirect:/cliente/";
	}
}
