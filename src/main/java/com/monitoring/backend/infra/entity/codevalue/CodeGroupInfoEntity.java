package com.monitoring.backend.infra.entity.codevalue;

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
@Table(name = "code_group_info")
public class CodeGroupInfoEntity extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_group_seq")
	private long codeGroupSeq;

	@Column(name = "code_group_id", length = 50, nullable = false)
	private String codeGroupId;

	@Column(name = "code_group_name", length = 50, nullable = false)
	private String codeGroupName;

	@Column(name = "del_yn", columnDefinition = "boolean default false not null")
	private boolean delYn;
}
