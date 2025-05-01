package com.monitoring.backend.core.codevalue;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monitoring.backend.infra.entity.codevalue.CodeInfoEntity;
import com.monitoring.backend.infra.repository.codevalue.CodeInfoQueryRepository;
import com.monitoring.backend.infra.repository.codevalue.CodeInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService{

	private final CodeInfoQueryRepository codeInfoQueryRepository;

	@Override
	public List<CodeInfoEntity> getCodeList(long codeGroupSeq, String name) {
		return codeInfoQueryRepository.findCodeInfos(codeGroupSeq, name);
	}
}
