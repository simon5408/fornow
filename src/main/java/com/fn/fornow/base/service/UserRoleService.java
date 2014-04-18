/**
 * 
 */
package com.fn.fornow.base.service;

import java.util.List;

import com.fn.fornow.base.entity.UserRole;
import com.fn.fornow.base.entity.Users;
import com.fn.fornow.common.orm.dao.BaseDao;

/**
 * @author Simon Lv
 * @since Oct 31, 2013
 */
public interface UserRoleService extends BaseDao<UserRole> {

	public List<UserRole> getUserRoleByUserId(Users user);
}
