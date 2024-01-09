package com.example.demo.reserva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.reserva.config.ReservaServiceConfiguration;
import com.example.demo.reserva.model.PropertiesReservation;
import com.example.demo.reserva.model.Reservation;
import com.example.demo.reserva.service.IReservationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class ReservationController {

	@Autowired
	private IReservationService service;
	
	@Autowired
	private ReservaServiceConfiguration configReservation;
	
	@GetMapping("reservation")
	public List<Reservation> search(){
		return this.service.search();
	}
	
	@GetMapping("/reservation/read/properties")
	public String getPropertiesReservation() throws JsonProcessingException{
		ObjectWriter owj= new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesReservation propHotels=new PropertiesReservation(configReservation.getMsg(), 
				configReservation.getBuildVersion(), configReservation.getMailDetails());
		String jsonString=owj.writeValueAsString(propHotels);
		return jsonString;
	}
}
