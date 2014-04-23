/*****************************************************************************
 *
 *                      FORNOW PROPRIETARY INFORMATION
 *
 *          The information contained herein is proprietary to ForNow
 *           and shall not be reproduced or disclosed in whole or in part
 *                    or used for any design or manufacture
 *              without direct written authorization from ForNow.
 *
 *            Copyright (c) 2014 by ForNow.  All rights reserved.
 *
 *****************************************************************************/
package com.fn.fornow.common.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Jiafa Lv
 * @date Apr 23, 2014 11:24:21 AM
 * @email simon-jiafa@126.com
 * 
 */
public class ApplicationContextHelper implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext
	 * (org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ApplicationContextHelper.applicationContext = applicationContext;
	}

	public static Object getBean(String beanName) {

		return applicationContext.getBean(beanName);
	}
}
