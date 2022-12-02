package com.ab.springboot.reto.backend.sophos.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.springboot.reto.backend.sophos.model.appointments;
import com.ab.springboot.reto.backend.sophos.service.AppointmentsService;

@RestController
@ControllerAdvice
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/controller")
public class AppointmentsController {
	
	@Autowired
	private AppointmentsService appointmentsService;
	
	@PostMapping("/appointments")  //Insertar datos
	public ResponseEntity<appointments> save(@RequestBody appointments appointments) {  //RequestBody toma el return lo convierte a tipo tests
		try {
			return new ResponseEntity<>(appointmentsService.save(appointments), HttpStatus.CREATED);
			}catch(Exception e) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
	}
	
	@GetMapping("/appointments")	
	public ResponseEntity<List<appointments>> findAll(){
		try {
		return new ResponseEntity<>(appointmentsService.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/appointments/{id}")
	public ResponseEntity<appointments> mostrar(@PathVariable Integer id){
		appointments appointmentsId = appointmentsService.findById(id);
		if (appointmentsId == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(appointmentsService.findById(id), HttpStatus.OK);
		}
	}
	
	@PutMapping("/appointments/{id}")  //Actualizar tabla
	public ResponseEntity<appointments> update(@RequestBody appointments appointments, @PathVariable Integer id) {  //RequestBody toma el return lo convierte a tipo tests
		try {
			appointments appointmentsActual = appointmentsService.findById(id);
			appointmentsActual.setDate(appointments.getDate());
			appointmentsActual.setHour(appointments.getHour());
			appointmentsActual.setTests(appointments.getTests());
			appointmentsActual.setAffiliates(appointments.getAffiliates());
			return new ResponseEntity<>(appointmentsService.save(appointmentsActual), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("appointments/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			appointmentsService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/appointments_date")
	public ResponseEntity<List<appointments>> getByDate(@RequestParam("date") @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate date){
		try {
			return new ResponseEntity<>(appointmentsService.getByDate(date), HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
	}
	
	@GetMapping("/appointments/affiliate/{id}")
	public ResponseEntity<List<appointments>> getByAffiliate(@PathVariable Integer id){
		try {
			return new ResponseEntity<>(appointmentsService.getByAffiliate(id), HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
	}
	
	

}