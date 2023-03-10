package com.aasencios.demo.model.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aasencios.demo.model.dao.IOfertaDAO;
import com.aasencios.demo.model.entidad.Oferta;

@Service
public class OfertaServiceImp implements IOfertaService{

	@Autowired
	private IOfertaDAO ofertaDAO;
	
	@Override
	public String guardarOferta(Oferta oferta) {
		String rpta="";
		
		try {
			ofertaDAO.save(oferta);
			rpta="Se guardo datos de la oferta correctamente";
		} catch (Exception e) {
			rpta= e.getMessage();
		}
		
		return rpta;
	}

	@Override
	public List<Oferta> cargarOfertas() {
		return (List<Oferta>)ofertaDAO.findAll();
	}

	@Override
	public Oferta buscarOferta(Long id) {
		return ofertaDAO.findById(id).orElse(null);
	}

	@Override
	public String eliminarOferta(Long id) {
		String rpta="";
		
		try {
			ofertaDAO.deleteById(id);
			rpta="Se elimino datos de la Oferta correctamente";
		} catch (Exception e) {
			rpta = e.getMessage();
		}
		return rpta;
	}

}
