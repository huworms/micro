package com.example.demo.hoteles.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hoteles.config.HotelsServiceConfiguration;
import com.example.demo.hoteles.model.Hotel;
import com.example.demo.hoteles.model.HotelRooms;
import com.example.demo.hoteles.model.PropertiesHotels;
import com.example.demo.hoteles.services.IHotelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
	

@RestController
public class HotelController {

	private static final Logger logger= LoggerFactory.getLogger(HotelController.class);

	
	
	@Autowired
	private IHotelService service;
	
	@Autowired
	private HotelsServiceConfiguration configHotels;
	
	@GetMapping("hotels")
	public List<Hotel> search(){
		logger.info("Inicio del metodo search");
		return (List<Hotel>)this.service.search();
	}
	
	@GetMapping("hotels/{hotelId}")
	@CircuitBreaker(name="searchHotelIdSupportCB")
	public HotelRooms searchHotelId(@PathVariable long hotelId){
		logger.info("Inicio del metodo searh by ID");
		return this.service.searchHotelById(hotelId);
	}
	
	@GetMapping("/hotels/read/properties")
	public String getPropertiesHotels() throws JsonProcessingException{
		ObjectWriter owj= new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesHotels propHotels=new PropertiesHotels(configHotels.getMsg(), 
				configHotels.getBuildVersion(), configHotels.getMailDetails());
		String jsonString=owj.writeValueAsString(propHotels);
		return jsonString;
	}
}
