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

import com.ab.springboot.reto.backend.sophos.controller.AffiliatesController;
import com.ab.springboot.reto.backend.sophos.model.affiliates;
import com.ab.springboot.reto.backend.sophos.service.AffiliatesService;

import oracle.net.jdbc.TNSAddress.Description;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AffiliatesControllerTest {
	
	@Mock
	private AffiliatesService AffiliatesServiceMock;
	//TestsDao testsDaoMock = Mockito.mock(TestsDao.class);
	@InjectMocks
	private AffiliatesController affiliatesController = new AffiliatesController();
	
	private affiliates affiliates;
	
	@BeforeEach
	public void initMocks(){
		affiliates = new affiliates();
		affiliates.setId((Integer) 1);
		affiliates.setNombre("Nombre de Test");
		affiliates.setAge(10);
		affiliates.setMail("abcd@abcd.com");
	}
	
	//Controller GET
	@Test
	void Test_Get_Tests_No_Nulo () {
		List<affiliates> affiliates_list = new ArrayList<affiliates>();
		affiliates_list.add(affiliates);
		Mockito.when(AffiliatesServiceMock.findAll()).thenReturn(affiliates_list);
		Assertions.assertNotNull(affiliatesController.findAll());
	}
	
	@Test
	void Test_Get_Tests_OK () {
		List<affiliates> affiliates_list = new ArrayList<affiliates>();
		affiliates_list.add(affiliates);
		Mockito.when(AffiliatesServiceMock.findAll()).thenReturn(affiliates_list);
		var affiliates_prueba = affiliatesController.findAll();
		Assertions.assertEquals(HttpStatus.OK, affiliates_prueba.getStatusCode());
	}
	
	//Controller GET BY ID
	@Test
	void Test_GetById_Tests_No_Nulo () {
		Mockito.when(AffiliatesServiceMock.findById(1)).thenReturn(affiliates);
		Assertions.assertNotNull(affiliatesController.mostrar(1));
	}
	
	@Test
	void Test_GetById_Tests_OK () {
		Mockito.when(AffiliatesServiceMock.findById(1)).thenReturn(affiliates);
		Assertions.assertEquals(HttpStatus.OK, affiliatesController.mostrar(1).getStatusCode());
	}
	
	
	//Controller POST
	@Test
	void Test_Post_Tests_No_Nulo () {
		Mockito.when(AffiliatesServiceMock.save(any(affiliates.class))).thenReturn(affiliates);;
		var affiliates_prueba = affiliatesController.save(new affiliates());
		Assertions.assertNotNull(affiliates_prueba);
	}
	
	@Test
	void Test_Post_Tests_OK () {
		Mockito.when(AffiliatesServiceMock.save(any(affiliates.class))).thenReturn(affiliates);;
		var affiliates_prueba = affiliatesController.save(new affiliates());
		Assertions.assertEquals(HttpStatus.CREATED, affiliates_prueba.getStatusCode());
	}
	
	//Controller PUT
	@Test
	void Test_Put_Tests_No_Nulo () {
		Mockito.when(AffiliatesServiceMock.findById(1)).thenReturn(affiliates);
		var affiliates_prueba = affiliatesController.update(new affiliates(), 1);
		Assertions.assertNotNull(affiliates_prueba);
	}
	
	@Test
	void Test_Put_Tests_OK () {
		Mockito.when(AffiliatesServiceMock.findById(1)).thenReturn(affiliates);
		var affiliates_prueba = affiliatesController.update(new affiliates(), 1);
		Assertions.assertEquals(HttpStatus.CREATED, affiliates_prueba.getStatusCode());
	}
	
	//Controller Delete
	@Test
	void Test_Delete_Tests_OK() {
		var affiliates_prueba = affiliatesController.delete(1);
		Assertions.assertEquals(HttpStatus.OK, affiliates_prueba.getStatusCode());
	}
	

}