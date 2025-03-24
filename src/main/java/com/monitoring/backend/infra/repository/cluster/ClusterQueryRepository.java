package com.monitoring.backend.infra.repository.cluster;


import static com.monitoring.backend.infra.entity.QClusterInfoEntity.*;
import static com.monitoring.backend.infra.entity.codevalue.QCodeInfoEntity.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.monitoring.backend.dto.res.cluster.ClusterInfoRes;
import com.monitoring.backend.dto.res.cluster.ClusterListRes;

import com.monitoring.backend.infra.entity.codevalue.CodeInfoEntity;
import com.monitoring.backend.infra.entity.codevalue.QCodeInfoEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ClusterQueryRepository {

	private final JPAQueryFactory queryFactory;

	//TODO : 추후에 클러스터 타입이나 인증 정보로 조건을 걸어서 해당 정보로 가져올 수 있게 해야 함.

	/*목록 조회*/
	public List<ClusterListRes> getClusterList(Pageable pageable) {
		// return queryFactory
		// 	.select(
		// 		Projections.fields(
		// 			ClusterListRes.class,
		//
		// 		)
		// 	)
		// 	.from(clusterInfoEntity)
		// 	.leftJoin(codeInfoEntity).on(
		// 		clusterInfoEntity.clusterType.eq(codeInfoEntity.codeId))
		// 	.fetchJoin()
		// 	.fetch();


	}

	//TODO : 클러스터 ID,클러스터 Name, 클러스터 타입으로 조회 가능하도록 변경 필요.
	/*단건 조회*/
	public Optional<ClusterInfoRes> getClusterInfo(long clusterId) {

		return Optional.ofNullable(
			queryFactory
				.select(
					Projections.fields(
						ClusterInfoRes.class,
						clusterInfoEntity.clusterSeq,
						clusterInfoEntity.clusterName,
						codeInfoEntity.codeName,
						clusterInfoEntity.createdTime.as("createdDt"),
						clusterInfoEntity.updatedTime.as("updatedDt")
					)
				)
				.from(clusterInfoEntity)
				.where(clusterInfoEntity.clusterSeq.eq(clusterId))
				.leftJoin(codeInfoEntity).on(
					clusterInfoEntity.clusterType.eq(codeInfoEntity.codeId))
				.fetchJoin()
				.fetchOne()
		);
	}
}
