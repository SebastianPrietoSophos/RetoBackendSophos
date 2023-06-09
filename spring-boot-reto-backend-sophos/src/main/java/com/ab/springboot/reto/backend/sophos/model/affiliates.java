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
@Table(name = "affiliates")
public class affiliates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private Integer age;
	private String mail;
	
	public affiliates() {
		super();
	}

	public affiliates(Integer id, String nombre, Integer age, String mail) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.age = age;
		this.mail = mail;
	}

	public affiliates(String nombre, Integer age, String mail) {
		super();
		this.nombre = nombre;
		this.age = age;
		this.mail = mail;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
		
}
