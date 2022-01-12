package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpSession;

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
import com.example.demo.models.UserModel;
import com.example.demo.service.OfertaService;
import com.example.demo.service.impl.UserService;

@Controller
@RequestMapping("/ofertas")
public class OfertaController {

		@Autowired
		@Qualifier("ofertaService")
		private OfertaService ofertaService;
		
		@Autowired
		private UserService userService;
		
		private static  String OFERTAS_VIEW="ofertas";
		private static  String FORM="Form_ofertas";
		
		@GetMapping("/listOfertas/{id}")
		public ModelAndView listOfertasUser(@PathVariable("id") long id)
		{
			ModelAndView mav = new ModelAndView(OFERTAS_VIEW);
			UserModel user = userService.findStudentId(id);
			mav.addObject("ofertas", ofertaService.findByUsuario(user.getId()));
			return mav; 
		}
		
		@GetMapping("/listOfertasA")
		public ModelAndView listOfertas()
		{
			ModelAndView mav = new ModelAndView("ofertasAdmin");
			mav.addObject("ofertas", ofertaService.listAllOfertas());
			return mav; 
		}
		
		@GetMapping("/listOfertasCaducadas")
		public ModelAndView listOfertasFilter()
		{
			Date localDate = java.sql.Date.valueOf(LocalDate.now());
			System.out.println(localDate);
			ModelAndView mav = new ModelAndView("ofertasFilter");
			mav.addObject("ofertas", ofertaService.findByFechamaxBefore(localDate));
			return mav; 
		}
		
		//@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PostMapping("/addOferta")
		public String addOferta(@ModelAttribute("oferta")OfertaModel OfertaModel,Model model,HttpSession session)
		{	
			String sessionId = session.getId();
			
			if(OfertaModel.getId()==0)
				ofertaService.addOferta(OfertaModel);
			else
				ofertaService.updateOferta(OfertaModel);
			
			System.out.println("AAAAAAAA   AAAAAAAAAA"+sessionId);
			return "redirect:/ofertas/listOfertas/"+11;
		}
		
		@PreAuthorize("hasRole('ROLE_RRHH')")
		@GetMapping(value={"/formOferta/", "/formOferta/{id}"})
		public String formOferta(@PathVariable(name="id", required=false)Integer id,Model model)
		{
			if(id==null)
				model.addAttribute("oferta",new Oferta());
			else
				model.addAttribute("oferta",ofertaService.findOferta(id));
			return FORM;
		}
		
		//@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/deleteU/{id}")
		public String deleteOfertaU(@PathVariable("id")int id,HttpSession session)
		{			
			ofertaService.removeOferta(id);
			return "redirect:/ofertas/listOfertas/"+11;
		}
		
		
		@GetMapping("/delete/{id}")
		public String deleteOferta(@PathVariable("id")int id)
		{
			ofertaService.removeOferta(id);
			return "redirect:/ofertas/listOfertasA";
		}
	
}
