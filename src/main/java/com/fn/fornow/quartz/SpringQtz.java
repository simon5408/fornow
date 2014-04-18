/**
 * 
 */
package com.fn.fornow.quartz;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Simon Lv
 * @since Nov 11, 2013
 */
public class SpringQtz {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static int counter = 0;

	protected void execute() {
		long ms = System.currentTimeMillis();
		logger.info("\t\t" + new Date(ms));
		logger.info("(" + counter++ + ")");
	}
}
