package com.example.demo.service.impl;

import org.modelmapper.ModelMapper;

import com.example.demo.entity.Ciclo;
import com.example.demo.models.CicloModel;

public class CicloServiceImpl {

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
	
}
