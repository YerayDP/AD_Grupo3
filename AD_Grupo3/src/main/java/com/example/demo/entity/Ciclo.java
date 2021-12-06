package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ciclo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nombre;
	
	private String tipo;
	
	@OneToMany(mappedBy="ciclo", orphanRemoval=true)
	private List<Noticia> noticias = new ArrayList<>();
	
	@OneToMany(mappedBy="ciclo", orphanRemoval=true)
	private List<User> usuarios = new ArrayList<>();

	
	public Ciclo() {
		super();
	}

	public Ciclo(int id, String nombre, String tipo) { 
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
