package com.monitoring.backend.dto.res.node;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class NodeInfoRes {

	@Schema(description = "노드 식별자 - DB 시퀀스값(포함된 컨테이너 그룹(pod) 조회 시 필요.)", example = "1")
	private long nodeSeq;
	@Schema(description = "노드 ID - 노드에서 식별용으로 쓰는 id")
	private String nodeId;
	@Schema(description = "노드 이름 - 없을 수도 있음.")
	private String nodeName;
	@Schema(description = "노드 ip 주소")
	private String ipAddress;
	@Schema(description = "노드 생성일자")
	private LocalDateTime createdDt;
	@Schema(description = "노드 변경일자")
	private LocalDateTime updateDt;

}
