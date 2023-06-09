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

import com.ab.springboot.reto.backend.sophos.controller.AppointmentsController;
import com.ab.springboot.reto.backend.sophos.model.Tests;
import com.ab.springboot.reto.backend.sophos.model.appointments;
import com.ab.springboot.reto.backend.sophos.service.AffiliatesService;
import com.ab.springboot.reto.backend.sophos.service.AppointmentsService;
import com.ab.springboot.reto.backend.sophos.model.affiliates;
import oracle.net.jdbc.TNSAddress.Description;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AppointmentsControllerTest {
	
	@Mock
	private AppointmentsService AppointmentsServiceMock;
	//TestsDao testsDaoMock = Mockito.mock(TestsDao.class);
	@InjectMocks
	private AppointmentsController appointmentsController = new AppointmentsController();
	
	private appointments appointments;
	private Tests tests;
	private affiliates affiliates;
	
	@BeforeEach
	public void initMocks(){
		appointments = new appointments();
		appointments.setId((Integer) 1);
		appointments.setDate(LocalDate.now());
		long milli = 123456789999l;
        Time time = new Time(milli);
		appointments.setHour(time);
		appointments.setTests(new Tests());
		appointments.setAffiliates(affiliates);
	}
	
	//Controller GET
	@Test
	void Test_Get_Appointments_No_Nulo () {
		List<appointments> appointments_list = new ArrayList<appointments>();
		appointments_list.add(appointments);
		Mockito.when(AppointmentsServiceMock.findAll()).thenReturn(appointments_list);
		Assertions.assertNotNull(appointmentsController.findAll());
	}
	
	@Test
	void Test_Get_Appointments_OK () {
		List<appointments> appointments_list = new ArrayList<appointments>();
		appointments_list.add(appointments);
		Mockito.when(AppointmentsServiceMock.findAll()).thenReturn(appointments_list);
		var appointments_prueba = appointmentsController.findAll();
		Assertions.assertEquals(HttpStatus.OK, appointments_prueba.getStatusCode());
	}
	
	@Test
	void Test_Get_Appointments_NoContent() {
		Mockito.when(AppointmentsServiceMock.findAll()).thenThrow();
		var appointments_prueba = appointmentsController.findAll();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, appointments_prueba.getStatusCode());
	}
	//Controller GET BY ID
	@Test
	void Test_GetById_Appointments_No_Nulo () {
		Mockito.when(AppointmentsServiceMock.findById(1)).thenReturn(appointments);
		Assertions.assertNotNull(appointmentsController.mostrar(1));
	}
	
	@Test
	void Test_GetById_Appointments_OK () {
		Mockito.when(AppointmentsServiceMock.findById(1)).thenReturn(appointments);
		Assertions.assertEquals(HttpStatus.OK, appointmentsController.mostrar(1).getStatusCode());
	}
	
	@Test
	void Test_GetById_Appointments_NotFound () {
		Mockito.when(AppointmentsServiceMock.findById(1)).thenReturn(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, appointmentsController.mostrar(1).getStatusCode());
	}
	
	
	//Controller POST
	@Test
	void Test_Post_Appointments_No_Nulo () {
		Mockito.when(AppointmentsServiceMock.save(any(appointments.class))).thenReturn(appointments);;
		var appointments_prueba = appointmentsController.save(new appointments());
		Assertions.assertNotNull(appointments_prueba);
	}
	
	@Test
	void Test_Post_Appointments_Created () {
		Mockito.when(AppointmentsServiceMock.save(any(appointments.class))).thenReturn(appointments);;
		var appointments_prueba = appointmentsController.save(new appointments());
		Assertions.assertEquals(HttpStatus.CREATED, appointments_prueba.getStatusCode());
	}
	
	@Test
	void Test_Post_Appointments_NotFound() {
		Mockito.when(AppointmentsServiceMock.save(any(appointments.class))).thenThrow();
		var appointments_prueba = appointmentsController.save(new appointments());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, appointments_prueba.getStatusCode());
	}
	
	//Controller PUT
	@Test
	void Test_Put_Appointments_No_Nulo () {
		Mockito.when(AppointmentsServiceMock.findById(1)).thenReturn(appointments);
		var appointments_prueba = appointmentsController.update(new appointments(), 1);
		Assertions.assertNotNull(appointments_prueba);
	}
	
	@Test
	void Test_Put_Appointments_Created () {
		Mockito.when(AppointmentsServiceMock.findById(1)).thenReturn(appointments);
		var appointments_prueba = appointmentsController.update(new appointments(), 1);
		Assertions.assertEquals(HttpStatus.CREATED, appointments_prueba.getStatusCode());
	}
	
	@Test
	void Test_Put_Appointments_NotFound() {
		Mockito.when(AppointmentsServiceMock.findById(1)).thenThrow();
		var appointments_prueba = appointmentsController.update(new appointments(), 1);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, appointments_prueba.getStatusCode());
	}
	
	//Controller Delete
	@Test
	void Test_Delete_Appointments_OK() {
		var appointments_prueba = appointmentsController.delete(1);
		Assertions.assertEquals(HttpStatus.OK, appointments_prueba.getStatusCode());
	}
	
	@Test
	void Test_Delete_Appointments_NoContent() {
		Mockito.when(AppointmentsServiceMock.findById(1)).thenThrow();
		var appointments_prueba = appointmentsController.delete(1);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, appointments_prueba.getStatusCode());
	}
	
	//Cotroller getbydate 
	@Test
	void Test_getByDate_Appointments_No_Nulo () {
		List<appointments> appointments_list = new ArrayList<appointments>();
		appointments_list.add(appointments);
		Mockito.when(AppointmentsServiceMock.getByDate(LocalDate.now())).thenReturn(appointments_list);
		Assertions.assertNotNull(appointmentsController.getByDate(LocalDate.now()));
	}
	
	@Test
	void Test_getByDate_Appointments_OK () {
		List<appointments> appointments_list = new ArrayList<appointments>();
		appointments_list.add(appointments);
		Mockito.when(AppointmentsServiceMock.getByDate(LocalDate.now())).thenReturn(appointments_list);
		var appointments_prueba = appointmentsController.getByDate(LocalDate.now());
		Assertions.assertEquals(HttpStatus.OK, appointments_prueba.getStatusCode());
	}
	
	@Test
	void Test_GetByDate_Appointments_NoContent() {
		Mockito.when(AppointmentsServiceMock.getByDate(LocalDate.now())).thenThrow();
		var appointments_prueba = appointmentsController.getByDate(LocalDate.now());
		Assertions.assertEquals(HttpStatus.NO_CONTENT, appointments_prueba.getStatusCode());
	}
	//Controller GetByAffiliate
	@Test
	void Test_getByAffiliates_Appointments_No_Nulo () {
		List<appointments> appointments_list = new ArrayList<appointments>();
		appointments_list.add(appointments);
		Mockito.when(AppointmentsServiceMock.getByAffiliate(1)).thenReturn(appointments_list);
		Assertions.assertNotNull(appointmentsController.getByAffiliate(1));
	}
	
	@Test
	void Test_getByAffililiates_Appointments_OK () {
		List<appointments> appointments_list = new ArrayList<appointments>();
		appointments_list.add(appointments);
		Mockito.when(AppointmentsServiceMock.getByAffiliate(1)).thenReturn(appointments_list);
		var appointments_prueba = appointmentsController.getByAffiliate(1);
		Assertions.assertEquals(HttpStatus.OK, appointments_prueba.getStatusCode());
	}
	
	@Test
	void Test_GetByAffiliate_Appointments_NoContent() {
		Mockito.when(AppointmentsServiceMock.getByAffiliate(1)).thenThrow();
		var appointments_prueba = appointmentsController.getByAffiliate(1);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, appointments_prueba.getStatusCode());
	}
	

}