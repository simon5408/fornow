/**
 * 
 */
package com.fn.fornow.base.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fn.fornow.base.entity.UserRole;
import com.fn.fornow.base.entity.Users;
import com.fn.fornow.base.service.UserRoleService;
import com.fn.fornow.common.orm.dao.HibernateDaoSupport;

/**
 * @author Simon Lv
 * @since Oct 31, 2013
 */
@Service
public class UserRoleServiceImpl extends HibernateDaoSupport<UserRole> implements
		UserRoleService {

	/* (non-Javadoc)
	 * @see com.fn.fornow.base.service.UserRoleService#getUserRoleByUserId(long)
	 */
	@Override
	public List<UserRole> getUserRoleByUserId(Users user) {
		return findDatas("user", user);
	}

}
