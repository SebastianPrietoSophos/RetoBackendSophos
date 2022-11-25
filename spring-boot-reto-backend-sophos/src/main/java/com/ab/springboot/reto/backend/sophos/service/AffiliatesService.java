package com.ab.springboot.reto.backend.sophos.service;

import java.util.List;
import com.ab.springboot.reto.backend.sophos.model.affiliates;

public interface AffiliatesService {
	
	
	public affiliates save(affiliates affiliates);
	
	public void delete (Integer id);
	
	public affiliates findById(Integer id);
	
	public List<affiliates> findAll();
	

}
