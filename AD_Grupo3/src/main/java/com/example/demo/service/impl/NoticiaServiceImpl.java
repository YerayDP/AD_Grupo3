package com.example.demo.service.impl;

import org.modelmapper.ModelMapper;

import com.example.demo.entity.Noticia;
import com.example.demo.models.NoticiaModel;

public class NoticiaServiceImpl {

	public NoticiaModel transform(Noticia Noticia)
	{
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(Noticia, NoticiaModel.class);
	}
	
	public Noticia transform(NoticiaModel Noticiamodel)
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(Noticiamodel, Noticia.class);
	}
	
}
