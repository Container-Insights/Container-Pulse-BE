package com.monitoring.backend.infra.repository.node;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitoring.backend.infra.entity.NodeInfoEntity;

public interface NodeRepository extends JpaRepository<NodeInfoEntity, Long> {
}
