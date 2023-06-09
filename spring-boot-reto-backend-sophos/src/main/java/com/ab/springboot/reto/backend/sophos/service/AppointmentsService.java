package com.ab.springboot.reto.backend.sophos.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.ab.springboot.reto.backend.sophos.model.appointments;

public interface AppointmentsService {
	
	public appointments save(appointments appointments);
	
	public void delete (Integer id);
	
	public appointments findById(Integer id);
	
	public List<appointments> findAll();
	
	public List<appointments> getByDate(LocalDate date);
	
	public List<appointments> getByAffiliate(Integer id_affiliate);

}
