package com.monitoring.backend.api.node;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monitoring.backend.config.response.DataResponse;
import com.monitoring.backend.config.response.ResponseService;
import com.monitoring.backend.core.node.NodeService;
import com.monitoring.backend.dto.req.node.NodeListReq;
import com.monitoring.backend.dto.res.node.NodeInfoRes;
import com.monitoring.backend.dto.res.node.NodeListRes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NodeController {

	private final NodeService nodeService;
	private final ResponseService responseService;

	/**
	 * 노드 목록 조회
	 * @param nodeListReq
	 * @param pageable
	 * @return
	 *
	 */
	@GetMapping("nodes")
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
	@GetMapping("nodes/{nodeSeq}")
	public DataResponse<NodeInfoRes> getNodeInfo(
		@PathVariable(name = "nodeSeq") long nodeSeq
	){
		return responseService.getDataResponse(nodeService.getNodeInfo(nodeSeq));
	}

}
