package com.monitoring.backend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Tag(name = "HealthCheck", description = "헬스 체크용")
public class HealthCheckController {


	@Operation(summary = "헬스 체크용 API")
	@GetMapping("/health")
	public String healthCheck(){
		return "success";
	}


}
