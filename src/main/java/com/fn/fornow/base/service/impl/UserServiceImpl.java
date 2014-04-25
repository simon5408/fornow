/**
 * 
 */
package com.fn.fornow.base.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fn.fornow.base.entity.Users;
import com.fn.fornow.base.service.UserService;
import com.fn.fornow.common.orm.dao.HibernateDaoSupport;

/**
 * @author Simon Lv
 * @since Oct 29, 2013
 */
@Service
public class UserServiceImpl extends HibernateDaoSupport<Users> implements
		UserService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fn.fornow.base.service.UserService#isExistUser(com.fn.fornow.base
	 * .entity .User)
	 */
	@Override
	public boolean isExistUser(Users loginUser) {
		if (loginUser != null) {
			Users user = getUserByName(loginUser.getUsername());
			if (user != null) {
				if (user.getPassword()
						.equalsIgnoreCase(loginUser.getPassword())) {
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fn.fornow.base.service.UserService#getUserByName(java.lang.String)
	 */
	@Override
	public Users getUserByName(String username) {
		Users user = null;
		List<Users> users = findDatas("username", username);
		if (users != null && users.size() > 0) {
			user = users.get(0);
		}
		return user;
	}

}
