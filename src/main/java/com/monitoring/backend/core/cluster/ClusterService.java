package com.monitoring.backend.core.cluster;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.monitoring.backend.dto.req.cluster.ClusterListReq;
import com.monitoring.backend.dto.res.cluster.ClusterInfoRes;
import com.monitoring.backend.dto.res.cluster.ClusterListRes;

public interface ClusterService {

	/*클러스터 목록 조회*/
	List<ClusterListRes> getClusterList(ClusterListReq req, Pageable pageable);

	/*클러스터 상세 조회*/
	ClusterInfoRes getClusterInfo(long clusterSeq);
}
