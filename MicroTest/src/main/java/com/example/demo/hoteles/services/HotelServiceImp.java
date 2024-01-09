package com.example.demo.hoteles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hoteles.dao.IHotelDao;
import com.example.demo.hoteles.model.Hotel;

@Service
public class HotelServiceImp implements IHotelService{

	@Autowired
	private IHotelDao hotelDao;
	
	@Override
	public List<Hotel> search() {
		List<Hotel> tmp= (List<Hotel>)hotelDao.findAll();
		System.out.println("hoteles: "+tmp.size());
		/*for(Hotel h: tmp)	
			System.out.println(h.getHotelName());*/
		return tmp;
	}

}
