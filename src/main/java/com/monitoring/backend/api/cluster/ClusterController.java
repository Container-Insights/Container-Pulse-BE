package com.monitoring.backend.api.cluster;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitoring.backend.config.response.DataResponse;
import com.monitoring.backend.dto.res.cluster.ClusterInfoRes;
import com.monitoring.backend.dto.res.cluster.ClusterListRes;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ClusterController {

	//TODO : 추후 유저 인증 기능이 추가되면, 유저가 보유한 클러스터인지 확인하는 valid도 필요.
	/**
	 * 클러스터 목록 조회
	 * 검색조건으로 특정 타입에 해당하는 클러스터 조회가능하도록 설계.
	 */
	@GetMapping("clusters")
	public DataResponse<List<ClusterListRes>> getClusterList(){

		return null;

	}

	/**
	 * 특정 클러스터 정보 조회.
	 */
	public DataResponse<ClusterInfoRes> getClusterInfo(){

		return null;
	}


}
