package com.example.demo.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Oferta {

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	private String titular;
	private String descripcion;
	private String requisitos;
	private Date fechamax;
	private int numCandidatos;
	@ManyToOne 
	@JoinColumn(name="rrhhid")
	private RRHH rrhh;
	
	@OneToMany(mappedBy="oferta", orphanRemoval=true)
	private List<Inscrito>inscritos = new ArrayList<>();

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

	public RRHH getRrhh() {
		return rrhh;
	}

	public void setRrhh(RRHH rrhh) {
		this.rrhh = rrhh;
	}

	public Oferta(int id, String titular, String descripcion, String requisitos, Date fechamax, int numCandidatos,
			RRHH rrhh) {
		super();
		this.id = id;
		this.titular = titular;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.fechamax = fechamax;
		this.numCandidatos = numCandidatos;
		this.rrhh = rrhh;
	}

	public Oferta() {
		super();
	}
	
}
