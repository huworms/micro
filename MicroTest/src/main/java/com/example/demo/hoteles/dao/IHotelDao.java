package com.example.demo.hoteles.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.hoteles.model.Hotel;

public interface IHotelDao extends CrudRepository<Hotel, Long>{

}
