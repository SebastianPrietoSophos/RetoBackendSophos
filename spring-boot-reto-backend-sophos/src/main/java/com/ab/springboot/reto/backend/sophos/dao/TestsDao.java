package com.ab.springboot.reto.backend.sophos.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.springboot.reto.backend.sophos.model.Tests;

public interface TestsDao extends JpaRepository<Tests, Integer>{
		

}
