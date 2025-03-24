package com.monitoring.backend.dto.res.cluster;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class ClusterInfoRes {

	@Schema(description = "클러스터 시퀀스")
	private long clusterSeq;
	@Schema(description = "클러스터 이름")
	private String clusterName;
	@Schema(description = "클러스터 타입이름")
	private String clusterTypeName;
	@Schema(description = "클러스터 생성일자")
	private LocalDateTime createdDt;
	@Schema(description = "클러스터 변경일자")
	private LocalDateTime updateDt;
}
