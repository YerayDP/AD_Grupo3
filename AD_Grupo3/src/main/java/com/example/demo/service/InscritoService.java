package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.Inscrito;
import com.example.demo.entity.User;
import com.example.demo.models.InscritoModel;

public interface InscritoService {

	List<InscritoModel> listAllInscritos();
	Inscrito addInscrito(InscritoModel InscritoModel);
	int removeInscrito(int id);
	Inscrito updateInscrito(InscritoModel InscritoModel);
	InscritoModel findInscrito(int id);
	List <InscritoModel> findByUsuario(User user);
	List <InscritoModel> findByCiclo(Ciclo ciclo);
	List<Inscrito> inscritos(Ciclo ciclo);
	List <Inscrito> empresaFecha(String id, Date d1, Date d2);
	Inscrito transform(InscritoModel Inscritomodel);
	List<Inscrito> listInscritos();

	List<Inscrito> listInscritosN(String id);
	
	
}
