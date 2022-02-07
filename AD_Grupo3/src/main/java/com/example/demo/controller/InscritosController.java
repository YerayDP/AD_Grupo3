package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.User;
import com.example.demo.models.CicloModel;
import com.example.demo.models.UserModel;
import com.example.demo.service.CicloService;
import com.example.demo.service.InscritoService;
import com.example.demo.service.OfertaService;
import com.example.demo.service.impl.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;

@Controller
@RequestMapping("/inscritos")
public class InscritosController {
	
	@Autowired
	@Qualifier("inscritoService")
	private InscritoService inscritoService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/inscritosFecha")
	public ModelAndView listInscrEmpresa(@PathVariable("id")int id,String d1, String d2) throws ParseException
	{
		ModelAndView mav = new ModelAndView("inscritos");
		
		UserModel user = userService.findStudentId(id);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date parsed = format.parse(d1);
	    java.sql.Date sql = new java.sql.Date(parsed.getTime());
	    
	    Date parsed1 = format.parse(d2);
	    java.sql.Date sql2 = new java.sql.Date(parsed1.getTime());
	    
		mav.addObject("inscritos", inscritoService.empresaFecha(user.getEmpresa(),sql,sql2));
		return mav; 
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/listInscritosCiclo/ciclo.id{id}")
	public ModelAndView listInscipcionesCiclo(@PathVariable("id")int id)
	{
		ModelAndView mav = new ModelAndView("inscritos");
		Ciclo ciclo = cicloService.findCicloById(id);
		mav.addObject("inscritos", inscritoService.inscritos(ciclo));
		return mav; 
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/listInscritosCiclo")
	public ModelAndView listInscipcionesCicloN()
	{
		ModelAndView mav = new ModelAndView("listInsCiclo");
		
		mav.addObject("inscritos", inscritoService.listInscritos());
	
		return mav; 
	}
	
	
}
