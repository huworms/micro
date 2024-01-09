package com.example.demo.rooms.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.rooms.model.Room;

public interface IRoomDao extends CrudRepository<Room, Long>{

}
