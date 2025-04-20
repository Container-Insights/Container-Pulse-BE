package com.monitoring.backend.infra.repository.container;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitoring.backend.infra.entity.ContainerInfoEntity;

public interface ContainerRepository extends JpaRepository<Long, ContainerInfoEntity> {
}
