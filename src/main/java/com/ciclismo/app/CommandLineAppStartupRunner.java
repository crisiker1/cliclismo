package com.ciclismo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ciclismo.app.service.CiclistaService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private CiclistaService c;

    @Override
    public void run(String[] args) throws Exception {
    	for(int i=0; i<c.findAll().size(); i++) {
    		System.out.println("Ciclista: " + i + "-----" + c.findAll().get(i).getNombre());
    	}
       

    }
}