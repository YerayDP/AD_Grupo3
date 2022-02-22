package com.example.demo.models;

import java.sql.Date;


public class InscritoModel {
	
    private int id;
	private Date fecha_inscripcion;
	private UserModel usuario_id;
	private OfertaModel oferta_id;
	
	public InscritoModel() {
		super();
	}

	public InscritoModel(int id, Date fecha_inscripcion, UserModel usuario_id, OfertaModel oferta_id) {
		super();
		this.id = id;
		this.fecha_inscripcion = fecha_inscripcion;
		this.usuario_id = usuario_id;
		this.oferta_id = oferta_id;
	}

	public UserModel getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(UserModel usuario_id) {
		this.usuario_id = usuario_id;
	}

	public OfertaModel getOferta_id() {
		return oferta_id;
	}

	public void setOferta_id(OfertaModel oferta_id) {
		this.oferta_id = oferta_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_inscripcion() {
		return fecha_inscripcion;
	}

	public void setFecha_inscripcion(Date fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}
	
	
}
