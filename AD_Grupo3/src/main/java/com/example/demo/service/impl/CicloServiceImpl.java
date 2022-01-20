package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.User;
import com.example.demo.models.CicloModel;
import com.example.demo.models.NoticiaModel;
import com.example.demo.repository.cicloRepository;
import com.example.demo.service.CicloService;
import com.example.demo.repository.noticiaRepository;


@Service("cicloService")
public class CicloServiceImpl implements CicloService{
	
	@Autowired
	private cicloRepository CicloRepository;

	@Autowired
	private noticiaRepository noticiaRepository;
	@Autowired
	private com.example.demo.repository.UserRepository UserRepository;

	public CicloModel transform(Ciclo Ciclo) 
	{
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(Ciclo, CicloModel.class);
	}
	
	public Ciclo transform(CicloModel Ciclomodel)
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(Ciclomodel, Ciclo.class);
	}
	

	public List<CicloModel> listAllCiclos() {
		return CicloRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());

	}

	@Override
	public Ciclo addCiclo(CicloModel CicloModel) {
		return CicloRepository.save(transform(CicloModel));
	}

	public int removeCiclo(int id) {
		CicloRepository.deleteById(id);
		return 0;
	}

	public Ciclo updateCiclo(CicloModel CicloModel) {
		return CicloRepository.save(transform(CicloModel));
	}
	
	public CicloModel findCiclo(int id) {
		return transform(CicloRepository.findById(id).orElse(null));
	}

	
	@Override
	public List<NoticiaModel> listByCiclo(CicloModel ciclo) {
		ModelMapper modelMapper = new ModelMapper();
		return noticiaRepository.findByCiclo(transform(ciclo)).stream()
				.map(n -> modelMapper.map(n, NoticiaModel.class))
				.collect(Collectors.toList());
	}

	@Override
	public Ciclo findbyUserCicloId(User User) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ciclo findCicloById(int id) {
		return CicloRepository.findById(id).orElse(null);
	}

}
