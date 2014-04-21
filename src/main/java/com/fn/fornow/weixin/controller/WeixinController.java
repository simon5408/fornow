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
package com.fn.fornow.weixin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fn.fornow.common.controller.CommonController;
import com.fn.fornow.common.controller.Module;
import com.fn.fornow.weixin.service.CoreService;

/**
 * @author Jiafa Lv
 * @date Apr 21, 2014 10:05:57 AM
 * 
 */
@Controller
@RequestMapping("/weixin")
public class WeixinController extends CommonController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getRequest(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void postMessage(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String responseMsg = CoreService.processRequest(request);
			
			logger.debug(String.format("RESPONSE STRING :%s", responseMsg));
			
			PrintWriter out = response.getWriter();
			out.print(responseMsg);
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see com.fn.fornow.common.controller.CommonController#getModule()
	 */
	@Override
	protected String getModule() {
		return Module.example.getName();
	}

}
