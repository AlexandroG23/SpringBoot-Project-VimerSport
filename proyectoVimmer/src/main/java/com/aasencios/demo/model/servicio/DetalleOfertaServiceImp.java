package com.aasencios.demo.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aasencios.demo.model.dao.IDetalleOfertaDAO;
import com.aasencios.demo.model.entidad.DetalleOferta;

@Service
public class DetalleOfertaServiceImp implements IDetalleOfertaService{

	@Autowired
	private IDetalleOfertaDAO detalleOfertaDAO;
	
	@Override
	public String guardarDetalleOferta(DetalleOferta detalleoferta) {
		String rpta="";
		
		try {
			detalleOfertaDAO.save(detalleoferta);
			rpta="Se guardo los datos en detalle de oferta correctamente";
		} catch (Exception e) {
			rpta= e.getMessage();
		}
		
		return rpta;
	}

	@Override
	public List<DetalleOferta> cargarDetalleOferta() {
		return (List<DetalleOferta>)detalleOfertaDAO.findAll();
	}

	@Override
	public DetalleOferta buscaDetalleOferta(Long id) {
		return detalleOfertaDAO.findById(id).orElse(null);
	}

	@Override
	public String eliminarDetalleOferta(Long id) {
		String rpta="";
		
		try {
			detalleOfertaDAO.deleteById(id);
			rpta="Se elimino los datos en Detalle de oferta correctamente";
		} catch (Exception e) {
			rpta = e.getMessage();
		}
		return rpta;
	}

}
