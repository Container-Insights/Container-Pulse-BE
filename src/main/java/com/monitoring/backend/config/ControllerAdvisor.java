package com.monitoring.backend.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.monitoring.backend.config.response.CommonResponse;
import com.monitoring.backend.config.response.CustomStatus;
import com.monitoring.backend.config.response.ResponseService;
import com.monitoring.backend.config.response.exception.CustomException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//TODO: 추후에 알림 서비스(슬랙, 디코등)를 연동해서 에러 메시지를 보내도록 해야 함.
@Slf4j
@Getter
@RequiredArgsConstructor
@RestControllerAdvice
public class ControllerAdvisor {

	private final ResponseService responseService;

	/**
	 * 커스텀 예외들
	 */
	@ExceptionHandler
	public CommonResponse exceptionHandler(CustomException e) {

		CustomStatus status = e.getCustomExceptionStatus();

		log.warn("[ CustomException - {}] : {}",
			LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")),
			status.getMessage()
		);

		return responseService.getExceptionResponse(status);

	}

	/**
	 * 커스텀 예외로 잡히지 않은 에러들
	 */
	@ExceptionHandler
	public CommonResponse exceptionHandler(Exception e) {

		log.error("[ Exception - {}] : {}",
			LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")),
			e.getMessage()
		);

		//에러의 경우에는 따로 메시지를 응답으로 주지 않음.
		return responseService.getErrorResponse(e);
	}
}
