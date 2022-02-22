package com.example.demo.models;

import java.sql.Date;

import com.example.demo.entity.Ciclo;

public class OfertaModel {

    private int id;
	private String titular;
	private String descripcion;
	private String requisitos;
	private Date fechamax;
	private UserModel usuario;
	private int numCandidatos;
	private CicloModel ciclo;
	
	public OfertaModel() {
		super();
	}

	public OfertaModel(int id, String titular, String descripcion, String requisitos, Date fechamax,
			UserModel usuario, int numCandidatos, CicloModel ciclo) {
		super();
		this.id = id;
		this.titular = titular;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.fechamax = fechamax;
		this.usuario = usuario;
		this.numCandidatos = numCandidatos;
		this.ciclo= ciclo;
	}

	public UserModel getusuario() {
		return usuario;
	}

	public void setusuario(UserModel usuario) {
		this.usuario = usuario;
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

	public CicloModel getciclo() {
		return ciclo;
	}

	public void setciclo(CicloModel ciclo) {
		this.ciclo = ciclo;
	}
	
	
	
}
