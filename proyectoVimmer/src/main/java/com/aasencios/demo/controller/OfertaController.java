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

import com.aasencios.demo.model.entidad.Categoria;
import com.aasencios.demo.model.entidad.Oferta;
import com.aasencios.demo.model.servicio.IOfertaService;

@Controller
@RequestMapping("/oferta")
public class OfertaController {

	@Autowired
	private IOfertaService ofertaService;
	
	@RequestMapping("/")
	public String inicio(Model model) {
		Oferta objOferta = new Oferta();
		model.addAttribute("oferta",objOferta);
		model.addAttribute("listaOferta", ofertaService.cargarOfertas());
		return "oferta/inicio";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Oferta oferta, BindingResult result, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("oferta",oferta);
			model.addAttribute("listaOferta", ofertaService.cargarOfertas());
			return "oferta/inicio";
		}
		String rpta= ofertaService.guardarOferta(oferta);
		flash.addFlashAttribute("mensaje",rpta);
		return "redirect:/oferta/";
	}
	
	/*@RequestMapping(value = "/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		Oferta objOferta = ofertaService.buscarOferta(id);
		model.addAttribute("oferta",objOferta);
		model.addAttribute("listaOferta",ofertaService.cargarOfertas());
		return "oferta/inicio";
	}*/
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		String rpta = ofertaService.eliminarOferta(id);
		flash.addFlashAttribute("mensaje",rpta);
		return "redirect:/oferta/";
	}
}
