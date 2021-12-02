package com.example.demo.service.impl;

import org.modelmapper.ModelMapper;

import com.example.demo.entity.Inscrito;
import com.example.demo.models.InscritoModel;

public class InscritoServiceImpl {

	public InscritoModel transform(Inscrito Inscrito)
	{
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(Inscrito, InscritoModel.class);
	}
	
	public Inscrito transform(InscritoModel Inscritomodel)
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(Inscritomodel, Inscrito.class);
	}
	
}
