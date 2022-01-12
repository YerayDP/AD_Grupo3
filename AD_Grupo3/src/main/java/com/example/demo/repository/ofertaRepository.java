package com.example.demo.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Oferta;


@Repository("ofertaRepository")
public interface ofertaRepository extends JpaRepository <Oferta, Serializable>{

	List<Oferta> findByUsuario(int usuario);
	List<Oferta> findByFechamaxBefore(Date fecha);
	
}
