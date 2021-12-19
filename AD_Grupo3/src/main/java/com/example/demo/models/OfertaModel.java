package com.example.demo.models;

import java.sql.Date;

public class OfertaModel {

	
	
    private int id;
	private String titular;
	private String descripcion;
	private String requisitos;
	private Date fechamax;
	private UserModel usuario_id;
	private int numCandidatos;
	
	
	
	

	public OfertaModel() {
		super();
	}

	public OfertaModel(int id, String titular, String descripcion, String requisitos, Date fechamax,
			UserModel usuario_id, int numCandidatos) {
		super();
		this.id = id;
		this.titular = titular;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.fechamax = fechamax;
		this.usuario_id = usuario_id;
		this.numCandidatos = numCandidatos;
	}

	public UserModel getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(UserModel usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public Date getFechamax() {
		return fechamax;
	}

	public void setFechamax(Date fechamax) {
		this.fechamax = fechamax;
	}

	public int getNumCandidatos() {
		return numCandidatos;
	}

	public void setNumCandidatos(int numCandidatos) {
		this.numCandidatos = numCandidatos;
	}
	
}
