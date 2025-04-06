package com.monitoring.backend.core.cluster;

import static com.monitoring.backend.config.response.exception.CustomExceptionStatus.*;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.monitoring.backend.config.response.exception.CustomException;
import com.monitoring.backend.dto.req.cluster.ClusterListReq;
import com.monitoring.backend.dto.res.cluster.ClusterInfoRes;
import com.monitoring.backend.dto.res.cluster.ClusterListRes;
import com.monitoring.backend.infra.repository.cluster.ClusterQueryRepository;
import com.monitoring.backend.infra.repository.cluster.ClusterRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClusterServiceImpl implements ClusterService{

	private final ClusterQueryRepository clusterQueryRepository;

	@Override
	public List<ClusterListRes> getClusterList(ClusterListReq req, Pageable pageable) {
		return clusterQueryRepository.findClusters(req, pageable);
	}

	@Override
	public ClusterInfoRes getClusterInfo(long clusterSeq) {

		return clusterQueryRepository.findClusterById(clusterSeq)
			.orElseThrow(() -> new CustomException(NOT_FOUND_CLUSTER));

	}
}
