package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlumnoController {

	
	@GetMapping("/")
	public String inicio() {
		return "index";
	}

	@GetMapping("/A")
	public String inicioA() {
		return "Alumno";
	}
}
