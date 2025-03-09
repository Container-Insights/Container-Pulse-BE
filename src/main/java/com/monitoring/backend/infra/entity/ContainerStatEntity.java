package com.monitoring.backend.infra.entity;

import org.hibernate.annotations.DynamicUpdate;

import com.monitoring.backend.infra.entity.common.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@DynamicUpdate
@Entity
@Table(name = "container_stat")
public class ContainerStatEntity extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "container_status_seq")
	private long containerStatusSeq;

	@Column(name = "cpu_usage")
	private int cpuUsage;

	@Column(name = "memory_usage")
	private long memeoryUsage;

}
