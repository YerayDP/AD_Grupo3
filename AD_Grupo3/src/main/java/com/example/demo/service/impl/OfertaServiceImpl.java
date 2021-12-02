package com.example.demo.service.impl;

import org.modelmapper.ModelMapper;

import com.example.demo.entity.Oferta;
import com.example.demo.models.OfertaModel;

public class OfertaServiceImpl {

	public OfertaModel transform(Oferta Oferta)
	{
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(Oferta, OfertaModel.class);
	}
	
	public Oferta transform(OfertaModel Ofertamodel)
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(Ofertamodel, Oferta.class);
	}
	
}
