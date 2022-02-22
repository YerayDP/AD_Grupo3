package com.example.demo.repository;

import java.io.Serializable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.Noticia;
import com.example.demo.entity.Oferta;
import com.example.demo.models.NoticiaModel;


@Repository("noticiaRepository")
public interface noticiaRepository extends JpaRepository <Noticia, Serializable>{
	public Noticia findById(int id);
	public List<Noticia> findByCiclo(Ciclo ciclo);
	
	
}
