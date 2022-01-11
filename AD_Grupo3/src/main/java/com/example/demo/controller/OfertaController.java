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

import com.example.demo.entity.Oferta;
import com.example.demo.models.OfertaModel;
import com.example.demo.service.OfertaService;

@Controller
@RequestMapping("/ofertas")
public class OfertaController {

		@Autowired
		@Qualifier("ofertaService")
		private OfertaService ofertaService;
		
		private static  String OFERTAS_VIEW="ofertas";
		private static  String FORM="Form_ofertas";
		
		@GetMapping("/listOfertas/{id}")
		public ModelAndView listOfertas(@PathVariable("id") int id)
		{
			ModelAndView mav = new ModelAndView(OFERTAS_VIEW);
			mav.addObject("ofertas", ofertaService.findByUsuario(id));
			return mav; 
		}
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PostMapping("/addOferta")
		public String addOferta(@ModelAttribute("oferta")OfertaModel OfertaModel,Model model)
		{
			if(OfertaModel.getId()==0)
				ofertaService.addOferta(OfertaModel);
			else
				ofertaService.updateOferta(OfertaModel);
			
			return "redirect:/ofertas/listOfertas";
		}
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping(value={"/formOferta/", "/formOferta/{id}"})
		public String formOferta(@PathVariable(name="id", required=false)Integer id,Model model)
		{
			if(id==null)
				model.addAttribute("oferta",new Oferta());
			else
				model.addAttribute("oferta",ofertaService.findOferta(id));
			return FORM;
		}
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/delete/{id}")
		public String deleteOferta(@PathVariable("id")int id)
		{
			ofertaService.removeOferta(id);
			return "redirect:/ofertas/listOfertas";
		}
	
}
