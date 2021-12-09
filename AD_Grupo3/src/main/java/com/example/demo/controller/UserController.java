package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.UserModel;
import com.example.demo.service.impl.UserService;
import com.example.demo.service.CicloService;


@Controller
@RequestMapping("/user")
public class UserController {
	private static  String USER_VIEW="User";
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("cicloService")
	private CicloService cicloService;
	
	@GetMapping(value={"/edit/","/edit/{id}"})
	public String formUser(@PathVariable (name="id", required=false) Integer id, Model model) {
		
		
		model.addAttribute("ciclos", cicloService.listAllCiclos());
		if(id==null) 
			model.addAttribute("user", new UserModel());
		else
			model.addAttribute("user", userService.findUserId(id));
		return USER_VIEW;
	}
	/*@PostMapping("/addUser")
	public String addStudent(@ModelAttribute("student")UserModel userModel,Model model)
	{
		if(userModel.getId()==0)
			userService.registrar(userModel);
		else
			userService.updateStudent(userModel);
		
		return "redirect:/students/listStudents";
	}*/
	
}
												 	 					