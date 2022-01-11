package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.Noticia;
import com.example.demo.models.CicloModel;
import com.example.demo.models.NoticiaModel;
import com.example.demo.repository.noticiaRepository;
import com.example.demo.service.CicloService;
import com.example.demo.service.NoticiaService;

@Service("NoticiaService")
public class NoticiaServiceImpl implements NoticiaService{
	
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
	
	
	@Override
	public Noticia addNoticia(NoticiaModel NoticiaModel) {
		return noticiaRepository.save(transform(NoticiaModel));
	}

	public int removeNoticia(int id) {
		noticiaRepository.deleteById(id);
		return 0;
	}

	public Noticia updateNoticia(NoticiaModel NoticiaModel) {
		return noticiaRepository.save(transform(NoticiaModel));
	}
	
	public NoticiaModel findNoticia(int id) {
		return transform(noticiaRepository.findById(id).orElse(null));
	}

	@Override
	public List<NoticiaModel> listAllNoticias() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<NoticiaModel> listAllNoticias(NoticiaModel NoticiaModel) {
		return noticiaRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());

	}
	



	
}
