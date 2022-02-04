package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Ciclo;
import com.example.demo.models.CicloModel;
import com.example.demo.service.CicloService;
import com.example.demo.service.InscritoService;
import com.example.demo.service.OfertaService;

@Controller
@RequestMapping("/inscritos")
public class InscritosController {
	
	@Autowired
	@Qualifier("inscritoService")
	private InscritoService inscritoService;
	
	@Autowired
	@Qualifier("ofertaService")
	private OfertaService ofertaService;
	
	@Autowired
	@Qualifier("cicloService")
	private CicloService cicloService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/listCiclos")
	public ModelAndView listInscipcionesCiclos()
	{
		ModelAndView mav = new ModelAndView("inscritosCiclos");
		mav.addObject("ciclos", cicloService.listAllCiclos());
		return mav; 
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/listInscritos/{id}")
	public ModelAndView listInscipciones(@PathVariable("id")int id)
	{
		ModelAndView mav = new ModelAndView("inscritos");
		Ciclo ciclo = cicloService.findCicloById(id);
		mav.addObject("inscritos", inscritoService.inscritos(ciclo));
		return mav; 
	}
	
}
