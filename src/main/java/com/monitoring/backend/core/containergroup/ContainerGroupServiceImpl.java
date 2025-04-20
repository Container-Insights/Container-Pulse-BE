package com.monitoring.backend.core.containergroup;

import static com.monitoring.backend.config.response.exception.CustomExceptionStatus.*;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.monitoring.backend.config.response.exception.CustomException;
import com.monitoring.backend.config.response.exception.CustomExceptionStatus;
import com.monitoring.backend.dto.req.containergroup.ContainerGroupListReq;
import com.monitoring.backend.dto.res.containergroup.ContainerGroupInfoRes;
import com.monitoring.backend.dto.res.containergroup.ContainerGroupListRes;
import com.monitoring.backend.infra.repository.containergroup.ContainerGroupQueryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContainerGroupServiceImpl implements ContainerGroupService {

	private final ContainerGroupQueryRepository containerGroupQueryRepository;

	@Override
	public List<ContainerGroupListRes> getContainerGroupList(ContainerGroupListReq req, Pageable pageable) {
		return containerGroupQueryRepository.findContainerGroups(req, pageable);
	}

	@Override
	public ContainerGroupInfoRes getContainerGroupInfo(long conGroupSeq) {
		return containerGroupQueryRepository.findContainerGroupById(conGroupSeq)
			.orElseThrow(()->new CustomException(NOT_FOUND_CONTAINER_GROUP));
	}
}
