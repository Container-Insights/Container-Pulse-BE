package com.monitoring.backend.config.response;

public interface CustomStatus {

	ResponseStatus getStatus();
	String getCode();
	String getMessage();
}
