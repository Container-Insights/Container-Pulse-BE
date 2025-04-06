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
@Table(name = "node_info")
public class NodeInfoEntity extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "node_seq")
	private long nodeSeq;

	@Column(name = "node_id", length = 255, nullable = false)
	private String nodeId;

	@Column(name = "node_name", length = 255, nullable = true)
	private String nodeName;

	@Column(name = "ip_address", length = 255, nullable = false)
	private String ipAddress;

	@Column(name = "del_yn", columnDefinition = "boolean default false not null")
	private boolean delYn = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cluster_seq")
	private ClusterInfoEntity clusterInfoEntity;
}
