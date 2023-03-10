package com.aasencios.demo.model.servicio;

import java.util.List;

import com.aasencios.demo.model.entidad.Categoria;

public interface ICategoriaService{
	public String guardarCategoria(Categoria categoria);
	public List<Categoria> cargarCategorias();
	public Categoria buscarCategoria(Long id);
	public String eliminarCategoria(Long id);
}
