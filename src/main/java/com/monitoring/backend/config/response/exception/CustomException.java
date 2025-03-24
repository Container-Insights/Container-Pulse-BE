package com.monitoring.backend.config.response.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 커스텀 예외는 런타임을 받도록 함.
 */
@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{

	CustomExceptionStatus customExceptionStatus;

}
