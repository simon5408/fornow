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
package com.fn.fornow.base.entity;

/**
 * @author Jiafa Lv
 * @date Apr 23, 2014 10:31:24 AM
 * @email simon-jiafa@126.com
 * 
 */
public class EmailInfo {

	private String mailSubject;
	private String mailTo;
	private String mailToName;
	private String mailContent;
	/**
	 * @return the mailSubject
	 */
	public String getMailSubject() {
		return mailSubject;
	}
	/**
	 * @param mailSubject the mailSubject to set
	 */
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	/**
	 * @return the mailTo
	 */
	public String getMailTo() {
		return mailTo;
	}
	/**
	 * @param mailTo the mailTo to set
	 */
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	/**
	 * @return the mailToName
	 */
	public String getMailToName() {
		return mailToName;
	}
	/**
	 * @param mailToName the mailToName to set
	 */
	public void setMailToName(String mailToName) {
		this.mailToName = mailToName;
	}
	/**
	 * @return the mailContent
	 */
	public String getMailContent() {
		return mailContent;
	}
	/**
	 * @param mailContent the mailContent to set
	 */
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
}
