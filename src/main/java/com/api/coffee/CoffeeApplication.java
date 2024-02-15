package com.api.coffee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server running..................");
	}

	
}
