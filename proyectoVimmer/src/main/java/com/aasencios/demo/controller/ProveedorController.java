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

import com.aasencios.demo.model.entidad.Proveedor;
import com.aasencios.demo.model.servicio.IProveedorService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {


	@Autowired
	private IProveedorService proveedorService;
	
	@RequestMapping("/")
	public String inicio(Model model) {
		Proveedor proveedor = new Proveedor();
		model.addAttribute("proveedor", proveedor );
		model.addAttribute("listaProveedores", proveedorService.cargarProveedor());
		return "proveedor/inicio";
	}
	
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Proveedor proveedor, BindingResult result, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("proveedor", proveedor );
			model.addAttribute("listaProveedores", proveedorService.cargarProveedor());
			return "proveedor/inicio";
		}
		String rpta = proveedorService.guardarProveedores(proveedor);
		flash.addFlashAttribute("mensaje",rpta);
		return "redirect:/proveedor/";
	}
	
	/*@RequestMapping(value = "/editar/{id}")
	public String editar(@PathVariable(value = "id")Long id, Model model) {
		Proveedor objProveedor = proveedorService.buscarProveedor(id);
		model.addAttribute("proveedor", objProveedor);
		model.addAttribute("listaProveedores", proveedorService.cargarProveedor());
		return "proveedor/inicio";
	}*/
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id")Long id, RedirectAttributes flash) {
		String rpta = proveedorService.eliminarProveedor(id);
		flash.addFlashAttribute("mensaje",rpta);
		return "redirect:/proveedor/";
	}
	
}
