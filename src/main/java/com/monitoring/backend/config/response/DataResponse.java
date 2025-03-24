package com.monitoring.backend.config.response;

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
public class DataResponse<T> extends CommonResponse{

	T data;

	public static <T> DataResponse<T> createDataResponse(T data, CustomStatus status){
		DataResponse<T> dataResponse = new DataResponse<>();
		dataResponse.setData(data);
		dataResponse.setCode(status.getCode());
		dataResponse.setStatus(status.getStatus().toString());

		return dataResponse;
	}


}
