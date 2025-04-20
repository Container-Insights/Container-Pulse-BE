package com.monitoring.backend.dto.res.container;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class ContainerInfoRes {

	@Schema(description = "컨테이너 식별자 - DB 시퀀스값(컨테이너 벼로 이력 조회 시 필요.)", example = "1")
	private long containerSeq;
	@Schema(description = "컨테이너ID - 컨테이너에서 식별용으로 쓰는 해시값")
	private String containerId;
	@Schema(description = "컨테이너 - 없을 수도 있음.")
	private String containerName;
	@Schema(description = "컨테이너 이미지")
	private String containerImage;
	@Schema(description = "컨테이너 상태")
	private String status;
	@Schema(description = "컨테이너 cpu상태")
	private String cpuUsage;
	@Schema(description = "컨테이너 메모리 상태")
	private String memoryUsage;
	@Schema(description = "컨테이너 생성일시.")
	private LocalDateTime createdDt;
	@Schema(description = "컨테이너 리소스 수집시간.")
	private LocalDateTime collectDt;
}
