package com.monitoring.backend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HealthCheckController {


	@GetMapping("/health")
	public String healthCheck(){
		return "success";
	}


}
