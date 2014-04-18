/**
 * 
 */
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
 * @author Simon Lv
 * @since Oct 31, 2013
 */
@SuppressWarnings("serial")
@Entity
@Table(name = Cons.simonswPrefix + "resource")
public class Resource extends BaseEntity {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "resource_id")
	private Long resourceid;
	
	private String type;
	private String value;
	private String modelname;
	private String parentid;
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the modelname
	 */
	public String getModelname() {
		return modelname;
	}
	/**
	 * @param modelname the modelname to set
	 */
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	/**
	 * @return the parentid
	 */
	public String getParentid() {
		return parentid;
	}
	/**
	 * @param parentid the parentid to set
	 */
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	/**
	 * @return the resourceid
	 */
	public Long getResourceid() {
		return resourceid;
	}
	/**
	 * @param resourceid the resourceid to set
	 */
	public void setResourceid(Long resourceid) {
		this.resourceid = resourceid;
	}
}
