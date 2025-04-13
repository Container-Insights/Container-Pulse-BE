package com.monitoring.backend.core.node;

import static com.monitoring.backend.config.response.exception.CustomExceptionStatus.*;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.monitoring.backend.config.response.exception.CustomException;
import com.monitoring.backend.dto.req.node.NodeListReq;
import com.monitoring.backend.dto.res.node.NodeInfoRes;
import com.monitoring.backend.dto.res.node.NodeListRes;
import com.monitoring.backend.infra.repository.node.NodeQueryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NodeServiceImpl implements NodeService {

	private final NodeQueryRepository nodeQueryRepository;

	@Override
	public List<NodeListRes> getNodeList(NodeListReq req, Pageable pageable) {
		return nodeQueryRepository.findNodes(req, pageable);
	}

	@Override
	public NodeInfoRes getNodeInfo(long nodeSeq) {

		return nodeQueryRepository.findNodeById(nodeSeq)
			.orElseThrow(() -> new CustomException(NOT_FOUND_NODE));
	}
}
