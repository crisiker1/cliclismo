package com.ciclismo.app;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ciclismo.app.models.Ciclista;
import com.ciclismo.app.service.CiclistaService;



@SpringBootApplication
public class AppCiclismoApplication{
	

	
	
	public static void main(String[] args) {
		SpringApplication.run(AppCiclismoApplication.class, args);

        
		//System.out.println("dale: " + c.findAll().size());
	}
	
	
	



}




