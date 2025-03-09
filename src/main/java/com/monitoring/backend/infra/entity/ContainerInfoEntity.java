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
@Table(name = "container_info")
public class ContainerInfoEntity extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "container_seq")
	private long containerSeq;

	@Column(name = "container_id")
	private String containerId;

	@Column(name = "container_name")
	private String containerName;

	@Column(name = "container_image")
	private String containerImage;

	@Column(name = "status")
	private String status;

	@Column(name = "del_yn")
	private boolean delYn;
}
