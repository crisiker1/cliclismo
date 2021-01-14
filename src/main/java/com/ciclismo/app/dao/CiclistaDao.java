package com.ciclismo.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciclismo.app.models.Ciclista;


@Repository
public interface CiclistaDao extends JpaRepository<Ciclista, Long>{
	
	

}
