package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.entity.User;

import com.example.demo.models.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserService;
import com.example.demo.service.CicloService;


@Controller
@RequestMapping("/user")
public class UserController {
	private static  String USER_VIEW="User";
	private static  String INDEX_VIEW="index";
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("cicloService")
	private CicloService cicloService; 
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String Volver() {
	    return "index";
	}
	
	@GetMapping("/indexRRHH")
	public String showRRHH(Model model) {
		String id= SecurityContextHolder.getContext().getAuthentication().getName();
	    model.addAttribute("users", userRepository.findByEmail(id));
	    return "profile";
	}
	
	@GetMapping("/indexAlumnos")
	public String showUser(Model model) {
		String id= SecurityContextHolder.getContext().getAuthentication().getName();
	    model.addAttribute("users", userRepository.findByEmail(id));
	    return "profile";
	}
	
	@GetMapping("/index")
	public String show(Model model) {
		String id= SecurityContextHolder.getContext().getAuthentication().getName();
	    model.addAttribute("users", userRepository.findByEmail(id));
	    return "profile";
	}
	
	@PostMapping("/update/{id}")
	public String addStudent(@ModelAttribute("user")User userModel,Model model)
	{
		if(userModel.getId()==0)
			userService.registrar(userModel);
		else
			userRepository.save(userModel);
		
		return "redirect:/user/index";
	}
	

	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("ciclos", cicloService.listAllCiclos());
	    User user = userRepository.findById(id);
	    model.addAttribute("user", user);
	    return "User";
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
												 	 					