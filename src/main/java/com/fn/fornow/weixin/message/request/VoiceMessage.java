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
 * 音频消息
 * 
 * @author Jiafa Lv
 * @date Apr 15, 2014
 */
public class VoiceMessage extends BaseMessage {
	// 媒体ID
	private String medioId;
	// 语音格式
	private String format;
	/**
	 * @return the medioId
	 */
	public String getMedioId() {
		return medioId;
	}
	/**
	 * @param medioId the medioId to set
	 */
	public void setMedioId(String medioId) {
		this.medioId = medioId;
	}
	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}
}
