package com.monitoring.backend.infra.repository.containergroup;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitoring.backend.infra.entity.ContainerGroupEntity;

public interface ContainerGroupRepository extends JpaRepository<ContainerGroupEntity, Long> {
}
