package com.monitoring.backend.dto.req.cluster;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClusterListReq {

	//클러스터 타입으로 조회
	private String clusterType;

	//마지막으로 조회한 seq
	private long lastSeq;



}
