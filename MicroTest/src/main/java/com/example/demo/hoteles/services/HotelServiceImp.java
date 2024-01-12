package com.example.demo.hoteles.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.hoteles.dao.IHotelDao;
import com.example.demo.hoteles.model.Hotel;
import com.example.demo.hoteles.model.HotelRooms;
import com.example.demo.hoteles.model.Room;
import com.example.demo.hoteles.services.client.IRoomsFeignClient;

@Service
public class HotelServiceImp implements IHotelService{

	@Autowired
	private IHotelDao hotelDao;
	
	// @Autowired
	// private RestTemplate clientRest;
	
	@Autowired
	private IRoomsFeignClient roomFeignClient;
	
	@Override
	public List<Hotel> search() {
		List<Hotel> tmp= (List<Hotel>)hotelDao.findAll();
		System.out.println("hoteles: "+tmp.size());
		/*for(Hotel h: tmp)	
			System.out.println(h.getHotelName());*/
		return tmp;
	}

	@Override
	public HotelRooms searchHotelById(long hotelId) {
		HotelRooms response=new HotelRooms();
		Optional<Hotel> hotel=hotelDao.findById(hotelId);
		
		/* Map<String, Long> pathVariable=new HashMap<String, Long>();
		pathVariable.put("id", hotelId);
		List<Room> rooms=Arrays.asList(clientRest.getForObject("http://localhost:8081/rooms/{id}", Room[].class,pathVariable));
		*/
		List<Room> rooms= this.roomFeignClient.searchByHotelId(hotelId);
		
		response.setHotelId(hotel.get().getHotelId());
		response.setHotelName(hotel.get().getHotelName());
		response.setHotelAddress(hotel.get().getHotelAddress());
		response.setRooms(rooms);
		
		
		return response;
	}

}
