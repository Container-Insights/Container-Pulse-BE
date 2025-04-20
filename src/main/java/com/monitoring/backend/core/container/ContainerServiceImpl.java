package com.monitoring.backend.core.container;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.monitoring.backend.config.response.exception.CustomException;
import com.monitoring.backend.config.response.exception.CustomExceptionStatus;
import com.monitoring.backend.dto.req.container.ContainerListReq;
import com.monitoring.backend.dto.res.cluster.ClusterInfoRes;
import com.monitoring.backend.dto.res.cluster.ClusterListRes;
import com.monitoring.backend.dto.res.container.ContainerInfoRes;
import com.monitoring.backend.dto.res.container.ContainerListRes;
import com.monitoring.backend.infra.repository.container.ContainerQueryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContainerServiceImpl implements ContainerService {

	private final ContainerQueryRepository containerQueryRepository;

	@Override
	public List<ContainerListRes> getContainerList(ContainerListReq req, Pageable pageable) {
		return containerQueryRepository.findContainers(req, pageable);
	}

	@Override
	public ContainerInfoRes getContainerInfo(long containerSeq) {
		return containerQueryRepository.findContainerById(containerSeq)
			.orElseThrow(() -> new CustomException(CustomExceptionStatus.NOT_FOUND_CONTAINER));
	}
}
