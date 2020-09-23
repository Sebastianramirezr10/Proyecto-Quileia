package com.example.demo.entity;


import javax.persistence.*;








@Entity
@Table(name = "agente")
public class Agente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
		
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "exp")
	private float exp;
	
	@Column(name = "sdt")
	private String sdt;
	
	
	@Column(name = "vias")
	private int vias;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "numerovia")
	private Vias rel_vias;
	
	
	
	
	public Agente() {
		
	}

	public Agente(String nombre, String apellido, String codigo, float exp, String sdt, int vias) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigo = codigo;
		this.exp = exp;
		this.sdt = sdt;
		this.vias = vias;
	}

	
	

	

	public Vias getRel_vias() {
		return rel_vias;
	}

	public void setRel_vias(Vias rel_vias) {
		this.rel_vias = rel_vias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getExp() {
		return exp;
	}

	public void setExp(float exp) {
		this.exp = exp;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	

	public int getVias() {
		return vias;
	}

	public void setVias(int vias) {
		this.vias = vias;
	}

	

	
	
	

	
	
	}
	
	
	

