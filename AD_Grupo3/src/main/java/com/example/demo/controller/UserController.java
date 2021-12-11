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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;

import com.example.demo.models.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.cicloRepository;
import com.example.demo.service.impl.UserService;
import com.example.demo.service.CicloService;


@Controller
@RequestMapping("/user")
public class UserController {
	private static  String USER_VIEW="User";
	private static  String INDEX_VIEW="index";
	private static  String INDEXALU_VIEW="indexAlumnos";
	private static  String INDEXRRHH_VIEW="indexRRHH";
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
	public ModelAndView showRRHH() {
		ModelAndView mav = new ModelAndView(INDEXRRHH_VIEW);
		mav.addObject("users", userService.findStudentRole("ROLE_RRHH"));
	    return mav;
	}
	
	@GetMapping("/indexAlumnos")
	public ModelAndView showUser() {
		ModelAndView mav = new ModelAndView(INDEXALU_VIEW);
		mav.addObject("users", userService.findStudentRole("ROLE_ALUMNO"));
		mav.addObject("ciclos", cicloService.listAllCiclos());
	    return mav;
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
		String route="";
		if(userModel.getId()==0) {
			userService.registrar(userModel);
			if(userModel.getRole().equals("ROLE_ALUMNO")) {
				userRepository.save(userModel);
				route= "redirect:/user/indexAlumnos";
			}
			else {
				userRepository.save(userModel);
				route= "redirect:/user/indexRRHH";
			}
		}	
		else
			if(userModel.getRole().equals("ROLE_ALUMNO")) {
				userRepository.save(userModel);
				route= "redirect:/user/indexAlumnos";
			}
			else {
				userRepository.save(userModel);
				route= "redirect:/user/indexRRHH";
			}
				
		return route;
	}
	

	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") long id, Model model) {
		model.addAttribute("ciclos", cicloService.listAllCiclos());
	    User user = userRepository.findById(id);
	    model.addAttribute("user", user);
	    if(user.getRole().equals("ROLE_ALUMNO")) {
	    	
	    	return "UserEdit";
	    }
	    else {
	    	return "RRHHEdit";
	    }
	    	
	}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id")long id)
	{
		User user = userRepository.findById(id);
		userService.removeUser(id);
		if(user.getRole().equals("ROLE_ALUMNO")) {
			return "/user/indexAlumnos";
		}
		else {
			return "/user/indexRRHH";
		}
    		
	}

	
}
												 	 					