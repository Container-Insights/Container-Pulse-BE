package com.monitoring.backend.infra.repository.containergroup;

import static com.monitoring.backend.infra.entity.QContainerGroupEntity.*;
import static com.monitoring.backend.infra.entity.codevalue.QCodeInfoEntity.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.monitoring.backend.dto.req.containergroup.ContainerGroupListReq;
import com.monitoring.backend.dto.res.containergroup.ContainerGroupInfoRes;
import com.monitoring.backend.dto.res.containergroup.ContainerGroupListRes;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ContainerGroupQueryRepository {

	private final JPAQueryFactory queryFactory;

	/*목록 조회*/
	public List<ContainerGroupListRes> findContainerGroups(ContainerGroupListReq containerGroupListReq, Pageable pageable){

		return queryFactory
			.select(
				Projections.fields(
					ContainerGroupListRes.class,
					containerGroupEntity.conGroupSeq,
					containerGroupEntity.conGroupId,
					containerGroupEntity.conGroupName,
					codeInfoEntity.codeName.as("conGroupTypeName")
				)
			)
			.from(containerGroupEntity)
			.leftJoin(codeInfoEntity).on(
				containerGroupEntity.conGroupType.eq(codeInfoEntity.codeId)
			)
			.fetchJoin()
			.where(
				containerGroupEntity.delYn.eq(false),
				containerGroupEntity.nodeInfoEntity.nodeSeq.eq(containerGroupListReq.getNodeSeq()),
				cursorPaging(containerGroupListReq.getLastSeq())
			)
			.orderBy(
				containerGroupEntity.createdTime.desc(),
				containerGroupEntity.conGroupSeq.asc()
			)
			.limit(pageable.getPageSize())
			.fetch();
	}

	/*단건 조회*/
	public Optional<ContainerGroupInfoRes> findContainerGroupById(long conGroupSeq){

		return Optional.ofNullable(
			queryFactory
				.select(
					Projections.fields(
						ContainerGroupInfoRes.class,
						containerGroupEntity.conGroupSeq,
						containerGroupEntity.conGroupId,
						containerGroupEntity.conGroupName,
						codeInfoEntity.codeName.as("conGroupTypeName"),
						containerGroupEntity.createdTime.as("createdDt"),
						containerGroupEntity.updatedTime.as("updatedDt")
					)
				)
				.from(containerGroupEntity)
				.where(
					containerGroupEntity.delYn.eq(false),
					containerGroupEntity.conGroupSeq.eq(conGroupSeq)
				)
				.leftJoin(codeInfoEntity)
				.on(
					containerGroupEntity.conGroupType.eq(codeInfoEntity.codeId)
				)
				.fetchJoin()
				.fetchOne()
		);
	}


	/*동적 쿼리 조건들*/

	//커서기반
	private BooleanExpression cursorPaging(long lastSeq){

		if(lastSeq == 0) return null;

		return containerGroupEntity.conGroupSeq.gt(lastSeq);
	}
}
