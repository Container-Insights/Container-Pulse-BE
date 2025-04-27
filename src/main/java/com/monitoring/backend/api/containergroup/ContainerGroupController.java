package com.monitoring.backend.api.containergroup;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monitoring.backend.config.response.DataResponse;
import com.monitoring.backend.config.response.ResponseService;
import com.monitoring.backend.config.swagger.annotation.ApiCommonDoc;
import com.monitoring.backend.config.swagger.annotation.PageableAsQueryParam;
import com.monitoring.backend.core.containergroup.ContainerGroupService;
import com.monitoring.backend.dto.req.containergroup.ContainerGroupListReq;
import com.monitoring.backend.dto.res.containergroup.ContainerGroupInfoRes;
import com.monitoring.backend.dto.res.containergroup.ContainerGroupListRes;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "ConGroup", description = "컨테이너 그룹 관련 API")
public class ContainerGroupController {

	private final ResponseService responseService;
	private final ContainerGroupService containerGroupService;

	@ApiCommonDoc(
		summary = "컨테이너 그룹(pod) 목록 조회",
		description = "노드 식별자를 이용해서 노드에 속한 컨테이너 그룹(pod) 목록 조회(페이징 적용)",
		tags = {"ConGroup"}
	)
	@PageableAsQueryParam
	@PostMapping("conGroups")
	public DataResponse<List<ContainerGroupListRes>> getContainerGroupList(
		@RequestBody ContainerGroupListReq req,
		Pageable pageable
	){
		return responseService.getDataResponse(containerGroupService.getContainerGroupList(req, pageable));
	}

	@ApiCommonDoc(
		summary = "컨테이너 그룹 단건 조회",
		description = "컨테이너 그룹(pod) 식별자(시퀀스)로 컨테이너 그룹(pod) 정보 조회(페이징 적용)",
		tags = {"ConGroup"}
	)
	@Parameters({
		@Parameter(
			name = "conGroupSeq",
			description = "컨테이너 그룹(pod) 식별자",
			required = true,
			in = ParameterIn.PATH
		)
	})
	@GetMapping("conGroups/{conGroupSeq}")
	public DataResponse<ContainerGroupInfoRes> getContainerGroupInfo(
		@PathVariable(name = "conGroupSeq") long conGroupSeq
	){
		return responseService.getDataResponse(containerGroupService.getContainerGroupInfo(conGroupSeq));
	}

}
