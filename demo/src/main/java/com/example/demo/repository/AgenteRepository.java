package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.*;

 @Repository 
public interface AgenteRepository extends JpaRepository<Agente,Integer> {

	 
	 	Optional<Agente>findByNombre(String nombre);
	 	boolean existsByNombre(String nombre);
	 		 	
	 	Optional<Agente>findByCodigo(String codigo);
	 	boolean existsByCodigo(String codigo);
	 	
	 	Optional<Agente>findBySdt(String sdt);
	 	boolean existsBySdt(String sdt);
	 		 	
	 	//buuscar agente por vias
	 	Optional<Agente>findByVias(int vias);
	 	boolean existsByVias(int vias);
	 	
	 	
	 	
}
