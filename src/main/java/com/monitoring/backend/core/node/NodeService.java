package com.monitoring.backend.core.node;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.monitoring.backend.dto.req.node.NodeListReq;
import com.monitoring.backend.dto.res.node.NodeInfoRes;
import com.monitoring.backend.dto.res.node.NodeListRes;

public interface NodeService {

	/*노드 목록 조회*/
	List<NodeListRes> getNodeList(NodeListReq req, Pageable pageable);

	/*노드 상세 조회*/
	NodeInfoRes getNodeInfo(long nodeSeq);
}
