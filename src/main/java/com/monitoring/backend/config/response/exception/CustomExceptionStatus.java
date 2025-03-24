package com.monitoring.backend.config.response.exception;


import com.monitoring.backend.config.response.CustomStatus;
import com.monitoring.backend.config.response.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomExceptionStatus implements CustomStatus {


	NOT_FOUND_CLUSTER(ResponseStatus.FAIL, "4004","해당하는 클러스터가 존재하지 않습니다."),
	NOT_FOUND_NODE(ResponseStatus.FAIL, "4005","해당하는 노드를 찾을 수 없습니다."),

	;
	private final ResponseStatus status;
	private final String code;
	private final String message;
}
