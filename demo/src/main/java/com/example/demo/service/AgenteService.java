package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AgenteDto;
import com.example.demo.entity.Agente;
import com.example.demo.repository.AgenteRepository;
import com.example.demo.repository.ViasRepository;


@Service
@Transactional
public class AgenteService {
	
	@Autowired
	AgenteRepository agenteRepository;
		
	@Autowired
	ViasRepository viasRepository;
	
	
	//trae todos los elementos de repositorio
	public List<Agente>List(){
		return agenteRepository.findAll();
	}
	
	
	//obtener POR ID
	public Optional<Agente> getOne(int id){
		return  agenteRepository.findById(id);
	}
	//por nombre
	public Optional<Agente> getByNombre(String nombre){
		return  agenteRepository.findByNombre(nombre);
	}
	//por codigo
	public Optional<Agente> getByCodigo(String codigo){
		return  agenteRepository.findByCodigo(codigo);
	}
	//por sdt
	public Optional<Agente> getBySdt(String sdt){
		return  agenteRepository.findBySdt(sdt);
	}
	
	
	//BUSQUEDA POR LA VIA
	public Optional<Agente>getByVias(int vias){
		return agenteRepository.findByVias(vias);
		
	}
		
	
	
	//GRABAR
	public void save(Agente agente) {
		 agenteRepository.save(agente);
	}
	
	//ELIMINACION
	public void delete(int id) {
		agenteRepository.deleteById(id);
	}
	
	
	
	
	//COMPROBAR SI EXISTE
	public boolean existsById(int id) {
		return agenteRepository.existsById(id);
	}
	
	public boolean existsByNombre(String nombre) {
		return agenteRepository.existsByNombre(nombre);
	}
	public boolean existsByCodigo(String codigo) {
		return agenteRepository.existsByCodigo(codigo);
	}
	public boolean existsBySdt(String sdt) {
		return agenteRepository.existsBySdt(sdt);
	}
	public boolean existsByVias(int vias) {
		return agenteRepository.existsByVias(vias);
	}
	
	
	
	
	
}
	
	
	

