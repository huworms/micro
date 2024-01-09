package com.example.demo.reserva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.reserva.dao.IReservationDao;
import com.example.demo.reserva.model.Reservation;

@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	IReservationDao reservationDao;
	
	@Override
	public List<Reservation> search() {
		return (List<Reservation>)reservationDao.findAll(); 
	}

}
