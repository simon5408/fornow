/**
 * 
 */
package com.fn.fornow.base.service;

import java.util.List;

import com.fn.fornow.base.entity.Role;
import com.fn.fornow.base.entity.RoleResource;
import com.fn.fornow.common.orm.dao.BaseDao;

/**
 * @author Simon Lv
 * @since Oct 31, 2013
 */
public interface RoleResourceService extends BaseDao<RoleResource> {

	public List<RoleResource> getUserRoleByRoleId(Role role);
}
