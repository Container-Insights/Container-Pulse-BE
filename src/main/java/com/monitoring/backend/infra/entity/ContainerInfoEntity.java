package com.monitoring.backend.infra.entity;

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
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@DynamicUpdate
@Entity
@Table(name = "container_info")
public class ContainerInfoEntity extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "container_seq")
	private long containerSeq;

	@Column(name = "container_id", length = 255, nullable = false)
	private String containerId;

	@Column(name = "container_name", length = 255, nullable = false)
	private String containerName;

	@Column(name = "container_type", length = 50, nullable = false)
	private String containerType;

	@Column(name = "container_image", length = 255, nullable = false)
	private String containerImage;

	@Column(name = "status", length = 255, nullable = false)
	private String status;

	@Column(name = "del_yn", columnDefinition = "boolean default false not null")
	private boolean delYn = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "con_group_seq", nullable = false)
	private ContainerGroupEntity containerGroupEntity;
}
