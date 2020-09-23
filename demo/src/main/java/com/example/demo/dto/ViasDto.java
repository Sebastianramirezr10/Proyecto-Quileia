package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ViasDto {
	
	@NotBlank
	private String tipo_via;
	@NotBlank
	private String direccion;
	@Min(0)
	private Integer numerovia;
	@Min(0)
	private Float congestion;
	
	
	public ViasDto() {
		
	}


	public ViasDto(@NotBlank String tipo_via, @NotBlank String direccion, @Min(0) Integer numerovia,
			@Min(0) Float congestion) {
		super();
		this.tipo_via = tipo_via;
		this.direccion = direccion;
		this.numerovia = numerovia;
		this.congestion = congestion;
	}


	
	
	//TIPO DE VIA
	public String getTipo_via() {
		return tipo_via;
	}


	public void setTipo_via(String tipo_via) {
		this.tipo_via = tipo_via;
	}

	//DIRECCION
	public String getDireccion() {
		return direccion;
	}

	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	//NUMERO DE LA VIA
	public Integer getNumerovia() {
		return numerovia;
	}


	public void setNumerovia(Integer numerovia) {
		this.numerovia = numerovia;
	}

	//CONGESTION
	public Float getCongestion() {
		return congestion;
	}


	public void setCongestion(Float congestion) {
		this.congestion = congestion;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
