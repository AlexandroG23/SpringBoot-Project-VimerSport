package com.aasencios.demo.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aasencios.demo.model.dao.ICategoriaDAO;
import com.aasencios.demo.model.entidad.Categoria;

@Service
public class CategoriaServiceImp implements ICategoriaService{

	@Autowired
	private ICategoriaDAO categoriaDAO;
	
	@Override
	public String guardarCategoria(Categoria categoria) {
		String rpta="";
		
		try {
			categoriaDAO.save(categoria);
			rpta="Se guardo datos de la categoria correctamente";
		} catch (Exception e) {
			rpta= e.getMessage();
		}
		
		return rpta;
	}

	@Override
	public List<Categoria> cargarCategorias() {
		return (List<Categoria>)categoriaDAO.findAll();
	}

	@Override
	public Categoria buscarCategoria(Long id) {
		return categoriaDAO.findById(id).orElse(null);
	}

	@Override
	public String eliminarCategoria(Long id) {
		String rpta="";
		
		try {
			categoriaDAO.deleteById(id);
			rpta="Se elimino datos de la categoria correctamente";
		} catch (Exception e) {
			rpta = e.getMessage();
		}
		return rpta;
	}

}
