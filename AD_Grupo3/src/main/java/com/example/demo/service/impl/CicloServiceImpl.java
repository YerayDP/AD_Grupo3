package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ciclo;
import com.example.demo.models.CicloModel;

import com.example.demo.repository.cicloRepository;
import com.example.demo.service.CicloService;


@Service("cicloService")
public class CicloServiceImpl implements CicloService{
	
	private cicloRepository CicloRepository;

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
	
	@Override
	public List<CicloModel> listAllCiclos() {
		return CicloRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());

	}

	@Override
	public Ciclo addCiclo(CicloModel CicloModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeCiclo(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Ciclo updateCiclo(CicloModel CicloModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CicloModel findCiclo(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	

	
	
	
}
