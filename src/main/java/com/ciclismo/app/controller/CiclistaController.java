package com.ciclismo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclismo.app.service.CiclistaService;
import com.ciclismo.app.AppCiclismoApplication;
import com.ciclismo.app.models.Ciclista;

@Controller
public class CiclistaController {
	
	@Autowired
	private CiclistaService ciclistaService;
	
	@GetMapping("/todos")
	public List<Ciclista> todos(){
		return ciclistaService.findAll();
	}

	
}
