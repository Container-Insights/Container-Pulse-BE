package com.monitoring.backend.config.response;

import static com.monitoring.backend.config.response.ResponseStatus.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {

	private String code;
	private String status;
	private String message;


	public static CommonResponse createCommonResponse(CustomStatus status){
		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setCode(status.getCode());
		commonResponse.setStatus(status.getStatus().toString());
		commonResponse.setMessage(status.getMessage());
		return commonResponse;
	}

	public static CommonResponse createErrorResponse(Exception e){
		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setCode("444");
		commonResponse.setStatus(FAIL.toString());

		return commonResponse;
	}
}
