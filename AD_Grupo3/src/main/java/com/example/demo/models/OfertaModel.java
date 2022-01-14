package com.example.demo.models;

import java.sql.Date;

import com.example.demo.entity.Ciclo;

public class OfertaModel {

    private int id;
	private String titular;
	private String descripcion;
	private String requisitos;
	private Date fechamax;
	private UserModel usuario_id;
	private int numCandidatos;
	private Ciclo ciclo_id;
	
	public OfertaModel() {
		super();
	}

	public OfertaModel(int id, String titular, String descripcion, String requisitos, Date fechamax,
			UserModel usuario_id, int numCandidatos, Ciclo ciclo_id) {
		super();
		this.id = id;
		this.titular = titular;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.fechamax = fechamax;
		this.usuario_id = usuario_id;
		this.numCandidatos = numCandidatos;
		this.ciclo_id= ciclo_id;
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

	public Ciclo getCiclo_id() {
		return ciclo_id;
	}

	public void setCiclo_id(Ciclo ciclo_id) {
		this.ciclo_id = ciclo_id;
	}
	
	
	
}
