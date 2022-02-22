package com.example.demo.controller;

import java.sql.Date;
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
	@PreAuthorize("hasRole('ROLE_RRHH')")
	@GetMapping("/inscritosFecha")
	public ModelAndView listInscrEmpresa(Date d1, Date d2) throws ParseException
	{
		ModelAndView mav = new ModelAndView("ListInsFechas");
		String id= SecurityContextHolder.getContext().getAuthentication().getName();
		UserModel userM=userService.findStudentMail(id);
	    
		mav.addObject("inscritos", inscritoService.empresaFecha(userM.getId(),d1,d2));
		return mav; 
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/listInscritosCiclo/ciclo.id{id}")
	public ModelAndView listInscipcionesCiclo(@PathVariable("id")int id)
	{
		ModelAndView mav = new ModelAndView("listInsCiclo");
		mav.addObject("ciclos", cicloService.listAllCiclos());
		Ciclo ciclo = cicloService.findCicloById(id);
		mav.addObject("inscritos", inscritoService.inscritos(ciclo));
		return mav; 
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/listInscritosCiclo")
	public ModelAndView listInscipcionesCicloN()
	{
		ModelAndView mav = new ModelAndView("listInsCiclo");
		mav.addObject("ciclos", cicloService.listAllCiclos());
		mav.addObject("inscritos", inscritoService.listInscritos());
	
		return mav; 
	}
	@PreAuthorize("hasRole('ROLE_RRHH')")
	@GetMapping("/listInscritosCiclosE")
	public ModelAndView listInscipcionesFechaN()
	{
		ModelAndView mav = new ModelAndView("ListInsFechas"); 
		String id= SecurityContextHolder.getContext().getAuthentication().getName();
		UserModel userM=userService.findStudentMail(id);
		mav.addObject("inscritos", inscritoService.listInscritosN(userM.getId()));
	
		return mav; 
	}
	
}
