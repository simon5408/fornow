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
@Table(name = Cons.simonswPrefix + "user_role")
public class UserRole extends BaseEntity {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "role_us_id")
	private Long roleusid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users user;

	/**
	 * @return the roleusid
	 */
	public Long getRoleusid() {
		return roleusid;
	}

	/**
	 * @param roleusid the roleusid to set
	 */
	public void setRoleusid(Long roleusid) {
		this.roleusid = roleusid;
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
	 * @return the user
	 */
	public Users getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Users user) {
		this.user = user;
	}
}
