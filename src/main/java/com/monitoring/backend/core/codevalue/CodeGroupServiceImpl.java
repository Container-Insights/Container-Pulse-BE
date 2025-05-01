package com.monitoring.backend.core.codevalue;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monitoring.backend.infra.entity.codevalue.CodeGroupInfoEntity;
import com.monitoring.backend.infra.repository.codevalue.CodeGroupInfoRepository;
import com.monitoring.backend.infra.repository.codevalue.CodeGroupQueryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeGroupServiceImpl implements CodeGroupService {

	private final CodeGroupQueryRepository codeGroupQueryRepository;

	@Override
	public List<CodeGroupInfoEntity> getCodeGroupList(String name) {
		return codeGroupQueryRepository.findCodeGroups(name);
	}

}
