package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inscrito {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private User usuario;
	
	@ManyToOne 
	@JoinColumn(name="idOferta")
	private Oferta oferta;
	
	private Date fecha_inscripcion;
	
	public Inscrito() {
		super();
	}

	public Inscrito(int id, User usuario, Oferta oferta, Date fecha_inscripcion) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.oferta = oferta;
		this.fecha_inscripcion = fecha_inscripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Date getFecha_inscripcion() {
		return fecha_inscripcion;
	}

	public void setFecha_inscripcion(Date fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}
	
	
}
