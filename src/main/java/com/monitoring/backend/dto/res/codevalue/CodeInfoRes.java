package com.monitoring.backend.dto.res.codevalue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodeInfoRes {

	@Schema(description = "코드 시퀀스")
	private long codeSeq;
	@Schema(description = "코드 id")
	private String codeId;
	@Schema(description = "코드 이름")
	private String codeName;
}
