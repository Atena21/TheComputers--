package com.example.TheComputersmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.TheComputersmm.controllers", "com.example.TheComputersmm"})
public class TheComputersmmApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TheComputersmmApplication.class, args);
	}

}
