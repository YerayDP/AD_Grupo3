package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.UserModel;
import com.example.demo.service.impl.UserService;

public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	/*@GetMapping(value={"user/edit/","user/edit/{id}"})
public String formUser(@PathVariable (name="id", required=false) Integer id, Model model) {
		
		if(id==null) {
			model.addAttribute("user", new UserModel());
		}
		else
			//model.addAttribute("user", userService.findUserId(id));
		return "redirect:/user/edit";
	}
	*/
}
												 						