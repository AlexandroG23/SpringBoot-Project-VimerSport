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

import com.aasencios.demo.model.entidad.Distrito;
import com.aasencios.demo.model.servicio.IDistritoService;

@Controller
@RequestMapping("/distrito")
public class DistritoController {

	
	@Autowired
	private IDistritoService distritoService;

	@RequestMapping("/")
	public String inicio(Model model) {
		Distrito distrito  = new Distrito();
		model.addAttribute("distrito", distrito);
		model.addAttribute("listaDistritos",distritoService.cargarDistrito());
		return "distrito/inicio";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Distrito distrito, BindingResult result, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("distrito", distrito);
			model.addAttribute("listaDistritos",distritoService.cargarDistrito());
			return "distrito/inicio";
		}
		String rpta = distritoService.guardarDistrito(distrito);
		flash.addFlashAttribute("mensaje",rpta);
		return "redirect:/distrito/";
	}
	
	/*@RequestMapping(value = "/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		Distrito objDistrito = distritoService.buscarDistrito(id);
		model.addAttribute("distrito", objDistrito);
		model.addAttribute("listaDistritos", distritoService.cargarDistrito());
		return "distrito/inicio";
	}*/
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		String rpta = distritoService.eliminarDistrito(id);
		flash.addFlashAttribute("mensaje",rpta);
		return "redirect:/distrito/";
	}
}
