package com.monitoring.backend.core.containergroup;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.monitoring.backend.dto.req.containergroup.ContainerGroupListReq;
import com.monitoring.backend.dto.res.containergroup.ContainerGroupInfoRes;
import com.monitoring.backend.dto.res.containergroup.ContainerGroupListRes;

public interface ContainerGroupService {

	/*컨테이너 그룹(쿠버에서 pod) 목록 조회*/
	List<ContainerGroupListRes> getContainerGroupList(ContainerGroupListReq containerGroupListReq, Pageable pageable);

	/*컨테이너 그룹(쿠버에서 pod) 상세 조회*/
	ContainerGroupInfoRes getContainerGroupInfo(long conGroupSeq);

}
