package com.monitoring.backend.api.codevalue;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monitoring.backend.config.response.DataResponse;
import com.monitoring.backend.config.response.ResponseService;
import com.monitoring.backend.config.swagger.annotation.ApiCommonDoc;
import com.monitoring.backend.core.codevalue.CodeGroupService;
import com.monitoring.backend.core.codevalue.CodeService;
import com.monitoring.backend.core.codevalue.CodeServiceImpl;
import com.monitoring.backend.dto.res.codevalue.CodeGroupInfoRes;
import com.monitoring.backend.dto.res.codevalue.CodeInfoRes;
import com.monitoring.backend.infra.entity.codevalue.CodeGroupInfoEntity;
import com.monitoring.backend.infra.entity.codevalue.CodeInfoEntity;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@Tag(name = "Code", description = "Code 값 관련 API")
public class CodeValueController {

	private final CodeGroupService codeGroupService;
	private final CodeService codeService;
	private final ResponseService responseService;

	@ApiCommonDoc(
		summary = "코드 그룹 목록 조회",
		description = "코드 그룹 목록 조회(name으로도 조회가능)",
		tags = {"Code"}
	)
	@Parameters({
		@Parameter(
			name = "name",
			description = "코드 이름",
			required = false,
			in = ParameterIn.QUERY
		)
	})
	@GetMapping("/codeGroups")
	public DataResponse<List<CodeGroupInfoRes>> getCodeGroupInfo(
		@RequestParam(name = "name", required = false) String name
	){

		//응답용 DTO로 변환
		List<CodeGroupInfoRes> codeGroupInfoResList = codeGroupService.getCodeGroupList(name).stream()
			.map(CodeGroupInfoEntity::toResDto)
			.toList();

		return responseService.getDataResponse(codeGroupInfoResList);

	}

	@ApiCommonDoc(
		summary = "코드 목록 조회",
		description = "코드그룹 식별자를 이용해 코드 목록 조회(name으로도 조회가능)",
		tags = {"Code"}
	)
	@Parameters({
		@Parameter(
			name = "codeGroupSeq",
			description = "코드 그룹 식별자(시퀀스)",
			required = true,
			in = ParameterIn.PATH
		),
		@Parameter(
			name = "name",
			description = "코드 이름",
			required = false,
			in = ParameterIn.QUERY
		)
	})
	@GetMapping("/codes/{codeGroupSeq}")
	public DataResponse<List<CodeInfoRes>> getCodeInfo(
		@PathVariable(name = "codeGroupSeq") long codeGroupSeq,
		@RequestParam(name = "name", required = false) String name
	){

		//응답용 DTO로 변환.
		List<CodeInfoRes> codeInfoResList = codeService.getCodeList(codeGroupSeq, name).stream()
			.map(CodeInfoEntity::toResDto)
			.toList();

		return responseService.getDataResponse(codeInfoResList);
	}


}
