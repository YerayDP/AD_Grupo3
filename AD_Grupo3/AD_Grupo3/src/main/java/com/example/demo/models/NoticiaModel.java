package com.example.demo.models;




public class NoticiaModel {

	
	private int id;
	
	private String titulo;
	
	private String descripcion;
	
	private String imagen;
	
	private CicloModel ciclo_id;
	

	public NoticiaModel() {
		super();
	}

	public NoticiaModel(int id, String titulo, String descripcion, String imagen, CicloModel ciclo_id) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.ciclo_id = ciclo_id;
	}

	public CicloModel getCiclo_id() {
		return ciclo_id;
	}

	public void setCiclo_id(CicloModel ciclo_id) {
		this.ciclo_id = ciclo_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	
}
