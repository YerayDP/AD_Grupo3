package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.Noticia;
import com.example.demo.models.CicloModel;
import com.example.demo.models.NoticiaModel;
import com.example.demo.service.CicloService;
import com.example.demo.service.NoticiaService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	private static  String NOTICIAS_VIEW="noticias";
	private static  String FORM="Form_noticias";

	@Autowired
	private NoticiaService noticiaService;
	
	@GetMapping("/listNoticia")
	public ModelAndView listCiclos()
	{
		ModelAndView mav = new ModelAndView(NOTICIAS_VIEW);
		mav.addObject("noticias", noticiaService.listAllNoticias());
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addNoticia")
	public String addNoticia(@ModelAttribute("noticia")NoticiaModel NoticiaModel,Model model)
	{
		if(NoticiaModel.getId()==0)
			noticiaService.addNoticia(NoticiaModel);
		else
			noticiaService.updateNoticia(NoticiaModel);
		
		return "redirect:/noticias/listNoticia";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value={"/formNoticia/", "/formNoticia/{id}"})
	public String formNoticia(@PathVariable(name="id", required=false)Integer id,Model model)
	{
		if(id==null)
			model.addAttribute("noticia",new Noticia());
		else
			model.addAttribute("noticia",noticiaService.findNoticia(id));
		return FORM;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteNoticia(@PathVariable("id")int id)
	{
		noticiaService.removeNoticia(id);
		return "redirect:/noticias/listNoticia";
	}
	
}
