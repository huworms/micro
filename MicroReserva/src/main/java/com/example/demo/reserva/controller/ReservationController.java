package com.example.demo.reserva.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger= LoggerFactory.getLogger(ReservationController.class);


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
		logger.info("Iniciando metodo de reserva");
		ObjectWriter owj= new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesReservation propHotels=new PropertiesReservation(configReservation.getMsg(), 
				configReservation.getBuildVersion(), configReservation.getMailDetails());
		String jsonString=owj.writeValueAsString(propHotels);
		return jsonString;
	}
}
