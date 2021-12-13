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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@NotNull(message="Este campo no puede estar vacío")
	private String nombre;
	
	private String role;
	
	@NotNull(message="Este campo no puede estar vacío")
	private String apellidos;
	
	@NotNull(message="Este campo no puede estar vacío")
	@Email
	private String email;
	
	@NotNull
	@Size(min=5, message="Introduzca un mínimo de 5 caracteres")
	private String password;
	
	@NotNull(message="Este campo no puede estar vacío")
	@Size(max=9, message="Telefono no válido")
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

	

	public User() {
		super();
	}

	public User(long id, String nombre, String role, String apellidos, String email, String password,
			@Size(max = 9) String telefono, String empresa, boolean activo, List<Oferta> ofertas, Ciclo ciclo,
			List<Inscrito> inscritos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.role = role;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.empresa = empresa;
		this.activo = activo;
		this.ofertas = ofertas;
		this.ciclo = ciclo;
		this.inscritos = inscritos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
