package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Oferta;
import com.example.demo.entity.User;
import com.example.demo.models.OfertaModel;

public interface OfertaService {

	List<OfertaModel> listAllOfertas();
	Oferta addOferta(OfertaModel OfertaModel);
	int removeOferta(int id);
	Oferta updateOferta(OfertaModel OfertaModel);
	OfertaModel findOferta(int id);
<<<<<<< HEAD
	
	List<OfertaModel> findByDateBefore(Date fecha);
	List<OfertaModel> findByUsuario(User u);

=======
	List<OfertaModel> findByUsuario(int usuario);
	List<OfertaModel> findByFechamaxBefore(Date fecha);
	//abstract List<OfertaModel> listAllOfertas(OfertaModel OfertaModel);
>>>>>>> branch 'Entrega2' of https://github.com/YerayDP/AD_Grupo3.git
	
}
