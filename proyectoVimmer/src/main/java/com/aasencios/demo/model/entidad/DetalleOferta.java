package com.aasencios.demo.model.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_oferta")
public class DetalleOferta implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "det_oferta_id")
	private Long id;
	
	@NotNull
	@Column(name = "det_oferta_cantidad")
	private Long oferta_cantidad;
	
	@ManyToOne
	@JoinColumn(name = "pro_id")
	Producto producto;
	//private Long pro_id;
	
	@ManyToOne
	@JoinColumn(name = "o_id")
	Oferta oferta;
	//private Long o_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOferta_cantidad() {
		return oferta_cantidad;
	}

	public void setOferta_cantidad(Long oferta_cantidad) {
		this.oferta_cantidad = oferta_cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	
	
	
	
	
}
