package com.example.demo.dto;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

import java.io.Serializable;

@Data
public class AgenteDto implements Serializable {
	
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	private String codigo;
	@Min(0)
	private Float exp;
	@NotBlank
	private String sdt;
	@Min(1)
	private Integer vias;
	
	
	
	public AgenteDto() {
		
	}
	
	
	

	public AgenteDto(String nombre, String apellido, String codigo, @Min(0) Float exp, String sdt,
			@Min(0) Integer vias) {
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigo = codigo;
		this.exp = exp;
		this.sdt = sdt;
		this.vias = vias;
	}





	//NOMBRE
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	//APELLIDO
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	//CODIGO
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	//EXPERIENCIA 

	public Float getExp() {
		return exp;
	}





	public void setExp(Float exp) {
		this.exp = exp;
	}

	


	//SDT
	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	//VIAS
	public Integer getVias() {
		return vias;
	}





	public void setVias(Integer vias) {
		this.vias = vias;
	}
		
	
	
	
	
	
	
	
}
