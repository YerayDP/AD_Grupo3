package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	private String nombre;
	
	private String apellidos;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=true)
	@Size(max=9)
	private String telefono;
	
	
	@Column(nullable=true)
	private String empresa;
	
	@Column(nullable=true)
	private boolean activo;
	
	@OneToMany(mappedBy="usuario", orphanRemoval=true)
	private List<Oferta> ofertas = new ArrayList<>();
	
	@ManyToOne 
	@JoinColumn(name="CicloID")
	private Ciclo ciclo;
	
	@OneToMany(mappedBy="usuario", orphanRemoval=true)
	private List<Inscrito>inscritos = new ArrayList<>();

	public Usuario() {
		super();
	}

	public Usuario(int id, String nombre, String apellidos, boolean activo, String email, String password,
			String telefono, String empresa, List<Oferta> ofertas, Ciclo ciclo, List<Inscrito> inscritos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.activo = activo;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.empresa = empresa;
		this.ofertas = ofertas;
		this.ciclo = ciclo;
		this.inscritos = inscritos;
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

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
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
