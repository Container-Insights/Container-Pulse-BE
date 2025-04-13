package com.monitoring.backend.dto.req.node;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NodeListReq {

	//클러스터 식별자에 해당하는 노드 조회용
	private long clusterSeq;

	//마지막으로 조회한 seq
	private long lastSeq;

}
