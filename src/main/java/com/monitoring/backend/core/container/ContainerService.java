package com.monitoring.backend.core.container;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.monitoring.backend.dto.req.cluster.ClusterListReq;
import com.monitoring.backend.dto.req.container.ContainerListReq;
import com.monitoring.backend.dto.res.cluster.ClusterInfoRes;
import com.monitoring.backend.dto.res.cluster.ClusterListRes;
import com.monitoring.backend.dto.res.container.ContainerInfoRes;
import com.monitoring.backend.dto.res.container.ContainerListRes;

public interface ContainerService {

	/*컨테이너 목록 조회*/
	List<ContainerListRes> getContainerList(ContainerListReq req, Pageable pageable);

	/*컨테이너 상세 조회*/
	ContainerInfoRes getContainerInfo(long containerSeq);
}
