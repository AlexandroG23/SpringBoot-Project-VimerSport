package com.aasencios.demo.model.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ofertas")
public class Oferta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "o_id")
	private Long id;
	
	@NotEmpty
	@Column(name = "o_tipo_oferta")
	private String tipo_oferta;
	
	@Column(name = "o_fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fecha_registro;
	
	@PrePersist
	@PreUpdate
	private void registrarFecha() {
		this.fecha_registro = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo_oferta() {
		return tipo_oferta;
	}

	public void setTipo_oferta(String tipo_oferta) {
		this.tipo_oferta = tipo_oferta;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	
	
}
