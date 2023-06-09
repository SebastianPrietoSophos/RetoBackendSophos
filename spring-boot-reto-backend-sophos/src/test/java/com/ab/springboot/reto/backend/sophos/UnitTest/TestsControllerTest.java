package com.ab.springboot.reto.backend.sophos.UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.junit.jupiter.api.BeforeEach;
import com.ab.springboot.reto.backend.sophos.controller.TestsController;
import com.ab.springboot.reto.backend.sophos.dao.TestsDao;
import com.ab.springboot.reto.backend.sophos.model.Tests;
import com.ab.springboot.reto.backend.sophos.model.affiliates;
import com.ab.springboot.reto.backend.sophos.service.TestsService;

import oracle.net.jdbc.TNSAddress.Description;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TestsControllerTest {
	
	@Mock
	private TestsService TestsServiceMock;
	//TestsDao testsDaoMock = Mockito.mock(TestsDao.class);
	@InjectMocks
	private TestsController testsController = new TestsController();
	
	private Tests tests;
	
	@BeforeEach
	public void initMocks(){
		tests = new Tests();
		tests.setId((Integer) 1);
		tests.setDescrition("Descripición de Test Mockito");
		tests.setNombre("Nombre de Test");				
	}
	
	//Controller GET
	@Test
	void Test_Get_Tests_No_Nulo () {
		List<Tests> test_list = new ArrayList<Tests>();
		test_list.add(tests);
		Mockito.when(TestsServiceMock.findAll()).thenReturn(test_list);
		Assertions.assertNotNull(testsController.findAll());
	}
	
	@Test
	void Test_Get_Tests_OK () {
		List<Tests> test_list = new ArrayList<Tests>();
		test_list.add(tests);
		Mockito.when(TestsServiceMock.findAll()).thenReturn(test_list);
		var test_prueba = testsController.findAll();
		Assertions.assertEquals(HttpStatus.OK, test_prueba.getStatusCode());
	}
	
	@Test
	void Test_Get_Tests_NoContent() {
		Mockito.when(TestsServiceMock.findAll()).thenThrow();
		var test_prueba = testsController.findAll();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, test_prueba.getStatusCode());
	}
	
	//Controller GET BY ID
	@Test
	void Test_GetById_Tests_No_Nulo () {
		Mockito.when(TestsServiceMock.findById(1)).thenReturn(tests);
		Assertions.assertNotNull(testsController.mostrar(1));
	}
	
	@Test
	void Test_GetById_Tests_OK () {
		Mockito.when(TestsServiceMock.findById(1)).thenReturn(tests);
		Assertions.assertEquals(HttpStatus.OK, testsController.mostrar(1).getStatusCode());
	}
	
	@Test
	void Test_GetById_Tests_NotFound () {
		Mockito.when(TestsServiceMock.findById(1)).thenReturn(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, testsController.mostrar(1).getStatusCode());
	}
	
	//Controller POST
	@Test
	void Test_Post_Tests_No_Nulo () {
		Mockito.when(TestsServiceMock.save(any(Tests.class))).thenReturn(tests);;
		var test_prueba = testsController.save(new Tests());
		Assertions.assertNotNull(test_prueba);
	}
	
	@Test
	void Test_Post_Tests_Created () {
		Mockito.when(TestsServiceMock.save(any(Tests.class))).thenReturn(tests);;
		var test_prueba = testsController.save(new Tests());
		Assertions.assertEquals(HttpStatus.CREATED, test_prueba.getStatusCode());
	}
	
	@Test
	void Test_Post_Tests_NotFound() {
		Mockito.when(TestsServiceMock.save(any(Tests.class))).thenThrow();
		var test_prueba = testsController.save(new Tests());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, test_prueba.getStatusCode());
	}
	
	//Controller PUT
	@Test
	void Test_Put_Tests_No_Nulo () {
		Mockito.when(TestsServiceMock.findById(1)).thenReturn(tests);
		var test_prueba = testsController.update(new Tests(), 1);
		Assertions.assertNotNull(test_prueba);
	}
	
	@Test
	void Test_Put_Tests_Created() {
		Mockito.when(TestsServiceMock.findById(1)).thenReturn(tests);
		var test_prueba = testsController.update(new Tests(), 1);
		Assertions.assertEquals(HttpStatus.CREATED, test_prueba.getStatusCode());
	}
	
	@Test
	void Test_Put_Tests_NotFound() {
		Mockito.when(TestsServiceMock.findById(1)).thenThrow();
		var tests_prueba = testsController.update(new Tests(), 1);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, tests_prueba.getStatusCode());
	}
	
	//Controller Delete
	@Test
	void Test_Delete_Tests_OK() {
		var test_prueba = testsController.delete(1);
		Assertions.assertEquals(HttpStatus.OK, test_prueba.getStatusCode());
	}
	
	@Test
	void Test_Delete_Tests_NoContent() {
		Mockito.when(TestsServiceMock.findById(1)).thenThrow();
		var test_prueba = testsController.delete(1);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, test_prueba.getStatusCode());
	}
	

}
