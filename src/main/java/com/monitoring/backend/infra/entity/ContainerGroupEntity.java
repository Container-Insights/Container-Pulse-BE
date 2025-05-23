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
@Table(name = "container_group")
public class ContainerGroupEntity extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "con_group_seq")
	private long conGroupSeq;

	@Column(name = "con_group_id", length = 255, nullable = false)
	private String conGroupId;

	@Column(name = "con_group_type", length = 10, nullable = false)
	private String conGroupType;

	@Column(name = "con_group_name", length = 255, nullable = false)
	private String conGroupName;

	@Column(name = "del_yn", columnDefinition = "boolean default false not null")
	private boolean delYn = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "node_seq", nullable = false)
	private NodeInfoEntity nodeInfoEntity;

}
