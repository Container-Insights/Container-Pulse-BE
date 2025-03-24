package com.monitoring.backend.core.cluster;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monitoring.backend.dto.res.cluster.ClusterInfoRes;
import com.monitoring.backend.dto.res.cluster.ClusterListRes;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClusterServiceImpl implements ClusterService{

	@Override
	public List<ClusterListRes> getClusterList() {
		return List.of();
	}

	@Override
	public ClusterInfoRes getClusterInfo() {
		return null;
	}
}
