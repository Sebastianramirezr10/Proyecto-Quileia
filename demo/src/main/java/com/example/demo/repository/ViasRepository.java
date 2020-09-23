package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Vias;

@Repository
public interface ViasRepository extends JpaRepository<Vias,Integer>{
	
		Optional<Vias>findByNumerovia(int numerovia);
		boolean existsByNumerovia(int numerovia);
		
		
				
	

}
