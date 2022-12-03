package com.ab.springboot.reto.backend.sophos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.ab.springboot.reto.backend.sophos.model.Tests;
import com.ab.springboot.reto.backend.sophos.model.affiliates;
import com.ab.springboot.reto.backend.sophos.service.AffiliatesService;
import com.ab.springboot.reto.backend.sophos.service.TestsService;

@RestController
@ControllerAdvice
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/controller")
public class AffiliatesController {
	@Autowired
	private AffiliatesService affiliatesService;
	
	@PostMapping("/affiliates")  //Insertar datos
	public ResponseEntity<affiliates> save(@RequestBody affiliates affiliates) {  //RequestBody toma el return lo convierte a tipo tests
		try {
			return new ResponseEntity<>(affiliatesService.save(affiliates), HttpStatus.CREATED);
			}catch(Exception e) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
	}
	
	@GetMapping("/affiliates")	
	public ResponseEntity<List<affiliates>> findAll(){
		try {
		return new ResponseEntity<>(affiliatesService.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/affiliates/{id}")
	public ResponseEntity<affiliates> mostrar(@PathVariable Integer id){
		affiliates AffiliateId = affiliatesService.findById(id);
		if (AffiliateId == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(affiliatesService.findById(id), HttpStatus.OK);
		}
	}
	
	@PutMapping("/affiliates/{id}")  //Actualizar tabla
	public ResponseEntity<affiliates> update(@RequestBody affiliates affiliates, @PathVariable Integer id) {  //RequestBody toma el return lo convierte a tipo tests
		try {
			affiliates affiliateActual = affiliatesService.findById(id);
			affiliateActual.setNombre(affiliates.getNombre());
     		affiliateActual.setAge(affiliates.getAge());
     		affiliateActual.setMail(affiliates.getMail());
			return new ResponseEntity<>(affiliatesService.save(affiliateActual), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("affiliates/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			affiliatesService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}