package com.monitoring.backend.infra.repository.codevalue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitoring.backend.infra.entity.codevalue.CodeGroupInfoEntity;

public interface CodeGroupInfoRepository extends JpaRepository<CodeGroupInfoEntity, Long> {
}
