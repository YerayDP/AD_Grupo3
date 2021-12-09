package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ciclo;
import com.example.demo.models.CicloModel;
import com.example.demo.repository.cicloRepository;
import com.example.demo.service.CicloService;


@Service("cicloService")
public class CicloServiceImpl implements CicloService{
	
	@Autowired
	@Qualifier("cicloRepository")
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


}
