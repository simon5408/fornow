/**
 * 
 */
package com.fn.fornow.base.service.impl;

import org.springframework.stereotype.Service;

import com.fn.fornow.base.entity.Resource;
import com.fn.fornow.base.service.ResourceService;
import com.fn.fornow.common.orm.dao.HibernateDaoSupport;

/**
 * @author Simon Lv
 * @since Oct 31, 2013
 */
@Service
public class ResourceServiceImpl extends HibernateDaoSupport<Resource> implements
		ResourceService {

}
