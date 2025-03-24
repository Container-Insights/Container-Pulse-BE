package com.monitoring.backend.infra.entity.codevalue;

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
@Table(name = "code_info")
public class CodeInfoEntity extends BaseTimeEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_seq")
	private long codeSeq;

	@Column(name = "code_id")
	private String codeId;

	@Column(name = "code_name")
	private String codeName;

	@Column(name = "del_yn", nullable = false)
	private boolean delYn = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_group_seq", nullable = false)
	private CodeGroupInfoEntity codeGroupInfoEntity;

}
