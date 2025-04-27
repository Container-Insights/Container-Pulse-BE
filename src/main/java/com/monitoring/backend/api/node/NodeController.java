package com.monitoring.backend.api.node;

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
import com.monitoring.backend.core.node.NodeService;
import com.monitoring.backend.dto.req.node.NodeListReq;
import com.monitoring.backend.dto.res.node.NodeInfoRes;
import com.monitoring.backend.dto.res.node.NodeListRes;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Node", description = "node 관련 API")
public class NodeController {

	private final NodeService nodeService;
	private final ResponseService responseService;

	@ApiCommonDoc(
		summary = "노드 목록 조회",
		description = "클러스터 식별자를 이용해서 클러스터에 속한 노드 목록 조회(페이징 적용)",
		tags = {"Node"}
	)
	@PageableAsQueryParam
	@PostMapping("nodes")
	public DataResponse<List<NodeListRes>> getNodeList(
		@RequestBody NodeListReq nodeListReq,
		Pageable pageable
	){
		return responseService.getDataResponse(nodeService.getNodeList(nodeListReq, pageable));
	}

	/**
	 * 단건 노드 정보 조회.
	 * @param nodeSeq
	 * @return
	 */
	@ApiCommonDoc(
		summary = "노드 단건 조회",
		description = "노드 식별자(시퀀스)로 노드 정보 조회(페이징 적용)",
		tags = {"Node"}
	)
	@Parameters({
		@Parameter(
			name = "nodeSeq",
			description = "노드 식별자",
			required = true,
			in = ParameterIn.PATH
		)
	})
	@GetMapping("nodes/{nodeSeq}")
	public DataResponse<NodeInfoRes> getNodeInfo(
		@PathVariable(name = "nodeSeq") long nodeSeq
	){
		return responseService.getDataResponse(nodeService.getNodeInfo(nodeSeq));
	}

}
