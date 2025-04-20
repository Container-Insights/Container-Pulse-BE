package com.monitoring.backend.dto.req.container;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContainerListReq {

	//컨테이너 그룹 식별자에 해당하는 컨테이너 조회용
	private long conGroupSeq;

	//마지막으로 조회한 seq
	private long lastSeq;
}
