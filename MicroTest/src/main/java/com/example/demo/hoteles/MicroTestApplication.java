package com.example.demo.hoteles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroTestApplication.class, args);
	}

}
