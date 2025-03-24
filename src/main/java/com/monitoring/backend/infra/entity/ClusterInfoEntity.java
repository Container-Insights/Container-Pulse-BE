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
@Table(name = "cluster_info")
public class ClusterInfoEntity extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cluster_seq")
	private long clusterSeq;

	@Column(name = "cluster_id")
	private String clusterId;

	@Column(name = "cluster_name")
	private String clusterName;

	@Column(name = "cluster_type")
	private String clusterType;

	@Column(name = "del_yn")
	private boolean delYn = false;
}
