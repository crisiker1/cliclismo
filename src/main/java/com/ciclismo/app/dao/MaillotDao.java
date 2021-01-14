package com.ciclismo.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ciclismo.app.models.Maillot;



public interface MaillotDao extends JpaRepository<Maillot, Long>{
	
	

}
