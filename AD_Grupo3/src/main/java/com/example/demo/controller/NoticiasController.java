package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties.Storage;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.example.demo.entity.Ciclo;
import com.example.demo.entity.Noticia;
import com.example.demo.entity.User;
import com.example.demo.models.CicloModel;
import com.example.demo.models.NoticiaModel;
import com.example.demo.models.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CicloService;
import com.example.demo.service.NoticiaService;
import com.example.demo.service.impl.UserService;
import com.example.upload.*;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	private static  String NOTICIAS_VIEW="noticias";
	private static  String FORM="Form_noticias";

	@Autowired
	private NoticiaService noticiaService;
	
	@Autowired
	private CicloService CicloService;
	@Autowired
	private UserService UserService;
	
	@Autowired 
	@Lazy
	private StorageService storageService;
	
	@GetMapping("/listNoticia")
	public String listCiclos(Model model)
	{
		
		
		model.addAttribute("noticias", noticiaService.listAllNoticias());
		return NOTICIAS_VIEW;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addNoticia")
	public String addNoticia(@ModelAttribute("noticia")NoticiaModel NoticiaModel,Model model,
	         @RequestParam(value = "file")  MultipartFile file)
	{
		if(NoticiaModel.getId()==0) {
			String imagen=null;
			String[] path=null;
			
			imagen = storageService.store(file, NoticiaModel.getId());
			path = MvcUriComponentsBuilder.fromMethodName
					(FileController.class, "serveFile", imagen).build().toUriString().split("/");
			
			NoticiaModel.setImagen(path[path.length-1]);
			noticiaService.addNoticia(NoticiaModel);
		}
			
		else {
			String imagen=null;
			String[] path=null;
			
			imagen = storageService.store(file, NoticiaModel.getId());
			path = MvcUriComponentsBuilder.fromMethodName
					(FileController.class, "serveFile", imagen).build().toUriString().split("/");
			
			NoticiaModel.setImagen(path[path.length-1]);
			noticiaService.updateNoticia(NoticiaModel);
		}
			
			
		return "redirect:/noticias/listNoticia";
	}
	

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value={"/formNoticia/", "/formNoticia/{id}"})
	public String formNoticia(@PathVariable(name="id", required=false)Integer id,Model model)
	{
		if(id==null)
			model.addAttribute("noticia",new Noticia());
		else
			model.addAttribute("noticia",noticiaService.findNoticia(id));
		return FORM;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteNoticia(@PathVariable("id")int id)
	{
		noticiaService.removeNoticia(id);
		return "redirect:/noticias/listNoticia";
	}
	
}
