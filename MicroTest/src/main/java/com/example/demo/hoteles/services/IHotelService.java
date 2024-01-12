package com.example.demo.hoteles.services;

import java.util.List;

import com.example.demo.hoteles.model.Hotel;
import com.example.demo.hoteles.model.HotelRooms;

public interface IHotelService {
	
	List<Hotel> search();
	HotelRooms searchHotelById(long hotelId);

}
