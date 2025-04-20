package com.monitoring.backend.api.container;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monitoring.backend.config.response.DataResponse;
import com.monitoring.backend.config.response.ResponseService;
import com.monitoring.backend.core.container.ContainerService;
import com.monitoring.backend.dto.req.container.ContainerListReq;
import com.monitoring.backend.dto.res.container.ContainerInfoRes;
import com.monitoring.backend.dto.res.container.ContainerListRes;
import com.monitoring.backend.dto.res.containergroup.ContainerGroupListRes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ContainerController {

	private final ContainerService containerService;
	private final ResponseService responseService;

	/**
	 * 컨테이너 목록 조회.
	 * @param req
	 * @param pageable
	 * @return
	 */
	@GetMapping("containers")
	public DataResponse<List<ContainerListRes>> getContainerList(
		@RequestBody ContainerListReq req,
		Pageable pageable
	){
		return responseService.getDataResponse(containerService.getContainerList(req, pageable));
	}

	/**
	 * 컨테이너 단건 정보 조회.
	 * @param containerSeq
	 * @return
	 */
	@GetMapping("containers/{containerSeq}")
	public DataResponse<ContainerInfoRes> getContainerInfo(
		@PathVariable(name = "containerSeq") long containerSeq
	){
		return responseService.getDataResponse(containerService.getContainerInfo(containerSeq));
	}
}
