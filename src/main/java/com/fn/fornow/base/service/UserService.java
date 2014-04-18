/**
 * 
 */
package com.fn.fornow.base.service;

import com.fn.fornow.base.entity.Users;
import com.fn.fornow.common.orm.dao.BaseDao;

/**
 * @author Simon Lv
 * @since Oct 29, 2013
 */
public interface UserService extends BaseDao<Users> {
	public boolean isExistUser(Users loginUser);
	public Users getUserByName(String username);
}
