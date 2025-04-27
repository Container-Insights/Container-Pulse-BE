package com.monitoring.backend.config.swagger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.monitoring.backend.config.response.CommonResponse;
import com.monitoring.backend.config.response.DataResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(
	responses = {
		@ApiResponse(
			responseCode = "200",
			description = "정보 조회 성공",
			content = @Content(
				mediaType = "application/json",
				schema = @Schema(implementation = DataResponse.class)
			)
		),
		@ApiResponse(
			responseCode = "400",
			description = "잘못된 요청 파라미터",
			content = @Content(
				mediaType = "application/json",
				schema = @Schema(implementation = CommonResponse.class)
			)
		)
	}
)
public @interface ApiCommonDoc {

	/**
	 * API요약
	 */
	String summary() default "";

	/**
	 * API 상세설명
	 */
	String description() default "";

	/**
	 * API 태그
	 */
	String[] tags() default {""};
}
