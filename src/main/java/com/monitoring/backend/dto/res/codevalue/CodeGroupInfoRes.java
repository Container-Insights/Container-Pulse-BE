package com.monitoring.backend.dto.res.codevalue;

import java.util.List;

import com.monitoring.backend.infra.entity.codevalue.CodeGroupInfoEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodeGroupInfoRes {

	@Schema(description = "코드 그룹 시퀀스")
	private long codeGroupSeq;
	@Schema(description = "코드 그룹 id")
	private String codeGroupId;
	@Schema(description = "코드 그룹 이름")
	private String codeGroupName;
}
