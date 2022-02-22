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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@ManyToOne 
	@JoinColumn(name="usuarioId")
	private User usuario;
	
	@JsonIgnore
	@ManyToOne 
	@JoinColumn(name="CicloID")
	private Ciclo ciclo;
	
	@JsonIgnore
	@OneToMany(mappedBy="oferta", orphanRemoval=true)
	private List<Inscrito>inscritos = new ArrayList<>();
	
	public Oferta(int id, String titular, String descripcion, String requisitos, Date fechamax, int numCandidatos,
			User usuario, Ciclo ciclo) {
		super();
		this.id = id;
		this.titular = titular;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.fechamax = fechamax;
		this.numCandidatos = numCandidatos;
		this.usuario = usuario;
		this.ciclo = ciclo;
	}

	public Oferta() {
		super();
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

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public List<Inscrito> getInscritos() {
		return inscritos;
	}

	public void setInscritos(List<Inscrito> inscritos) {
		this.inscritos = inscritos;
	}
	
	
}
