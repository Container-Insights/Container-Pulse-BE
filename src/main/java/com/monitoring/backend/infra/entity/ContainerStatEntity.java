package com.monitoring.backend.infra.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicUpdate;

import com.monitoring.backend.infra.entity.common.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "container_stat")
public class ContainerStatEntity extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "container_status_seq")
	private long containerStatusSeq;

	@Column(name = "cpu_usage", nullable = false)
	private int cpuUsage;

	@Column(name = "memory_usage", nullable = false)
	private long memoryUsage;

	//TODO : baseTimeEntity외에 로그성 데이터 처럼 생성일자만 필요한 테이블용 entity를 만들어서 별도로 상속받게 하는 것이 좋아보임.
	//업데이트 일자 컬럼은 필요없음
	@Transient
	@Override
	public LocalDateTime getUpdatedTime() {
		return null;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "container_seq", nullable = false)
	private ContainerInfoEntity containerInfoEntity;

}
