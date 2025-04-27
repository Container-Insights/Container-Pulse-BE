package com.monitoring.backend.dto.req.node;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "노드 목록 조회 요청")
public class NodeListReq {

	//클러스터 식별자에 해당하는 노드 조회용
	@Schema(
		description = "클러스터 식별자(시퀀스)",
		example = "1"
	)
	private long clusterSeq;

	//마지막으로 조회한 seq
	@Schema(
		description = "마지막으로 호출된 노드 seq - 무한스크롤 용",
		example = "1",
		nullable = true
	)
	private long lastSeq;

}
