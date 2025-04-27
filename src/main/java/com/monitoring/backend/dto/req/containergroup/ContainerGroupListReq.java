package com.monitoring.backend.dto.req.containergroup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "컨테이너 그룹(pod) 목록 조회 요청")
public class ContainerGroupListReq {

	//노드 식별자에 해당하는 노드 조회용
	@Schema(
		description = "노드 식별자(시퀀스)",
		example = "1"
	)
	private long nodeSeq;

	//마지막으로 조회한 seq
	@Schema(
		description = "마지막으로 호출된 컨테이너 그룹 seq - 무한스크롤 용",
		example = "1",
		nullable = true
	)
	private long lastSeq;
}
