package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.User;
import com.example.demo.models.NoticiaModel;
import com.example.demo.models.UserModel;
import com.example.demo.service.CicloService;
import com.example.demo.service.NoticiaService;
import com.example.demo.service.impl.UserService;

@Controller
public class LoginController {

	private static  String INDEX="index";
	private static  String LOGIN="login";
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("cicloService")
	private CicloService cicloService;
	
	@Autowired
	@Qualifier("NoticiaService")
	private NoticiaService noticiaService;
	
	
	private int But=0;	
	@GetMapping("/auth/login")
	public ModelAndView login(Model model, @RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout, RedirectAttributes flash)
	{
		ModelAndView mav = new ModelAndView();
		if(logout != null)
		{
			//model.addAttribute("user",new User());
			//flash.addFlashAttribute("success", "Sesión cerrada correctamente");
			mav.addObject("msg", "Sesion cerrada correctamente.");
		
		}
		mav.setViewName("login");
		return mav;
	}
	
	@GetMapping("/auth/registerForm")
	public ModelAndView registerForm(Model model)
	{
		ModelAndView mav = new ModelAndView("registro");
		model.addAttribute("user",new User());
		mav.addObject("ciclos", cicloService.listAllCiclos());
		return mav;
	}
	
	@PostMapping("auth/register")
	public String register(@ModelAttribute User user,RedirectAttributes flash) {
		userService.registrar(user);
		flash.addFlashAttribute("sucess","User registered");
		return "redirect:/auth/login";
	}
	@GetMapping("/")
	public String showRRHH(Model model) {
		But=0;
		if( !SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser") && But==0) {
			model.addAttribute("noticias",showList());
			model.addAttribute("boton",But);
		}
		else
			return "redirect:/auth/login";
	    return INDEX;
		
	}
	@GetMapping("/1")
	public String showRRHH1(Model model) {
		But=1;
		if( !SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser") && But==1) {
			model.addAttribute("noticias",showListAll());
			model.addAttribute("boton",But);
		}
		else
			return "redirect:/auth/login";
	    return INDEX;
		
	}
	public List<NoticiaModel> showList() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserModel user = userService.findStudentMail(username);
		int user2 = user.getCiclo().getId();
		
		Ciclo ciclo =cicloService.findCicloById(user2);
		System.out.println(ciclo.getNombre());
		System.out.println(cicloService.listByCiclo(ciclo));
		List<NoticiaModel>Noticias=cicloService.listByCiclo(ciclo);
		return Noticias;
	}
	public List<NoticiaModel> showListAll() {
		
		List<NoticiaModel>Noticias=noticiaService.listAllNoticias();
		return Noticias;
	}
	
}
