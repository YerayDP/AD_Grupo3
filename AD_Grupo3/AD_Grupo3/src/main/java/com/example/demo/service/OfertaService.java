package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.Inscrito;
import com.example.demo.entity.Oferta;
import com.example.demo.entity.User;
import com.example.demo.models.InscritoModel;
import com.example.demo.models.OfertaModel;

public interface OfertaService {

	List<OfertaModel> listAllOfertas();
	Oferta addOferta(OfertaModel OfertaModel);
	int removeOferta(int id);
	Oferta updateOferta(OfertaModel OfertaModel);
	OfertaModel findOferta(int id);
	List<OfertaModel> findByUsuario(User user);
	List<OfertaModel> findByCiclo(Ciclo ciclo);
	List<OfertaModel> findByFechamaxBefore(Date fecha);
	Oferta transform(OfertaModel Ofertamodel);
	List<OfertaModel> findById(int id);
	List<OfertaModel> consulta(int id);
	List<OfertaModel> posibles(int id);
	List<OfertaModel> pdf(Ciclo Ciclo, Date fecha);
	
}
