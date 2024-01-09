package com.example.demo.reserva.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.reserva.model.Reservation;

public interface IReservationDao extends CrudRepository<Reservation, Long>{

	
}
