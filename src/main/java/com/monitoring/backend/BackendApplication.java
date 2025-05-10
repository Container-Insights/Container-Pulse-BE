package com.monitoring.backend;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
		System.setProperty("user.timezone", "Asia/Seoul");

		SpringApplication.run(BackendApplication.class, args);
	}

}
