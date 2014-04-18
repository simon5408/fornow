/**
 * 
 */
package com.fn.fornow.base.service.impl;

import org.springframework.stereotype.Service;

import com.fn.fornow.base.entity.Role;
import com.fn.fornow.base.service.RoleService;
import com.fn.fornow.common.orm.dao.HibernateDaoSupport;

/**
 * @author Simon Lv
 * @since Oct 31, 2013
 */
@Service
public class RoleServiceImpl extends HibernateDaoSupport<Role> implements
		RoleService {

}
