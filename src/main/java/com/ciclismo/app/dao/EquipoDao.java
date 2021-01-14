package com.ciclismo.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ciclismo.app.models.Equipo;



public interface EquipoDao extends JpaRepository<Equipo, Long>{
	
	

}
