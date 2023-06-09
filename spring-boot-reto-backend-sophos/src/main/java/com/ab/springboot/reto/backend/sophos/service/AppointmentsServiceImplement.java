package com.ab.springboot.reto.backend.sophos.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ab.springboot.reto.backend.sophos.dao.AppointmentsDao;
import com.ab.springboot.reto.backend.sophos.model.appointments;


@Service
public class AppointmentsServiceImplement implements AppointmentsService{
	
	@Autowired 
	private AppointmentsDao appointmentsDao;

	@Override
	@Transactional(readOnly= false) //Cambio en la bd
	public appointments save(appointments appointments) {
		return appointmentsDao.save(appointments);
	}

	@Override
	@Transactional(readOnly= false) //Cambio
	public void delete(Integer id) {
		appointmentsDao.delete(findById(id));
	}

	@Override
	@Transactional(readOnly= true) //Solo lectura
	public appointments findById(Integer id) {
		return appointmentsDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly= true) //Solo lectura
	public List<appointments> findAll() {
		return (List<appointments>) appointmentsDao.findAll();
	}

	@Override
	@Transactional(readOnly= true) //Solo lectura
	public List<appointments> getByDate(LocalDate date) {
		return (List<appointments>) appointmentsDao.getByDate(date);
	}

	@Override
	@Transactional(readOnly= true) //Solo lectura
	public List<appointments> getByAffiliate(Integer id_affiliate) {
		return (List<appointments>) appointmentsDao.getByAffiliate(id_affiliate);
	}
	

}
