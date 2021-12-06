package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.demo.models.UserModel;
import com.example.demo.service.impl.UserService;
import com.example.demo.service.CicloService;


@Controller
public class UserController {
	private static  String USER_VIEW="User";
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("cicloService")
	private CicloService cicloService;
	
	@GetMapping(value={"user/edit/","user/edit/{id}"})
public String formUser(@PathVariable (name="id", required=false) Integer id, Model model) {
		
		
		model.addAttribute("ciclo", cicloService.listAllCiclos());
		if(id==null) {
			model.addAttribute("user", new UserModel());
		}
		else
			model.addAttribute("user", userService.findUserId(id));
		return USER_VIEW;
	}
	
}
												 	 					