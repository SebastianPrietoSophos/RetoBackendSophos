package com.ab.springboot.reto.backend.sophos.dao;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ab.springboot.reto.backend.sophos.model.Tests;
import com.ab.springboot.reto.backend.sophos.model.affiliates;

public interface AffiliatesDao extends JpaRepository<affiliates, Integer>{
	

}
