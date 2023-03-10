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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "distritos")
public class Distrito implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dis_id")
	private Long id;
	
	@NotEmpty
	@Column(name = "dis_nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "dis_postal")
	private Long postal;

	@Column(name = "dis_fecha_registro")
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getPostal() {
		return postal;
	}

	public void setPostal(Long postal) {
		this.postal = postal;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	

}
