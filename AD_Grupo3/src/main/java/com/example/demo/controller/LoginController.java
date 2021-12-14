package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.service.CicloService;
import com.example.demo.service.impl.UserService;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("cicloService")
	private CicloService cicloService;
	
	@GetMapping("/auth/login")
	public String login(Model model, @RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout, RedirectAttributes flash)
	{
		model.addAttribute("user",new User());
		model.addAttribute("error",error);
		flash.addFlashAttribute("success", "Sesión cerrada correctamente");
		model.addAttribute("logout",logout);
		return "login";
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
	
}
