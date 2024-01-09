package com.example.demo.hoteles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hoteles.config.HotelsServiceConfiguration;
import com.example.demo.hoteles.model.Hotel;
import com.example.demo.hoteles.model.PropertiesHotels;
import com.example.demo.hoteles.services.IHotelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
	

@RestController
public class HotelController {

	@Autowired
	private IHotelService service;
	
	@Autowired
	private HotelsServiceConfiguration configHotels;
	
	@GetMapping("hotels")
	public List<Hotel> search(){
		return (List<Hotel>)this.service.search();
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
