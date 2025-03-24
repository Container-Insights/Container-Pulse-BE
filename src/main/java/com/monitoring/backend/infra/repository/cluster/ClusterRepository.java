package com.monitoring.backend.infra.repository.cluster;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitoring.backend.infra.entity.ClusterInfoEntity;

public interface ClusterRepository extends JpaRepository<ClusterInfoEntity, Long> {
}
