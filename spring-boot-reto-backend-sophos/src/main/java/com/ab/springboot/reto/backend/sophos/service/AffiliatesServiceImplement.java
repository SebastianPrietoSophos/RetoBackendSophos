package com.ab.springboot.reto.backend.sophos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ab.springboot.reto.backend.sophos.dao.AffiliatesDao;
import com.ab.springboot.reto.backend.sophos.model.affiliates;

@Service
public class AffiliatesServiceImplement implements AffiliatesService{
	
	@Autowired
	private AffiliatesDao affiliatesDao;

	@Override
	@Transactional(readOnly= false) //Cambio en la bd
	public affiliates save(affiliates affiliates) {
		return affiliatesDao.save(affiliates);
	}

	@Override
	@Transactional(readOnly= false) //Delete
	public void delete(Integer id) {
		affiliatesDao.delete(findById(id));
	}

	@Override
	@Transactional(readOnly= true) //Solo lectura
	public affiliates findById(Integer id) {
		return affiliatesDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly= true) //Solo lectura
	public List<affiliates> findAll() {
		return (List<affiliates>) affiliatesDao.findAll();
	}
	
	

}