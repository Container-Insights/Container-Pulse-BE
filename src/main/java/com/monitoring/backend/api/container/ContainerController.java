package com.monitoring.backend.api.container;

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
import com.monitoring.backend.core.container.ContainerService;
import com.monitoring.backend.dto.req.container.ContainerListReq;
import com.monitoring.backend.dto.res.container.ContainerInfoRes;
import com.monitoring.backend.dto.res.container.ContainerListRes;
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
@Tag(name = "Container", description = "컨테이너 그룹 관련 API")
public class ContainerController {

	private final ContainerService containerService;
	private final ResponseService responseService;

	/**
	 * 컨테이너 목록 조회.
	 * @param req
	 * @param pageable
	 * @return
	 */
	@ApiCommonDoc(
		summary = "컨테이너 목록 조회",
		description = "컨테이너 그룹(pod) 식별자를 이용해서 컨테이너 그룹(pod)에 속한 컨테이너 목록 조회(페이징 적용)",
		tags = {"Container"}
	)
	@PageableAsQueryParam
	@PostMapping("containers")
	public DataResponse<List<ContainerListRes>> getContainerList(
		@RequestBody ContainerListReq req,
		Pageable pageable
	){
		return responseService.getDataResponse(containerService.getContainerList(req, pageable));
	}

	@ApiCommonDoc(
		summary = "컨테이너 단건 조회",
		description = "컨테이너 식별자(시퀀스)로 컨테이너 정보 조회(페이징 적용)",
		tags = {"Container"}
	)
	@Parameters({
		@Parameter(
			name = "containerSeq",
			description = "컨테이너 식별자",
			required = true,
			in = ParameterIn.PATH
		)
	})
	@GetMapping("containers/{containerSeq}")
	public DataResponse<ContainerInfoRes> getContainerInfo(
		@PathVariable(name = "containerSeq") long containerSeq
	){
		return responseService.getDataResponse(containerService.getContainerInfo(containerSeq));
	}
}
