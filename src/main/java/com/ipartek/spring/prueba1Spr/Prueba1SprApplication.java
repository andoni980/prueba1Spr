package com.ipartek.spring.prueba1Spr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Prueba1SprApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Prueba1SprApplication.class, args);
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(passwordEncoder.encode("andoni"));
		System.out.println(passwordEncoder.encode("iker"));
		
	}

}
