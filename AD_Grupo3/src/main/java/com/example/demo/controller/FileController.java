package com.example.demo.controller;

import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.upload.*;
@ComponentScan("com.example.upload")
@Controller
public class FileController {
	
	@Autowired 
	@Lazy
	private StorageService storageService;
	
	@GetMapping("files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename){
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().body(file);
	}

}
