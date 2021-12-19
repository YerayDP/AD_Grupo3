package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.NoticiaService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	/*@Autowired
	@Qualifier("noticiaService")
	private NoticiaService noticiaService;
	
	@GetMapping("/listNoticias")
	public ModelAndView listCiclos()
	{
		ModelAndView mav = new ModelAndView("noticias");
		mav.addObject("noticias", noticiaService.listAllNoticias());
		return mav;
	}*/
	
}
