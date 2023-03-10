package com.aasencios.demo.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aasencios.demo.model.entidad.DetalleOferta;

public interface IDetalleOfertaDAO extends CrudRepository<DetalleOferta, Long>{

	//public List<DetalleOferta> findAllByOrderByNombreAsc()
}
