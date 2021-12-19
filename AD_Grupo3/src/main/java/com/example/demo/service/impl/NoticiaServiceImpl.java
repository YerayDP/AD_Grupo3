package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Noticia;
import com.example.demo.models.NoticiaModel;
import com.example.demo.repository.noticiaRepository;

@Service("NoticiaService")
public class NoticiaServiceImpl {
	
	@Autowired
	@Qualifier("noticiaRepository")
	private noticiaRepository noticiaRepository;

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
	
	public List<NoticiaModel> listAllNoticias() {
		return noticiaRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());

	}
	
}
