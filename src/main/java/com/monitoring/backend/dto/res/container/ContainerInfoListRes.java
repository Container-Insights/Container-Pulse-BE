package com.monitoring.backend.dto.res.container;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class ContainerInfoListRes {

	@Schema(description = "컨테이너 식별자 - DB 시퀀스값(컨테이너 벼로 이력 조회 시 필요.)", example = "1")
	private long containerSeq;
	@Schema(description = "컨테이너ID - 컨테이너에서 식별용으로 쓰는 해시값")
	private String containerId;
	@Schema(description = "컨테이너이름 - 없을 수도 있음.")
	private String conGroupName;

}
