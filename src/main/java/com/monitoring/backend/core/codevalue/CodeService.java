package com.monitoring.backend.core.codevalue;

import java.util.List;

import com.monitoring.backend.infra.entity.codevalue.CodeInfoEntity;

public interface CodeService {

	//코드 목록 조회
	List<CodeInfoEntity> getCodeList(long codeGroupSeq, String name);
}
