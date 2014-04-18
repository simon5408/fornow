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
package com.fn.fornow.weixin.pojo;

/**
 * 复杂按钮（父按钮）
 * 
 * @author Jiafa Lv
 * @date Apr 16, 2014
 */
public class ComplexButton extends Button {

	private Button[] subButton;

	/**
	 * @return the subButton
	 */
	public Button[] getSubButton() {
		return subButton;
	}

	/**
	 * @param subButton the subButton to set
	 */
	public void setSubButton(Button[] subButton) {
		this.subButton = subButton;
	}
}
