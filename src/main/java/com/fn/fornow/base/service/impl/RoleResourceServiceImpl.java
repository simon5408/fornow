/**
 * 
 */
package com.fn.fornow.base.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fn.fornow.base.entity.Role;
import com.fn.fornow.base.entity.RoleResource;
import com.fn.fornow.base.service.RoleResourceService;
import com.fn.fornow.common.orm.dao.HibernateDaoSupport;

/**
 * @author Simon Lv
 * @since Oct 31, 2013
 */
@Service
public class RoleResourceServiceImpl extends HibernateDaoSupport<RoleResource> implements
		RoleResourceService {

	/* (non-Javadoc)
	 * @see com.fn.fornow.base.service.RoleResourceService#getUserRoleByRoleId(long)
	 */
	@Override
	public List<RoleResource> getUserRoleByRoleId(Role role) {
		return findDatas("role", role);
	}

}
