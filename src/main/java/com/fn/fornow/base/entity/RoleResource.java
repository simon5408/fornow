/**
 * 
 */
package com.fn.fornow.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = Cons.simonswPrefix + "role_resource")
public class RoleResource extends BaseEntity {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "role_rs_id")
	private Long rolersid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource_id")
	private Resource resource;

	/**
	 * @return the rolersid
	 */
	public Long getRolersid() {
		return rolersid;
	}

	/**
	 * @param rolersid the rolersid to set
	 */
	public void setRolersid(Long rolersid) {
		this.rolersid = rolersid;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the resource
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * @param resource the resource to set
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
