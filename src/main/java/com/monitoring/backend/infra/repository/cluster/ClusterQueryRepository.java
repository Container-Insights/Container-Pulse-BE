package com.monitoring.backend.infra.repository.cluster;


import static com.monitoring.backend.infra.entity.QClusterInfoEntity.*;
import static com.monitoring.backend.infra.entity.codevalue.QCodeInfoEntity.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.monitoring.backend.dto.req.cluster.ClusterListReq;
import com.monitoring.backend.dto.res.cluster.ClusterInfoRes;
import com.monitoring.backend.dto.res.cluster.ClusterListRes;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ClusterQueryRepository {

	private final JPAQueryFactory queryFactory;

	//TODO : 추후에 클러스터 타입이나 인증 정보로 조건을 걸어서 해당 정보로 가져올 수 있게 해야 함.

	/*목록 조회*/
	public List<ClusterListRes> findClusters(ClusterListReq clusterListReq, Pageable pageable) {

		return queryFactory
			.select(
				Projections.fields(
					ClusterListRes.class,
					clusterInfoEntity.clusterSeq,
					clusterInfoEntity.clusterId,
					clusterInfoEntity.clusterName,
					codeInfoEntity.codeName.as("clusterTypeName")
				)
			)
			.from(clusterInfoEntity)
			.leftJoin(codeInfoEntity).on(
				clusterInfoEntity.clusterType.eq(codeInfoEntity.codeId))
			.fetchJoin()
			.where(
				clusterInfoEntity.delYn.eq(false),
				cursorPaging(clusterListReq.getLastSeq()),
				typeCheck(clusterListReq.getClusterType()))
			.orderBy(clusterInfoEntity.createdTime.desc(), clusterInfoEntity.clusterSeq.asc())
			.limit(pageable.getPageSize())
			.fetch();
	}

	//TODO : 클러스터 ID,클러스터 Name, 클러스터 타입으로 조회 가능하도록 변경 필요.
	/*단건 조회*/
	public Optional<ClusterInfoRes> findClusterById(long clusterSeq) {
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
				.where(
					clusterInfoEntity.delYn.eq(false),
					clusterInfoEntity.clusterSeq.eq(clusterSeq))
				.leftJoin(codeInfoEntity).on(
					clusterInfoEntity.clusterType.eq(codeInfoEntity.codeId))
				.fetchJoin()
				.fetchOne()
		);
	}

	/*동적 쿼리 조건들*/

	//커서기반
	private BooleanExpression cursorPaging(long lastSeq){

		if(lastSeq == 0) return null;

		return clusterInfoEntity.clusterSeq.gt(lastSeq);
	}

	private BooleanExpression typeCheck(String type){

		if(type == null) return null;

		return clusterInfoEntity.clusterType.eq(type);
	}
}
