package com.monitoring.backend.api.cluster;

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
import com.monitoring.backend.core.cluster.ClusterService;
import com.monitoring.backend.dto.req.cluster.ClusterListReq;
import com.monitoring.backend.dto.res.cluster.ClusterInfoRes;
import com.monitoring.backend.dto.res.cluster.ClusterListRes;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Cluster", description = "cluster 관련 API")
public class ClusterController {

	private final ClusterService clusterService;
	private final ResponseService responseService;

	//TODO : 추후 유저 인증 기능이 추가되면, 유저가 보유한 클러스터인지 확인하는 valid도 필요.
	//TODO : 응답 스웨거의 경우, 제네릭 처리가 안되어서 별도로 스웨거용 클래스를 만들어야 하는데, 이부분은 고민 필요.
	/**
	 * 클러스터 목록 조회
	 * 검색조건으로 특정 타입에 해당하는 클러스터 조회가능하도록 설계.
	 */
	@ApiCommonDoc(
		summary = "클러스터 목록 조회",
		description = "클러스터 타입정보로 보유한 클러스터 목록 조회(페이징 적용)",
		tags = {"Cluster"}
	)
	@PageableAsQueryParam
	@PostMapping("clusters")
	public DataResponse<List<ClusterListRes>> getClusterList(
		@RequestBody ClusterListReq clusterListReq,
		Pageable pageable
	){
		return responseService.getDataResponse(clusterService.getClusterList(clusterListReq, pageable));
	}

	/**
	 * 특정 클러스터 정보 조회.
	 */
	@ApiCommonDoc(
		summary = "클러스터 단건 조회",
		description = "클러스터 식별자(시퀀스)로 보유한 클러스터 정보 조회",
		tags = {"Cluster"}
	)
	@Parameters({
		@Parameter(
			name = "clusterSeq",
			description = "클러스터 식별자",
			required = true,
			in = ParameterIn.PATH
		)
	})
	@GetMapping("cluster/{clusterSeq}")
	public DataResponse<ClusterInfoRes> getClusterInfo(
		@PathVariable(name = "clusterSeq") long clusterSeq
	){
		return responseService.getDataResponse(clusterService.getClusterInfo(clusterSeq));
	}


}
