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
package com.fn.fornow.common.init;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

/**
 * Init to load System property info when Server start
 * 
 * @author Jiafa Lv
 * @date Apr 22, 2014 11:08:18 AM
 * @email simon-jiafa@126.com
 * 
 */
public class Initializer extends HttpServlet {
	private static final Logger log = Logger.getLogger(Initializer.class);
	private static final long serialVersionUID = 1L;
	public static boolean runAlready = false;

	/**
	 * Initializes the servlet.
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		if (runAlready) {
			log.error("Initializer already run, exiting init()");
			return;
		}
		runAlready = true;
		// Now, set up the application's config file.
		SystemPropertyInit.getInstance();
	}

	/**
	 * Destroys the servlet.
	 */
	public void destroy() {
		log.debug("Initializer servlet destroyed.");
	}
}
