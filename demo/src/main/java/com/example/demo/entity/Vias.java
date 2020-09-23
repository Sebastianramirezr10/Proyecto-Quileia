package com.example.demo.entity;


import javax.management.relation.Relation;
import javax.persistence.*;

@Entity

public class Vias {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	
	@Column(name = "tipo_via")
	private String tipo_via;
	
	@Column(name = "direccion")
	private String direccion;	
	
	
	@Column(name = "numerovia")
	private int numerovia;
		
	@Column(name = "congestion")
	private float congestion;
	
	public Vias() {
		
	}

	public Vias(String tipo_via, String direccion, int numerovia, float congestion) {
		
		this.tipo_via = tipo_via;
		this.direccion = direccion;
		this.numerovia = numerovia;
		this.congestion = congestion;
	}

	
	//ID V
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//TIPO DE VIA AUTOPISTA ETC

	public String getTipo_via() {
		return tipo_via;
	}

	public void setTipo_via(String tipo_via) {
		this.tipo_via = tipo_via;
	}

	//DIRECCION CALLE O CARRERA
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	//NUMERO DE LA CALLE O CARRERA
	public int getNumerovia() {
		return numerovia;
	}

	public void setNumerovia(int numerovia) {
		this.numerovia = numerovia;
	}
	
	
	//NIVEL DE CONGESTION 
	public float getCongestion() {
		return congestion;
	}

	public void setCongestion(float congestion) {
		this.congestion = congestion;
	}
	
	
	


	}
	
	
	

