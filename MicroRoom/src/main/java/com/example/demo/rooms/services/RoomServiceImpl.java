package com.example.demo.rooms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.rooms.dao.IRoomDao;
import com.example.demo.rooms.model.Room;

@Service
public class RoomServiceImpl implements IRoomService{

	@Autowired
	private IRoomDao roomDao;
	
	@Override
	public List<Room> search() {
		// TODO Auto-generated method stub
		return (List<Room>) roomDao.findAll();
	}

	@Override
	public List<Room> searchRoomByHotelId(long hotelId) {
		List<Room> rooms= this.roomDao.findByHotelId(hotelId);
		return rooms;
	}

}
