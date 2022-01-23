package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.Inscrito;
import com.example.demo.entity.Oferta;
import com.example.demo.entity.User;
import com.example.demo.models.OfertaModel;
import com.example.demo.models.UserModel;
import com.example.demo.repository.ofertaRepository;
import com.example.demo.service.OfertaService;

@Service("ofertaService")
public class OfertaServiceImpl implements OfertaService{
	
	@Autowired
	@Qualifier("ofertaRepository")
	private ofertaRepository OfertaRepository;

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
	
	@Override
	public List<OfertaModel> listAllOfertas() {
		return OfertaRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public Oferta addOferta(OfertaModel OfertaModel) {
		return OfertaRepository.save(transform(OfertaModel));
	}

	@Override
	public int removeOferta(int id) {
		OfertaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Oferta updateOferta(OfertaModel OfertaModel) {
		return OfertaRepository.save(transform(OfertaModel));
	}
	
	@Override
	public OfertaModel findOferta(int id) {
		return transform(OfertaRepository.findById(id).orElse(null));
	}
	
	@Override
	public List<OfertaModel> findByUsuario(User user) {
		return OfertaRepository.findByUsuario(user).stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public List<OfertaModel> findByFechamaxBefore(Date fecha) {
		return OfertaRepository.findByFechamaxBefore(fecha).stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}
	
	@Override
	public List<OfertaModel> findByCiclo(Ciclo ciclo) {
		return OfertaRepository.findByCiclo(ciclo).stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public List<OfertaModel> findById(int id) {
		return OfertaRepository.findById(id).stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}


	@Override
	public List<OfertaModel> consulta(int id) {
		return OfertaRepository.consulta(id).stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public List<OfertaModel> posibles(int id) {
		return OfertaRepository.posibles(id).stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	
}
