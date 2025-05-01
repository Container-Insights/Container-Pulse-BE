package com.monitoring.backend.infra.repository.codevalue;

import static com.monitoring.backend.infra.entity.codevalue.QCodeGroupInfoEntity.*;
import static com.monitoring.backend.infra.entity.codevalue.QCodeInfoEntity.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.monitoring.backend.infra.entity.codevalue.CodeGroupInfoEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CodeGroupQueryRepository {

	private final JPAQueryFactory queryFactory;


	//목록 조회.
	public List<CodeGroupInfoEntity> findCodeGroups(String name){

		return queryFactory
			.selectFrom(codeGroupInfoEntity)
			.where(
				codeGroupNameCondition(name)
			)
			.orderBy(codeGroupInfoEntity.codeGroupSeq.asc())
			.fetch();
	}

	/*동적쿼리 조건들*/

	private BooleanExpression codeGroupNameCondition(String name){

		if(name == null) return null;

		return codeGroupInfoEntity.codeGroupName.like("%"+ name +"%");
	}
}
