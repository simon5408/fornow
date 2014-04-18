package com.fn.fornow.demo.service.impl;

import org.springframework.stereotype.Service;

import com.fn.fornow.common.orm.dao.HibernateDaoSupport;
import com.fn.fornow.demo.entity.Demo;
import com.fn.fornow.demo.service.DemoService;

/**
 * @author Simon Lv
 * @since 2012-8-9
 */
@Service
public class DemoServiceImpl extends HibernateDaoSupport<Demo> implements DemoService {


}
