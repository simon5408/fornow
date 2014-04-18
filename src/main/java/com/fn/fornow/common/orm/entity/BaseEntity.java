package com.fn.fornow.common.orm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * @author Simon Lv
 * @since 2012-5-28
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

//	@Id
//	@GeneratedValue(generator = "increment")
//	@GenericGenerator(name = "increment", strategy = "increment")
//	private Long id;
	@Column(updatable = false)
	@Type(type = "com.fn.fornow.common.orm.entity.type.PersistentDateTime")
	private DateTime createDateTime;
	@Type(type = "com.fn.fornow.common.orm.entity.type.PersistentDateTime")
	private DateTime lastModifyDateTime;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public DateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(DateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public DateTime getLastModifyDateTime() {
		return lastModifyDateTime;
	}

	public void setLastModifyDateTime(DateTime lastModifyDateTime) {
		this.lastModifyDateTime = lastModifyDateTime;
	}

//	@Override
//	public String toString() {
//		return String.format("BaseEntity [id=%s, createDateTime=%s, lastModifyDateTime=%s]", id, createDateTime, lastModifyDateTime);
//	}

}
