package com.monitoring.backend.api.containergroup;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monitoring.backend.config.response.DataResponse;
import com.monitoring.backend.config.response.ResponseService;
import com.monitoring.backend.core.containergroup.ContainerGroupService;
import com.monitoring.backend.dto.req.containergroup.ContainerGroupListReq;
import com.monitoring.backend.dto.res.containergroup.ContainerGroupInfoRes;
import com.monitoring.backend.dto.res.containergroup.ContainerGroupListRes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ContainerGroupController {

	private final ResponseService responseService;
	private final ContainerGroupService containerGroupService;

	/**
	 * 컨테이너 그룹 목록 조회
	 * @param req
	 * @param pageable
	 * @return
	 */
	@GetMapping("conGroups")
	public DataResponse<List<ContainerGroupListRes>> getContainerGroupList(
		@RequestBody ContainerGroupListReq req,
		Pageable pageable
	){
		return responseService.getDataResponse(containerGroupService.getContainerGroupList(req, pageable));
	}

	/**
	 * 컨테이너 그룹 정보 조회
	 */
	@GetMapping("conGroups/{conGroupSeq}")
	public DataResponse<ContainerGroupInfoRes> getContainerGroupInfo(
		@PathVariable(name = "conGroupSeq") long conGroupSeq
	){
		return responseService.getDataResponse(containerGroupService.getContainerGroupInfo(conGroupSeq));
	}

}
