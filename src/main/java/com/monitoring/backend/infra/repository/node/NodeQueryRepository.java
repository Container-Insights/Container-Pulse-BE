package com.monitoring.backend.infra.repository.node;

import static com.monitoring.backend.infra.entity.QClusterInfoEntity.*;
import static com.monitoring.backend.infra.entity.QNodeInfoEntity.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.monitoring.backend.dto.req.node.NodeListReq;
import com.monitoring.backend.dto.res.node.NodeInfoRes;
import com.monitoring.backend.dto.res.node.NodeListRes;
import com.monitoring.backend.infra.entity.NodeInfoEntity;
import com.monitoring.backend.infra.entity.QNodeInfoEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class NodeQueryRepository {

	private final JPAQueryFactory queryFactory;

	/*노드 목록 조회*/
	public List<NodeListRes> findNodes(NodeListReq nodeListReq, Pageable pageable){


		return queryFactory
			.select(
				Projections.fields(
					NodeListRes.class,
					nodeInfoEntity.nodeSeq,
					nodeInfoEntity.nodeId,
					nodeInfoEntity.nodeName,
					nodeInfoEntity.ipAddress
				)
			)
			.from(nodeInfoEntity)
			.where(
				nodeInfoEntity.clusterInfoEntity.clusterSeq.eq(nodeListReq.getClusterSeq()),
				cursorPaging(nodeListReq.getLastSeq())
			)
			.orderBy(nodeInfoEntity.createdTime.desc(), nodeInfoEntity.nodeSeq.asc())
			.limit(pageable.getPageSize())
			.fetch();
	}

	/*노드 단건 조회*/

	public Optional<NodeInfoRes> findNodeById(long nodeSeq){

		return Optional.ofNullable(
			queryFactory
				.select(
					Projections.fields(
						NodeInfoRes.class,
						nodeInfoEntity.nodeSeq,
						nodeInfoEntity.nodeId,
						nodeInfoEntity.nodeName,
						nodeInfoEntity.ipAddress,
						nodeInfoEntity.createdTime.as("createdDt"),
						nodeInfoEntity.updatedTime.as("updatedDt")
					)
				)
				.from(nodeInfoEntity)
				.where(
					nodeInfoEntity.delYn.eq(false),
					nodeInfoEntity.nodeSeq.eq(nodeSeq)
				)
				.fetchOne()
		);

	}



	//TODO 동적 쿼리 조건들 중 커서 페이징 처럼 공통으로 사용되는 것들은 추후 공통으로 묶에서 사용하는것도 좋을 듯.
	/*동적 쿼리 조건들*/

	//커서기반
	private BooleanExpression cursorPaging(long lastSeq){

		if(lastSeq == 0) return null;

		return nodeInfoEntity.nodeSeq.gt(lastSeq);
	}
}
