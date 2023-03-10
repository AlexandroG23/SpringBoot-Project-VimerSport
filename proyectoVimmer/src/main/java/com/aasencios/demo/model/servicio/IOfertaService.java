package com.aasencios.demo.model.servicio;

import java.util.List;

import com.aasencios.demo.model.entidad.Oferta;

public interface IOfertaService {

	public String guardarOferta(Oferta oferta);
	public List<Oferta> cargarOfertas();
	public Oferta buscarOferta(Long id);
	public String eliminarOferta(Long id);
}
