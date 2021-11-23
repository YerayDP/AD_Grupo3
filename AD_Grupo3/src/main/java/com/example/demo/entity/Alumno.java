package com.example.demo.entity;

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
public class Alumno {

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	private String nombre;
	private String apellidos;
	private boolean activo;
	public Alumno() {
		super();
	}

	public Alumno(int id, String nombre, String apellidos, boolean activo, String email, String password,
			String telefono, Ciclo ciclo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.activo = activo;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.ciclo = ciclo;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	private String email;
	private String password;
	private String telefono;
	
	@ManyToOne 
	@JoinColumn(name="CicloID")
	private Ciclo ciclo;
	
	@OneToMany(mappedBy="alumno", orphanRemoval=true)
	private List<Inscrito>inscritos = new ArrayList<>();
}
