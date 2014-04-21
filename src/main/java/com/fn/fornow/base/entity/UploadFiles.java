/*****************************************************************************
 *
 *                      FORNOW PROPRIETARY INFORMATION
 *
 *          The information contained herein is proprietary to ForNow
 *           and shall not be reproduced or disclosed in whole or in part
 *                    or used for any design or manufacture
 *              without direct written authorization from ForNow.
 *
 *            Copyright (c) 2014 by ForNow.  All rights reserved.
 *
 *****************************************************************************/
package com.fn.fornow.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fn.fornow.common.Cons;
import com.fn.fornow.common.orm.entity.BaseEntity;

/**
 * @author Jiafa Lv
 * @date Apr 21, 2014 10:58:37 AM
 * @email simon-jiafa@126.com
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = Cons.simonswPrefix + "upload")
public class UploadFiles extends BaseEntity {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "upload_id")
	private Long uploadid;
	
	private String filepath;

	/**
	 * @return the uploadid
	 */
	public Long getUploadid() {
		return uploadid;
	}

	/**
	 * @param uploadid the uploadid to set
	 */
	public void setUploadid(Long uploadid) {
		this.uploadid = uploadid;
	}

	/**
	 * @return the filepath
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * @param filepath the filepath to set
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
}
