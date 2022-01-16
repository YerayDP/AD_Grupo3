package com.example.demo.service;

import java.util.List;

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
	Inscrito transform(InscritoModel Inscritomodel);
	//abstract List<InscritoModel> listAllInscritos(InscritoModel InscritoModel);
	
}
