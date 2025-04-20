package com.monitoring.backend.infra.repository.container;

import static com.monitoring.backend.infra.entity.QContainerInfoEntity.*;
import static com.monitoring.backend.infra.entity.QContainerStatEntity.*;
import static com.monitoring.backend.infra.entity.QNodeInfoEntity.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.monitoring.backend.dto.req.container.ContainerListReq;
import com.monitoring.backend.dto.res.container.ContainerInfoRes;
import com.monitoring.backend.dto.res.container.ContainerListRes;
import com.monitoring.backend.infra.entity.QContainerInfoEntity;
import com.monitoring.backend.infra.entity.QContainerStatEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ContainerQueryRepository{

	private final JPAQueryFactory queryFactory;

	/*컨테이너 목록 조회*/
	public List<ContainerListRes> findContainers(ContainerListReq containerListReq, Pageable pageable){

		return queryFactory
			.select(
				Projections.fields(
					ContainerListRes.class,
					containerInfoEntity.containerSeq,
					containerInfoEntity.containerId,
					containerInfoEntity.containerName,
					containerInfoEntity.status
				)
			)
			.from(containerInfoEntity)
			.where(
				containerInfoEntity.delYn.eq(false),
				containerInfoEntity.containerGroupEntity.conGroupSeq.eq(containerListReq.getConGroupSeq()),
				cursorPaging(containerListReq.getLastSeq())
			)
			.orderBy(containerInfoEntity.createdTime.desc(), containerInfoEntity.containerSeq.asc())
			.limit(pageable.getPageSize())
			.fetch();
	}
	/*컨테이너 단건 정보 조회*/
	public Optional<ContainerInfoRes> findContainerById(long containerSeq){

		QContainerStatEntity statusTable = new QContainerStatEntity("statusTable");

		return Optional.ofNullable(
			queryFactory
				.select(
					Projections.fields(
						ContainerInfoRes.class,
						containerInfoEntity.containerSeq,
						containerInfoEntity.containerId,
						containerInfoEntity.containerName,
						containerInfoEntity.containerImage,
						containerInfoEntity.createdTime.as("createdDt")
					)
				)
				.from(containerInfoEntity)
				.leftJoin(containerStatEntity)
				.on(
					containerInfoEntity.delYn.eq(false),
					containerInfoEntity.containerSeq.eq(containerSeq),
					containerStatEntity.createdTime.eq(
						JPAExpressions
							.select(statusTable.createdTime.max())
							.from(statusTable)
							.where(statusTable.containerInfoEntity.eq(containerInfoEntity))
					)
				)
				.fetchOne()
		);
	}



	/*동적 쿼리 조건들*/

	//커서기반
	private BooleanExpression cursorPaging(long lastSeq){

		if(lastSeq == 0) return null;

		return containerInfoEntity.containerSeq.gt(lastSeq);
	}
}
