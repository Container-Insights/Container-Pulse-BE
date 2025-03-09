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
@Table(name = "host")
public class HostEntity extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "host_seq")
	private long hostSeq;

	@Column(name = "cluster_name")
	private String clusterName;

	@Column(name = "node_name")
	private String nodeName;

	@Column(name = "ip_address")
	private String ipAddress;

	@Column(name = "del_yn")
	private boolean delYn;
}
