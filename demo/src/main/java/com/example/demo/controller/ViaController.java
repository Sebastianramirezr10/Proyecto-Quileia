
package com.example.demo.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AgenteDto;
import com.example.demo.dto.Mensaje;
import com.example.demo.dto.ViasDto;
import com.example.demo.entity.Agente;
import com.example.demo.entity.Vias;
import com.example.demo.service.AgenteService;
import com.example.demo.service.ViasService;


@RestController
@RequestMapping("/via")
@CrossOrigin(origins = "http://localhost:4200")
public class ViaController {
	
	@Autowired
	ViasService ViasService;
	
	
	@GetMapping("/lista")
	public ResponseEntity<List<Vias>>list(){
		List<Vias> list = ViasService.List();
		return new ResponseEntity<List<Vias>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/detalle/{id}")	
	public ResponseEntity<Vias>getById(@PathVariable("id") int id) {
		 
		if(!ViasService.existsById(id)) 
			 return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		    Vias vias = ViasService.getOne(id).get();
			return new ResponseEntity<Vias>(vias,HttpStatus.OK);
			
			
					
					
	}
	
	
	//BUSCAR
	//BUSCAR TODOS LOS REGISTROS
			
			@GetMapping("/buscar/{numerovia}")
			public ResponseEntity<Object> search(@PathVariable("numerovia") int numerovia){
				
				return ResponseEntity.ok(this.ViasService.getByNumerovia(numerovia));
			}
			
			
	
	//--------------------------------------------------------------------------------------------///
	
	//CREACION
		@PostMapping("/crear")
		public  ResponseEntity<?> create(@RequestBody ViasDto viasDto){
			//COMPROBAR QUE NO HAYAN CAMPOS EN BLANCO
			
			if(StringUtils.isBlank(viasDto.getTipo_via()))
				return new ResponseEntity(new Mensaje("El tipo de la via Es Obligatirio"),HttpStatus.BAD_REQUEST);
									
			if(StringUtils.isBlank(viasDto.getDireccion()))
				return new ResponseEntity(new Mensaje("La Direccion calle/carrera es Obligatoria"),HttpStatus.BAD_REQUEST);
			
			if(viasDto.getNumerovia()==null || viasDto.getNumerovia()<=0  )
				return new ResponseEntity(new Mensaje("El identificador es obligatorio digite un numero 1 en adelante"),HttpStatus.BAD_REQUEST);
						
			if(viasDto.getCongestion() == null || viasDto.getCongestion()<=0 || viasDto.getCongestion()>=101 )
				return new ResponseEntity(new Mensaje("La congestion tiene que ser entre 0 y 100"),HttpStatus.BAD_REQUEST);
			
		
			
			
			
			
			//Comprobar si existe
			
			if(ViasService.existsByNumerovia(viasDto.getNumerovia()))
				return new ResponseEntity(new Mensaje("Este numero ya Existe"),HttpStatus.BAD_REQUEST);		
			
			
			//CREACION
			
			Vias vias = new  Vias(viasDto.getTipo_via(),viasDto.getDireccion(),viasDto.getNumerovia(),viasDto.getCongestion());		
			ViasService.save(vias);
				return new  ResponseEntity(new Mensaje("Via Grabada Con Exito!"), HttpStatus.OK);
		
		}
		
		
		//**********************************************************************************************************************/
			
		
		
		
		//UPDATE
		
		
		@PutMapping("/update/{id}")		
		public  ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ViasDto viasDto){
			
			//VALIDAR QUE EL ID EXISTA
			if(!ViasService.existsById(id)) 
				 return new ResponseEntity(new Mensaje("No Existe El registro"), HttpStatus.NOT_FOUND);
		//validar que no hayan repetidos
		if(ViasService.existsByNumerovia(viasDto.getNumerovia()) && ViasService.getByNumerovia(viasDto.getNumerovia()).get().getId() !=id)
			return new ResponseEntity(new Mensaje("el numero de la via ya existe cree uno nuevo"),HttpStatus.BAD_REQUEST);
		
		//COMPROBAR QUE NO HAYAN CAMPOS EN BLANCO
		if(StringUtils.isBlank(viasDto.getTipo_via()))
			return new ResponseEntity(new Mensaje("El tipo de la via Es Obligatirio"),HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(viasDto.getDireccion()))
			return new ResponseEntity(new Mensaje("La Direccion calle/carrera es Obligatoria"),HttpStatus.BAD_REQUEST);
		
		if(viasDto.getNumerovia()==null || viasDto.getNumerovia()<=0  )
			return new ResponseEntity(new Mensaje("El identificador es obligatorio digite un numero 1 en adelante"),HttpStatus.BAD_REQUEST);
		
		if(viasDto.getCongestion() == null || viasDto.getCongestion()<=0 || viasDto.getCongestion()>=101 )
			return new ResponseEntity(new Mensaje("La congestion tiene que ser entre 0 y 100"),HttpStatus.BAD_REQUEST);
		
		
		Vias vias =  ViasService.getOne(id).get();
		vias.setTipo_via(viasDto.getTipo_via());
		vias.setDireccion(viasDto.getDireccion());
		vias.setNumerovia(viasDto.getNumerovia());
		vias.setCongestion(viasDto.getCongestion());
		
		
		ViasService.save(vias);
		return new ResponseEntity(new Mensaje("Via Actualizada con Exito!"),HttpStatus.OK);	
		
		
		
		
		}
		
		//**************************************************************************************************///
		
		
		//ELIMINAR
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?> delete(@PathVariable("id")int id){
			//validar si existe por id
					if(!ViasService.existsById(id)) 
				return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
					ViasService.delete(id);
				return new ResponseEntity(new Mensaje("Via Eliminada Con Exito!"), HttpStatus.OK);
			
		}
		
		
	
	

}
