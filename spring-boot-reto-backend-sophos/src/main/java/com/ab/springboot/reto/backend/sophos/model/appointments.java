package com.ab.springboot.reto.backend.sophos.model;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity  //objetos de persistencia que se almacenan como registro en la base de datos
@Table(name = "appointments")
public class appointments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Id auto-generado
	private Integer id;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name = "date_a")
	@JsonFormat(pattern="dd-MM-yyyy")
	private  LocalDate date; //(date y hour puede ocacionar problema porque son palabras clave de oracle)
	                         // date no funcionó, se usó LocalDate
	//format time
	@Column(name = "hour_a")
	@DateTimeFormat(pattern="HH24:MI")
	@JsonFormat(pattern="HH24:MI")
	private Time hour;
	
	@ManyToOne(cascade=CascadeType.DETACH) // Entity relationship
	                   //(the child entity will also get removed from the persistent context.)
	@Basic(fetch=FetchType.EAGER) //fetch=buscar, eager cargar todos los campos de la entidad hija
	@OnDelete(action = OnDeleteAction.CASCADE) // Para poder borrar el campo en la padre
	                   // No tener problema con las foreign keys.
	@JoinColumn(name = "id_test")
	private Tests tests;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	@Basic(fetch=FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "id_affiliate")
	private affiliates affiliates;

	//Constructores getters y setters
	public appointments() {
		super();
	}

	public appointments(LocalDate date, Time hour, Tests tests, affiliates affiliates) {
		super();
		this.date = date;
		this.hour = hour;
		this.tests = tests;
		this.affiliates = affiliates;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Time getHour() {
		return hour;
	}

	public void setHour(Time hour) {
		this.hour = hour;
	}

	public Tests getTests() {
		return tests;
	}

	public void setTests(Tests tests) {
		this.tests = tests;
	}

	public affiliates getAffiliates() {
		return affiliates;
	}

	public void setAffiliates(affiliates affiliates) {
		this.affiliates = affiliates;
	}
	
	
	
	

}
