package com.ab.springboot.reto.backend.sophos.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ab.springboot.reto.backend.sophos.model.Tests;
import com.ab.springboot.reto.backend.sophos.dao.TestsDao;

@Service
public class TestsServiceImplement implements TestsService{
	
	@Autowired
	private TestsDao TestsDao;

	@Override
	@Transactional(readOnly= false) //Cambio en la bd
	public Tests save(Tests tests) {
		return TestsDao.save(tests);
	}

	@Override
	@Transactional(readOnly= false) //Cambio
	public void delete(Integer id) {
		TestsDao.delete(findById(id));
	}

	@Override
	@Transactional(readOnly= true) //Solo lectura
	public Tests findById(Integer id) {
		return TestsDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly= true) //Solo lectura
	public List<Tests> findAll() {
		return (List<Tests>) TestsDao.findAll();
	}
	
	

}
