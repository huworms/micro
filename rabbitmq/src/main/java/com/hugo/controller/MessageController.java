package com.hugo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hugo.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
	
	@Autowired
	private RabbitMQProducer producer;

	
	
	//http://localhost:8080/api/v1/publish?message=hello
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
		producer.sendMenssage(message);
		return ResponseEntity.ok("Message sent to RabbitMQ...");
	}

}
