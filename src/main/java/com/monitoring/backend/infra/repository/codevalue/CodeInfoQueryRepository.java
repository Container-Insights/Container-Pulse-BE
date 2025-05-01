package com.monitoring.backend.infra.repository.codevalue;

import static com.monitoring.backend.infra.entity.codevalue.QCodeInfoEntity.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.monitoring.backend.infra.entity.codevalue.CodeInfoEntity;
import com.monitoring.backend.infra.entity.codevalue.QCodeInfoEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CodeInfoQueryRepository {

	private final JPAQueryFactory queryFactory;


	//목록 조회.
	public List<CodeInfoEntity> findCodeInfos(long codeGroupSeq, String name) {

		return queryFactory
			.selectFrom(codeInfoEntity)
			.where(
				codeGroupCondition(codeGroupSeq),
				codeNameCondition(name)
			)
			.orderBy(codeInfoEntity.codeSeq.asc())
			.fetch();
	}


	/*동적 쿼리 조건*/
	private BooleanExpression codeGroupCondition(long codeGroupSeq){
		if(codeGroupSeq == 0) return null;

		return codeInfoEntity.codeGroupInfoEntity.codeGroupSeq.eq(codeGroupSeq);

	}

	private BooleanExpression codeNameCondition(String name){

		if(name == null) return null;

		return codeInfoEntity.codeName.like("%"+ name +"%");
	}
}
