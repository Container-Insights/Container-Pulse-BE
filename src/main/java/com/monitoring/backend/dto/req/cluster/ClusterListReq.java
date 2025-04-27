package com.monitoring.backend.dto.req.cluster;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "클러스터 목록 조회 요청")
public class ClusterListReq {

	//클러스터 타입으로 조회
	@Schema(
		description = "클러스터 타입정보 - 코드값",
		example = "C0001",
		nullable = true
	)
	private String clusterType;


	//마지막으로 조회한 seq
	@Schema(
		description = "마지막으로 호출된 클러스터 seq - 무한스크롤 용",
		example = "1",
		nullable = true
	)
	private long lastSeq;



}
