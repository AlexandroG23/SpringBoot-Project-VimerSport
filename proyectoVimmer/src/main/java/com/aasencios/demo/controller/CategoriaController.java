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
import com.aasencios.demo.model.servicio.ICategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private ICategoriaService categoriaService;
	
	@RequestMapping("/")
	public String inicio(Model model) {
		Categoria objCategoria = new Categoria();
		model.addAttribute("categoria",objCategoria);
		model.addAttribute("listaCategorias",categoriaService.cargarCategorias());
		return "categoria/inicio";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Categoria categoria, BindingResult result, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("listaCategorias",categoriaService.cargarCategorias());
			return "categoria/inicio";
		}
		String rpta = categoriaService.guardarCategoria(categoria);
		flash.addFlashAttribute("mensaje",rpta);
		return "redirect:/categoria/";
	}
	
	/*@RequestMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		Categoria objCategoria = categoriaService.buscarCategoria(id);
		model.addAttribute("categoria",objCategoria);
		model.addAttribute("listaCategorias",categoriaService.cargarCategorias());
		return "categoria/inicio";
	}*/
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		String rpta = categoriaService.eliminarCategoria(id);
		flash.addFlashAttribute("mensaje",rpta);
		return "redirect:/categoria/";
	}
}
