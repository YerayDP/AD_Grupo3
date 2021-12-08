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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Ciclo;
import com.example.demo.models.CicloModel;
import com.example.demo.service.CicloService;

@Controller
@RequestMapping("/ciclos")
public class CiclosController {
	
	private static  String CICLOS_VIEW="ciclos";
	private static  String FORM="Form_ciclos";

	@Autowired
	@Qualifier("cicloService")
	private CicloService cicloService;
	
	@GetMapping("/listCiclos")
	public ModelAndView listCiclos()
	{
		ModelAndView mav = new ModelAndView(CICLOS_VIEW);
		mav.addObject("ciclos", cicloService.listAllCiclos());
		return mav;
	}
	
	@PostMapping("/addCiclo")
	public String addCiclo(@ModelAttribute("ciclo")CicloModel CicloModel,Model model)
	{
		if(CicloModel.getId()==0)
			cicloService.addCiclo(CicloModel);
		else
			cicloService.updateCiclo(CicloModel);
		
		return "redirect:/ciclos/listCiclos";
	}
	
	@GetMapping(value={"/formCiclo/", "/formCiclo/{id}"})
	public String formCiclo(@PathVariable(name="id", required=false)Integer id,Model model)
	{
		if(id==null)
			model.addAttribute("ciclo",new Ciclo());
		else
			model.addAttribute("ciclo",cicloService.findCiclo(id));
		return FORM;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCiclo(@PathVariable("id")int id)
	{
		cicloService.removeCiclo(id);
		return "redirect:/ciclos/listCiclos";
	}
	
	
}
