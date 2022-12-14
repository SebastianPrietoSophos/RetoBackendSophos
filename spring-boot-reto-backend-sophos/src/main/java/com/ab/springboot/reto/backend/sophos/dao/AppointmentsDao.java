package com.ab.springboot.reto.backend.sophos.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ab.springboot.reto.backend.sophos.model.appointments;

// Acceso a las operaciones crud extendiendo de JPARepository
public interface AppointmentsDao extends JpaRepository<appointments, Integer>{
	
	
	// Query para el metodo get By date ordenado por id_afiliados
	@Query("select a from appointments a where a.date like :var_parm order by a.affiliates.id")
	public List<appointments> getByDate(@Param("var_parm") LocalDate date);

	// Query para el metodo get By id_afiliados
	@Query("select a from appointments a where a.affiliates.id = :var_parm")
	public List<appointments> getByAffiliate(@Param("var_parm") Integer id_affiliate);
}

