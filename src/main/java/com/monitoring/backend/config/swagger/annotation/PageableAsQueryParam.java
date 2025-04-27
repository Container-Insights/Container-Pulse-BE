package com.monitoring.backend.config.swagger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 페이징 인터페이스 swagger 작성을 위한 커스텀 어노테이션
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Parameters({
	@Parameter(
		name = "pageSize",
		description = "페이지 사이즈",
		in = ParameterIn.QUERY,//쿼리 파라미터로 넣어야 된다는 뜻.
		schema = @Schema(type = "integer")
	)
})
public @interface PageableAsQueryParam {
}
