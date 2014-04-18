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
package com.fn.fornow.weixin.message.request;

/**
 * 地理位置消息
 * 
 * @author Jiafa Lv
 * @date Apr 15, 2014
 */
public class LocationMessage extends BaseMessage {
	// 地理位置维度
	private String locationX;
	// 地理位置经度
	private String locationY;
	// 地图缩放大小
	private String scale;
	// 地理位置信息
	private String label;
	/**
	 * @return the locationX
	 */
	public String getLocationX() {
		return locationX;
	}
	/**
	 * @param locationX the locationX to set
	 */
	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}
	/**
	 * @return the locationY
	 */
	public String getLocationY() {
		return locationY;
	}
	/**
	 * @param locationY the locationY to set
	 */
	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}
	/**
	 * @return the scale
	 */
	public String getScale() {
		return scale;
	}
	/**
	 * @param scale the scale to set
	 */
	public void setScale(String scale) {
		this.scale = scale;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}
