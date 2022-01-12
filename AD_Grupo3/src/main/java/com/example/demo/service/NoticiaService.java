package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Noticia;
import com.example.demo.models.NoticiaModel;


public interface NoticiaService {

	List<NoticiaModel> listAllNoticias();
	Noticia addNoticia(NoticiaModel NoticiaModel);
	int removeNoticia(int id);
	Noticia updateNoticia(NoticiaModel NoticiaModel);
	NoticiaModel findNoticia(int id);
	//List<NoticiaModel> listAllNoticias(NoticiaModel NoticiaModel);
	
}
