package com.helze.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistrationApplication {
	public static  final int Course_Limit=5;
	public static  final int Student_Limit=30;

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}

}
