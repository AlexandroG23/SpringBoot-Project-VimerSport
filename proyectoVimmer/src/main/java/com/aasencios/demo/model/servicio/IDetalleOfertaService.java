package com.aasencios.demo.model.servicio;

import java.util.List;

import com.aasencios.demo.model.entidad.DetalleOferta;

public interface IDetalleOfertaService {

	public String guardarDetalleOferta(DetalleOferta detalleoferta);
	public List<DetalleOferta> cargarDetalleOferta();
	public DetalleOferta buscaDetalleOferta(Long id);
	public String eliminarDetalleOferta(Long id);
}
