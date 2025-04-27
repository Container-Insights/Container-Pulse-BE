package com.monitoring.backend.dto.req.container;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "컨테이너 목록 조회 요청")
public class ContainerListReq {

	//컨테이너 그룹 식별자에 해당하는 컨테이너 조회용
	@Schema(
		description = "컨테이너 그룹(pod) 식별자(시퀀스)",
		example = "1"
	)
	private long conGroupSeq;

	//마지막으로 조회한 seq
	@Schema(
		description = "마지막으로 호출된 컨테이너 seq - 무한스크롤 용",
		example = "1",
		nullable = true
	)
	private long lastSeq;
}
