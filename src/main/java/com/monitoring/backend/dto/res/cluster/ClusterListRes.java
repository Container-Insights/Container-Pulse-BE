package com.monitoring.backend.dto.res.cluster;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;

@Getter
public class ClusterListRes {

	@Schema(description = "클러스터 식별자 - DB 시퀀스값(포함된 노드 조회 시 필요.)", example = "1")
	private long clusterSeq;
	@Schema(description = "클러스터 ID - 클러스터에서 식별용으로 쓰는 id")
	private String clusterId;
	@Schema(description = "클러스터 이름 - 없을 수도 있음.")
	private String clusterName;
	@Schema(description = "클러스터 타입명")
	private String clusterTypeName;

}
