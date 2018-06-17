package com.estate.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -3016573137955555572L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@CreatedDate
	private Date createdDate;

	@Column
	@LastModifiedDate
	private Date modifiedDate;

	@Column
	@CreatedBy
	private String createdBy;

	@Column
	@LastModifiedBy
	private String modifiedBy;

	public Long getId() {
		return id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}
	
	public String getModifiedBy() {
		return modifiedBy;
	}
}
