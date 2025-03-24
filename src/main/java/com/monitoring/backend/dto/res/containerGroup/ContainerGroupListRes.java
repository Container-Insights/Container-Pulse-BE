package com.monitoring.backend.dto.res.containerGroup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class ContainerGroupListRes {

	@Schema(description = "컨테이너그룹(쿠버에서 pod) 식별자 - DB 시퀀스값(포함된 컨테이너 조회 시 필요.)", example = "1")
	private long conGroupSeq;
	@Schema(description = "컨테이너그룹(쿠버에서 pod) ID - pod에서 식별용으로 쓰는 id")
	private String conGroupId;
	@Schema(description = "컨테이너그룹(쿠버에서 pod) 이름 - 없을 수도 있음.")
	private String conGroupName;

}
