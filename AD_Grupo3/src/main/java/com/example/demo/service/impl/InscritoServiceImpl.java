package com.example.demo.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.Inscrito;
import com.example.demo.entity.User;
import com.example.demo.models.InscritoModel;
import com.example.demo.models.OfertaModel;
import com.example.demo.repository.inscritoRepository;
import com.example.demo.service.InscritoService;

@Service("inscritoService")
public class InscritoServiceImpl implements InscritoService{
	
	@Autowired
	private inscritoRepository InscritoRepository;

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

	@Override
	public List<InscritoModel> listAllInscritos() {
		return InscritoRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());

	}

	@Override
	public Inscrito addInscrito(InscritoModel InscritoModel) {
		return InscritoRepository.save(transform(InscritoModel));
	}

	@Override
	public int removeInscrito(int id) {
		InscritoRepository.deleteById(id);
		return 0;
	}

	@Override
	public Inscrito updateInscrito(InscritoModel InscritoModel) {
		return InscritoRepository.save(transform(InscritoModel));
	}

	@Override
	public InscritoModel findInscrito(int id) {
		return transform(InscritoRepository.findById(id).orElse(null));
	}
	
	@Override
	public List<InscritoModel> findByUsuario(User user) {
		return InscritoRepository.findByUsuario(user).stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public List<InscritoModel> findByCiclo(Ciclo ciclo) {
		return InscritoRepository.findByCiclo(ciclo).stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public List<Inscrito> inscritos(Ciclo ciclo) {
		return InscritoRepository.inscritos(ciclo).stream()
				.collect(Collectors.toList());
	}

	@Override
	public List<Inscrito> empresaFecha(int id, Date d1, Date d2) {
		return InscritoRepository.empresaFechas(id,d1,d2).stream()
				.collect(Collectors.toList());
	}
	@Override
	public List<Inscrito> listInscritos() {
		return InscritoRepository.findAll().stream()
				.collect(Collectors.toList());

	}

	@Override
	public List<Inscrito> listInscritosN(int id) {
		return InscritoRepository.empresaFechasN(id).stream()
				.collect(Collectors.toList());
	}

	@Override
	public List<Inscrito> InscritoHistorial(long id) {
		return InscritoRepository.InscritoHistorial(id).stream()
				.collect(Collectors.toList());
	}

}
