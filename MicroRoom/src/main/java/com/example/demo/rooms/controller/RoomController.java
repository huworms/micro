package com.example.demo.rooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.rooms.config.RoomsServiceConfiguration;
import com.example.demo.rooms.model.PropertiesRooms;
import com.example.demo.rooms.model.Room;
import com.example.demo.rooms.services.IRoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class RoomController {

	@Autowired
	private IRoomService service;
	
	@Autowired
	private RoomsServiceConfiguration configRooms;
	
	@GetMapping("rooms")
	public List<Room> service(){
		return (List<Room>)this.service.search();
	}
	
	@GetMapping("/rooms/read/properties")
	public String getPropertiesRooms() throws JsonProcessingException{
		ObjectWriter owj= new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesRooms propHotels=new PropertiesRooms(configRooms.getMsg(), 
				configRooms.getBuildVersion(), configRooms.getMailDetails());
		String jsonString=owj.writeValueAsString(propHotels);
		return jsonString;
		
	}
}
