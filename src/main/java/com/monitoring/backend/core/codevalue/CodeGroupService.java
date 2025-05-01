package com.monitoring.backend.core.codevalue;

import java.util.List;

import com.monitoring.backend.infra.entity.codevalue.CodeGroupInfoEntity;

public interface CodeGroupService {

	//코드 그룹 목록 조회
	List<CodeGroupInfoEntity> getCodeGroupList(String name);
}
