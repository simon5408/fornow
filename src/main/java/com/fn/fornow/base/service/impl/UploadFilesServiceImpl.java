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
package com.fn.fornow.base.service.impl;

import org.springframework.stereotype.Service;

import com.fn.fornow.base.entity.UploadFiles;
import com.fn.fornow.base.service.UploadFilesService;
import com.fn.fornow.common.orm.dao.HibernateDaoSupport;

/**
 * @author Jiafa Lv
 * @date Apr 21, 2014 11:02:51 AM
 * @email simon-jiafa@126.com
 * 
 */
@Service
public class UploadFilesServiceImpl extends HibernateDaoSupport<UploadFiles> implements
		UploadFilesService {

}
