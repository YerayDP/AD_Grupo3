package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.Inscrito;
import com.example.demo.entity.Oferta;
import com.example.demo.entity.User;
import com.example.demo.models.CicloModel;
import com.example.demo.models.InscritoModel;
import com.example.demo.models.OfertaModel;
import com.example.demo.models.UserModel;
import com.example.demo.service.CicloService;
import com.example.demo.service.InscritoService;
import com.example.demo.service.OfertaService;
import com.example.demo.service.impl.UserService;

@Controller
@RequestMapping("/ofertas")
public class OfertaController {

		@Autowired
		@Qualifier("ofertaService")
		private OfertaService ofertaService;
		
		@Autowired
		@Qualifier("cicloService")
		private CicloService cicloService;
		
		@Autowired
		private UserService userService;
		
		@Autowired
		@Qualifier("inscritoService")
		private InscritoService inscritoService;
		
		private static  String OFERTAS_VIEW="ofertas";
		private static  String FORM="Form_ofertas";
		private static  String FORMU="Form_ofertasU";
		
		@PreAuthorize("hasRole('ROLE_RRHH')")
		@GetMapping("/listOfertas")
		public ModelAndView listOfertasUser()
		{
			ModelAndView mav = new ModelAndView(OFERTAS_VIEW);
			String mail = SecurityContextHolder.getContext().getAuthentication().getName();
			UserModel user = userService.findStudentMail(mail);
			User u = userService.transform(user);
			mav.addObject("ofertas", ofertaService.findByUsuario(u));
			return mav; 
		}
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/listOfertasA")
		public ModelAndView listOfertas()
		{
			ModelAndView mav = new ModelAndView("ofertasAdmin");
			mav.addObject("ofertas", ofertaService.listAllOfertas());
			return mav; 
		}
		
		@PreAuthorize("hasRole('ROLE_ALUMNO')")
		@GetMapping("/listOfertasAlumno")
		public ModelAndView listOfertasAlumno()
		{
			
			String mail = SecurityContextHolder.getContext().getAuthentication().getName();
			UserModel user = userService.findStudentMail(mail);
			
			List<OfertaModel> ofertas = ofertaService.listAllOfertas();
			List<Oferta> ofertasS = new ArrayList<Oferta>();
			for (int i = 0; i < ofertas.size(); i++) {
				ofertasS.add(ofertaService.transform(ofertas.get(i)));
			}
			List<InscritoModel> inscrito = inscritoService.findByUsuario(userService.transform(user));
			List<Inscrito> inscritoS = new ArrayList<Inscrito>();
			
			for (int i = 0; i < inscrito.size(); i++) {
				inscritoS.add(inscritoService.transform(inscrito.get(i)));
			}
			
			for (int i = 0; i < inscritoS.size(); i++) {
				for ( int j = 0 ; j < ofertasS.size(); j++) {
					if(inscritoS.get(i).getOferta().equals(ofertasS.get(j))) {
						ofertasS.remove(j);
					}
				}
			}
			
			ModelAndView mav = new ModelAndView("ofertasAlumno");
			mav.addObject("ciclos", cicloService.listAllCiclos());
			mav.addObject("ofertas", ofertasS);
			return mav; 
		}
		
		@PreAuthorize("hasRole('ROLE_ALUMNO')")
		@GetMapping("/listOfertasAlumnos/ciclo.id{id}")
		public ModelAndView listOfertasAlumnoFiltro(@PathVariable("id")int id)
		{
			ModelAndView mav = new ModelAndView("ofertasAlumno");
			mav.addObject("ciclos", cicloService.listAllCiclos());
			CicloModel ciclo = cicloService.findCiclo(id);
			Ciclo c = cicloService.transform(ciclo);
			mav.addObject("ofertas", ofertaService.findByCiclo(c));
			return mav;
		}
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/listOfertasCaducadas")
		public ModelAndView listOfertasFilter()
		{
			Date localDate = java.sql.Date.valueOf(LocalDate.now());
			System.out.println(localDate);
			ModelAndView mav = new ModelAndView("ofertasFilter");
			mav.addObject("ofertas", ofertaService.findByFechamaxBefore(localDate));
			return mav; 
		}
		
		@PreAuthorize("hasRole('ROLE_RRHH')")
		@PostMapping("/addOferta")
		public String addOferta(@ModelAttribute("oferta")OfertaModel OfertaModel,Model model,HttpSession session)
		{	
			String mail = SecurityContextHolder.getContext().getAuthentication().getName();
			UserModel user = userService.findStudentMail(mail);
			OfertaModel.setusuario(user);
			
			if(OfertaModel.getId()==0)
				ofertaService.addOferta(OfertaModel);
			else
				ofertaService.updateOferta(OfertaModel);

			return "redirect:/ofertas/listOfertas/";
		}
		
		@PreAuthorize("hasRole('ROLE_RRHH')")
		@GetMapping(value={"/formOferta/", "/formOferta/{id}"})
		public String formOferta(@PathVariable(name="id", required=false)Integer id,Model model)
		{
			String mail = SecurityContextHolder.getContext().getAuthentication().getName();
			UserModel user = userService.findStudentMail(mail);
			
			model.addAttribute("ciclos", cicloService.listAllCiclos());
			
			if(id==null)
				model.addAttribute("oferta",new Oferta());
			else
			{
				model.addAttribute("oferta",ofertaService.findOferta(id));
			}
			return FORM;
		}
		
		@PreAuthorize("hasRole('ROLE_RRHH')")
		@GetMapping("/deleteU/{id}")
		public String deleteOfertaU(@PathVariable("id")int id,HttpSession session)
		{			
			ofertaService.removeOferta(id);
			return "redirect:/ofertas/listOfertas";
		}
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/delete/{id}")
		public String deleteOferta(@PathVariable("id")int id)
		{
			ofertaService.removeOferta(id);
			return "redirect:/ofertas/listOfertasA";
		}
		
		@PreAuthorize("hasRole('ROLE_ALUMNO')")
		@GetMapping("/inscribir/{id}")
		public String inscribir(@PathVariable("id")int id)
		{
			OfertaModel oferta = ofertaService.findOferta(id);
			InscritoModel inscrito = new InscritoModel();
			inscrito.setOferta_id(oferta);
			
			String mail = SecurityContextHolder.getContext().getAuthentication().getName();
			UserModel user = userService.findStudentMail(mail);
			inscrito.setUsuario_id(user);
			
			String ld = LocalDate.now().toString();
			java.sql.Date date = java.sql.Date.valueOf(ld);
			System.out.println(date);
			inscrito.setFecha_inscripcion(date);
			
			inscritoService.addInscrito(inscrito);
			
			return "redirect:ofertas/listOfertasAlumno";
		}
	
}
