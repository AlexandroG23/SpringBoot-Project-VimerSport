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

import com.aasencios.demo.model.entidad.DetalleOferta;
import com.aasencios.demo.model.entidad.Producto;
import com.aasencios.demo.model.servicio.IDetalleOfertaService;
import com.aasencios.demo.model.servicio.IOfertaService;
import com.aasencios.demo.model.servicio.IProductoService;

@Controller
@RequestMapping("/detalle_oferta")
public class DetalleOfertaController {

	@Autowired
	private IDetalleOfertaService detalleOfertaService;
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IOfertaService ofertaService;
	
	@RequestMapping("/")
	public String inicio(Model model) {
		DetalleOferta objDetalleOferta = new DetalleOferta();
		model.addAttribute("detalleoferta", objDetalleOferta);
		model.addAttribute("listaProducto", productoService.cargarProductos());
		model.addAttribute("listaOferta", ofertaService.cargarOfertas());
		model.addAttribute("listaDetalleOferta", detalleOfertaService.cargarDetalleOferta());
		return "detalle_oferta/inicio";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid DetalleOferta detalleoferta, BindingResult result, RedirectAttributes flash, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("detalleoferta", detalleoferta);
			model.addAttribute("listaProducto", productoService.cargarProductos());
			model.addAttribute("listaOferta", ofertaService.cargarOfertas());
			model.addAttribute("listaDetalleOferta", detalleOfertaService.cargarDetalleOferta());
			return "detalle_oferta/inicio";
		}
	 	String rpta = detalleOfertaService.guardarDetalleOferta(detalleoferta);
	 	flash.addFlashAttribute("mensaje", rpta);
		return "redirect:/detalle_oferta/";
	}
	
	/*@RequestMapping(value = "/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		DetalleOferta objDetalleOferta = detalleOfertaService.buscaDetalleOferta(id);
		model.addAttribute("detalleoferta",objDetalleOferta);
		model.addAttribute("listaProducto", productoService.cargarProductos());
		model.addAttribute("listaOferta", ofertaService.cargarOfertas());
		model.addAttribute("listaDetalleOferta", detalleOfertaService.cargarDetalleOferta());
		return "detalle_oferta/inicio";
	}*/
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		String rpta = detalleOfertaService.eliminarDetalleOferta(id);
		flash.addFlashAttribute("mensaje",rpta);
		return "redirect:/detalle_oferta/";
	}
}
