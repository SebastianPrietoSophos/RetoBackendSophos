package com.ab.springboot.reto.backend.sophos.model;

import java.sql.Time;
import java.time.LocalDate;

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

@Entity
@Table(name = "appointments")
public class appointments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name = "date_a")
	@JsonFormat(pattern="dd-MM-yyyy")
	private  LocalDate date; //(date y hour puede ocacionar problema porque son palabras clave de oracle)
	
	//format time
	@Column(name = "hour_a")
	@DateTimeFormat(pattern="HH24:MI")
	@JsonFormat(pattern="HH24:MI")
	private Time hour;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_test")
	private Tests tests;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_affiliate")
	private affiliates affiliates;

	public appointments() {
		super();
	}

	public appointments(Integer id, LocalDate date, Time hour, Tests tests, affiliates affiliates) {
		super();
		this.id = id;
		this.date = date;
		this.hour = hour;
		this.tests = tests;
		this.affiliates = affiliates;
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