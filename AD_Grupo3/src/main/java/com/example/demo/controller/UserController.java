package com.example.demo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.models.UserModel;
import com.example.demo.service.impl.UserService;
import com.example.demo.service.CicloService;
import com.example.demo.service.NoticiaService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static  String INDEXALU_VIEW="indexAlumnos";
	private static  String INDEXRRHH_VIEW="indexRRHH";
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("cicloService")
	private CicloService cicloService;
	
	/*@Autowired
	@Qualifier("noticiaService")
	private NoticiaService noticiaService;*/
	
	@GetMapping("/")
	public ModelAndView Volver(Authentication auth,HttpSession session)
	{	    
		ModelAndView mav = new ModelAndView();
		//mav.addObject("noticias", noticiaService.listAllNoticias());
	            String username = auth.getName();

	            if(session.getAttribute("usuario")==null) {

	                UserModel usuario = userService.findStudentMail(username);

	                if(usuario.isActivo()==false)
	                	mav.setViewName("login");
	                    return mav;
	            }
	            mav.setViewName("index");
	            return mav;
	}
	 
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/indexRRHH")
	public ModelAndView showRRHH() {
		ModelAndView mav = new ModelAndView(INDEXRRHH_VIEW);
		mav.addObject("users", userService.findStudentRole("ROLE_RRHH"));
	    return mav;
	}
	@GetMapping("/addRRHH")
	public String addRRHH(@ModelAttribute("user")User User,Model model,
			@Valid User user, BindingResult result)
	{
		if (result.hasErrors()) {
			return "RRHHEdit";
		}
		return "redirect:/user/indexRRHH";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
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
	    model.addAttribute("users", userService.findStudentMail(id));
	    return "profile";
	}
	
	@PostMapping("/update/{id}")
	public String addStudent(UserModel userModel, User user)
	{
		String id= SecurityContextHolder.getContext().getAuthentication().getName();
		UserModel userM=userService.findStudentMail(id);
		String route="";
		if(userM.getRole().equals("ROLE_ADMIN")) {
			if(user.getId()==0) {
					
					userService.registrarRRHH(user);
					route= "redirect:/user/indexRRHH";
				}
			else {
				userService.updateUser(userModel);
				if(user.getRole().equals("ROLE_ALUMNO")) {
					
					route= "redirect:/user/indexAlumnos";
				}
				else {
					route= "redirect:/user/indexRRHH";
				}
			}
		}
			
		else if(userM.getRole().equals("ROLE_RRHH")){
			
				userService.updateUser(userModel);
				route= "redirect:/user/index";

		}
		else {
			userService.updateUser(userModel);
			route= "redirect:/user/index";
		}
		return route;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/activate/{id}")
	public String activateUser(@PathVariable("id")long id)
	{
		UserModel user = userService.findStudentId(id);
		user.setActivo(true);
		userService.updateUser(user);
		if(user.getRole().equals("ROLE_ALUMNO")) {
			
			return "redirect:/user/indexAlumnos";
		}
		else {
			return "redirect:/user/indexRRHH";
		}
	

	
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/deactivate/{id}")
	public String deactivateUser(@PathVariable("id")long id)
	{ 
		UserModel user = userService.findStudentId(id);
		user.setActivo(false);
		userService.updateUser(user);
		if(user.getRole().equals("ROLE_ALUMNO")) { 
			
			return "redirect:/user/indexAlumnos";
		}
		else {
			return "redirect:/user/indexRRHH";
		}
	
	}
	
	
	@GetMapping(value={"/edit","/edit/{id}"})
	public String edit(@PathVariable("id") long id, Model model) {
		model.addAttribute("ciclos", cicloService.listAllCiclos());
	    UserModel user = userService.findStudentId(id);
	    model.addAttribute("user", user);
	    
	    user.setPassword("");
	    if(user.getRole().equals("ROLE_ALUMNO")) {
	    	
	    	return "UserEdit";
	    }
	    else {
	    	return "RRHHEdit";
	    }
	    	
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id")long id)
	{
		UserModel user = userService.findStudentId(id);
		
		if(user.getRole().equals("ROLE_ALUMNO")) {
			userService.removeUser(id);
			return "redirect:/user/indexAlumnos";
		}
		else {
			userService.removeUser(id);
			return "redirect:/user/indexRRHH";
		}
    		
	}

	
}
												 	 					