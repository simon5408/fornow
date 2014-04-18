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
@Table(name = Cons.simonswPrefix + "role")
public class Role extends BaseEntity {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "role_id")
	private Long roleid;
	
	private String name;
	private String description;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the roleid
	 */
	public Long getRoleid() {
		return roleid;
	}
	/**
	 * @param roleid the roleid to set
	 */
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	
}
