package com.monitoring.backend.infra.entity.common;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

	@CreatedDate
	@Column(name = "created_dt", updatable = false, nullable = false)
	private LocalDateTime createdTime;

	@LastModifiedDate
	@Column(name = "updated_dt", nullable = false)
	private LocalDateTime updatedTime;
}
