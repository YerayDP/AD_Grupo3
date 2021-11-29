package com.example.demo.models;

import java.sql.Date;


public class InscritoModel {
	
    private int id;
	
	public InscritoModel() {
		super();
	}

	public InscritoModel(int id, AlumnoModel alumno, OfertaModel oferta, Date fecha_inscripcion) {
		super();
		this.id = id;
		this.fecha_inscripcion = fecha_inscripcion;
	}

	private Date fecha_inscripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_inscripcion() {
		return fecha_inscripcion;
	}

	public void setFecha_inscripcion(Date fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}
	
	
}
