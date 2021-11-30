package com.example.demo.models;

public class UserModel {


    private int id;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private String telefono;
	private String empresa;
	private boolean activo;
	private CicloModel ciclo_id;

	

	public UserModel() {
		super();
	}

	public UserModel(int id, String nombre, String apellidos, String email, String password, String telefono,
			String empresa, boolean activo, CicloModel ciclo_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.empresa = empresa;
		this.activo = activo;
		this.ciclo_id = ciclo_id;
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

	public CicloModel getCiclo_id() {
		return ciclo_id;
	}

	public void setCiclo_id(CicloModel ciclo_id) {
		this.ciclo_id = ciclo_id;
	}

}
