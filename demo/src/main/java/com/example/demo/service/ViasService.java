package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vias;

import com.example.demo.repository.ViasRepository;

@Service
@Transactional
public class ViasService {
	
	@Autowired
	ViasRepository viasRepository;
	//trae todos los elementos de repositorio
		
	public List<Vias>List(){
			return viasRepository.findAll();
			}
	
		//busqueda por id
		public Optional<Vias> getOne(int id){
			return  viasRepository.findById(id);
			
			
		}
		
		//busqueda por NUMERO DE LA VIA AGENTE/VIAS
		public Optional<Vias> getByNumerovia(int numerovia){
			return  viasRepository.findByNumerovia(numerovia);
		}
		
			
		
		
		//GRABAR VIA
		public void save(Vias via) {
			 viasRepository.save(via);
		}
		
		//ELIMINACION
		public void delete(int id) {
			viasRepository.deleteById(id);
		}
		
		
		
		//COMPROBAR SI EXISTE
		
		public boolean existsById(int id) {
			return viasRepository.existsById(id);
		}
		
		
		public boolean existsByNumerovia(int numerovia) {
			return viasRepository.existsByNumerovia( numerovia);
		}
		
		
		
		
		
		
		
		
		
		
		

}
