package com.ab.springboot.reto.backend.sophos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tests")
public class Tests {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String description;
	
	public Tests() {
		super();
	}

	public Tests(Integer id, String nombre, String description) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.description = description;
	}

	public Tests(String nombre, String description) {
		super();
		this.nombre = nombre;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescrition(String description) {
		this.description = description;
	}
	
	
}
