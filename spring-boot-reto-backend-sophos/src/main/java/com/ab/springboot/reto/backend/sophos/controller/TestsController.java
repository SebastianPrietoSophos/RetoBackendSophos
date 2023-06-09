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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ab.springboot.reto.backend.sophos.model.Tests;
import com.ab.springboot.reto.backend.sophos.service.TestsService;

@RestController
@ControllerAdvice
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/controller")
public class TestsController {
	@Autowired
	private TestsService testsService;
	
	@PostMapping("/tests")  //Insertar datos
	public ResponseEntity<Tests> save(@RequestBody Tests tests) {  //RequestBody toma el return lo convierte a tipo tests
		try {
			return new ResponseEntity<>(testsService.save(tests), HttpStatus.CREATED);
			}catch(Exception e) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
	}
	
	@GetMapping("/tests")	
	public ResponseEntity<List<Tests>> findAll(){
		try {
		return new ResponseEntity<>(testsService.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/tests/{id}")
	public ResponseEntity<Tests> mostrar(@PathVariable Integer id){
		Tests testId = testsService.findById(id);
		if (testId == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(testsService.findById(id), HttpStatus.OK);
		}
	}
	
	@PutMapping("/tests/{id}")  //Actualizar tabla
	public ResponseEntity<Tests> update(@RequestBody Tests tests, @PathVariable Integer id) {  //RequestBody toma el return lo convierte a tipo tests
		try {
			Tests TestActual = testsService.findById(id);
			TestActual.setNombre(tests.getNombre());
			TestActual.setDescrition(tests.getDescription());
			return new ResponseEntity<>(testsService.save(TestActual), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("tests/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			testsService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
