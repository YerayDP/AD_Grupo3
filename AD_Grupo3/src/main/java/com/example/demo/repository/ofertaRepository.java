package com.example.demo.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Oferta;
<<<<<<< HEAD
import com.example.demo.entity.User;
import com.example.demo.models.OfertaModel;
import com.example.demo.models.UserModel;
=======
>>>>>>> branch 'Entrega2' of https://github.com/YerayDP/AD_Grupo3.git


@Repository("ofertaRepository")
public interface ofertaRepository extends JpaRepository <Oferta, Serializable>{

<<<<<<< HEAD
	public abstract List<Oferta> findByUsuario(User usuario);
=======
	List<Oferta> findByUsuario(int usuario);
	List<Oferta> findByFechamaxBefore(Date fecha);
>>>>>>> branch 'Entrega2' of https://github.com/YerayDP/AD_Grupo3.git
	
}
