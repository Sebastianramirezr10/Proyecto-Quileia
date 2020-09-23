package com.example.demo.controller;

import java.util.List;

import javax.validation.constraints.Null;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AgenteDto;
import com.example.demo.dto.Mensaje;
import com.example.demo.dto.ViasDto;
import com.example.demo.entity.Agente;
import com.example.demo.entity.Vias;
import com.example.demo.service.AgenteService;
import com.example.demo.service.ViasService;








@RestController
@RequestMapping("/agentes")
@CrossOrigin(origins = "http://localhost:4200")

public class AgenteController {
	
	@Autowired
	AgenteService AgenteService;
	@Autowired
	ViasService ViasService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Agente>>list(){
		List<Agente> list = AgenteService.List();
		return new ResponseEntity<List<Agente>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Agente>getById(@PathVariable("id") int id) {
		 
		if(!AgenteService.existsById(id)) 
			 return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		    Agente agente = AgenteService.getOne(id).get();
			return new ResponseEntity<Agente>(agente,HttpStatus.OK);
					
					
	}
	
	
	
	
	//--------------------------------------------------------------------------------------------///
	
	//CREACION
	@PostMapping("/create")
	public  ResponseEntity<?> create(@RequestBody AgenteDto agenteDto){
		
		
		//COMPROBAR QUE NO HAYAN CAMPOS EN BLANCO
		if(StringUtils.isBlank(agenteDto.getNombre()))
			return new ResponseEntity(new Mensaje("El Nombre Es Obligatirio"),HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(agenteDto.getApellido()))
			return new ResponseEntity(new Mensaje("El Apellido Es Obligatirio"),HttpStatus.BAD_REQUEST);
			
		if(StringUtils.isBlank(agenteDto.getCodigo()))
			return new ResponseEntity(new Mensaje("El Codigo Es Obligatirio"),HttpStatus.BAD_REQUEST);
				
		if(AgenteService.existsByCodigo(agenteDto.getCodigo()))
			return new ResponseEntity(new Mensaje("El codigo ya Existe"),HttpStatus.BAD_REQUEST);
		
		if(agenteDto.getExp()==null || agenteDto.getExp()<=0  )
			return new ResponseEntity(new Mensaje("La Experiencia debe ser un numero real"),HttpStatus.BAD_REQUEST);
			
		if(StringUtils.isBlank(agenteDto.getSdt()))
			return new ResponseEntity(new Mensaje("El codigo de el sistema de transporte Es Obligatirio"),HttpStatus.BAD_REQUEST);
		
		if(AgenteService.existsBySdt(agenteDto.getSdt()))
			return new ResponseEntity(new Mensaje("El codigo sdt ya Existe"),HttpStatus.BAD_REQUEST);
		
			
		if(agenteDto.getVias()==null || agenteDto.getVias()<=0)
			return new ResponseEntity(new Mensaje("No existe ninguna  Via 0 o negativa coloque una via correcta"),HttpStatus.BAD_REQUEST);

		if(AgenteService.existsByVias(agenteDto.getVias()))
			return new ResponseEntity(new Mensaje("Esta via Ya Esta Asignada"),HttpStatus.BAD_REQUEST);
		
		
		/*if(AgenteService.existsByVias(agenteDto.getVias()) == ViasService.existsByNumerovia(viasDto.getNumerovia()) && 
				(viasDto.getCongestion() >=30 &&  viasDto.getCongestion() >=100));
		return new ResponseEntity(new Mensaje("Via DE Alta Congestion"),HttpStatus.BAD_REQUEST);*/
		
									
					//CREACION
		
			
				
		Agente agente = new  Agente(agenteDto.getNombre(), agenteDto.getApellido(),agenteDto.getCodigo(),
				agenteDto.getExp(),agenteDto.getSdt(),agenteDto.getVias());
			
			AgenteService.save(agente);
			
			return new  ResponseEntity(new Mensaje("Agente Grabado Con Exito!"), HttpStatus.OK);
	
	}
	
	
	
	
	
	//----------------------------------------------------------------------------------------///
	
	//UPDATE
	@PutMapping("/update/{id}")		
	public  ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody AgenteDto agenteDto){
		//VALIDAR QUE EL ID EXISTA
		if(!AgenteService.existsById(id)) 
			 return new ResponseEntity(new Mensaje("No Existe El registro"), HttpStatus.NOT_FOUND);
		
		//VALIDACION DE CODIGO Y SDT PARA COMPROBAR SI EXISTE EN OTRO REGISTRO	
		if(AgenteService.existsByCodigo(agenteDto.getCodigo()) && AgenteService.getByCodigo(agenteDto.getCodigo()).get().getId() !=id)
			return new ResponseEntity(new Mensaje("Ese Codigo de Agente ya Existe"),HttpStatus.BAD_REQUEST);
		
		if(AgenteService.existsBySdt(agenteDto.getSdt()) && AgenteService.getBySdt(agenteDto.getSdt()).get().getId() !=id)
			return new ResponseEntity(new Mensaje("Ese Codigo de la Secretaria de transporte ya Existe"),HttpStatus.BAD_REQUEST);
		
		//VALIDAR QUE NO HAYA CAMPOS EN BLANCO NI NUMEROS NEGATIVOS
		if(StringUtils.isBlank(agenteDto.getNombre()))
			return new ResponseEntity(new Mensaje("El Nombre Es Obligatirio"),HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(agenteDto.getApellido()))
			return new ResponseEntity(new Mensaje("El Apellido Es Obligatirio"),HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(agenteDto.getCodigo()))
			return new ResponseEntity(new Mensaje("El Codigo de Agente Es Obligatirio"),HttpStatus.BAD_REQUEST);
		
		if(agenteDto.getExp()==null || agenteDto.getExp()<=0  )
			return new ResponseEntity(new Mensaje("La Experiencia debe ser un numero Real"),HttpStatus.BAD_REQUEST);
				
		if(StringUtils.isBlank(agenteDto.getSdt()))
			return new ResponseEntity(new Mensaje("El Codigo de La Secretaria de Transito Es Obligatirio"),HttpStatus.BAD_REQUEST);
		
		if(agenteDto.getVias()==null || agenteDto.getVias()<=0)
			return new ResponseEntity(new Mensaje("No Existen Vias negativas debe ser 0 o mayor"),HttpStatus.BAD_REQUEST);
		
		if(AgenteService.existsByVias(agenteDto.getVias()))
			return new ResponseEntity(new Mensaje("Esta via Ya Esta Asignada"),HttpStatus.BAD_REQUEST);
						
		
		
		//obtengo agente por el id y actualizo
		Agente agente =  AgenteService.getOne(id).get();
		agente.setNombre(agenteDto.getNombre());
		agente.setApellido(agenteDto.getApellido());
		agente.setCodigo(agenteDto.getCodigo());
		agente.setExp(agenteDto.getExp());
		agente.setSdt(agenteDto.getSdt());
		agente.setVias(agenteDto.getVias());
		
		AgenteService.save(agente);
		return new ResponseEntity(new Mensaje("Agente Actualizado con Exito!"),HttpStatus.OK);
				
		
	}
		
	
	
	
	
	
	//**************************************************************************************************///
	
	
	//ELIMINAR
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		//validar si existe por id
				if(!AgenteService.existsById(id)) 
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
				AgenteService.delete(id);
			return new ResponseEntity(new Mensaje("Agente Eliminado Con Exito!"), HttpStatus.OK);
		
	}
	
	
	

}
