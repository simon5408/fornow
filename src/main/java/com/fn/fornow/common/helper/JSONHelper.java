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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Jiafa Lv
 * @date Apr 22, 2014 2:18:11 PM
 * @email simon-jiafa@126.com
 * 
 */
public class JSONHelper {
	
	/**
	 * 将JSON字符串转化成实体Bean对象
	 * 
	 * @param json
	 * @param classOfT
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> classOfT) {
		return new Gson().fromJson(json, classOfT);
	}

	/**
	 * 将实体Bean对象转化成JSON字符串
	 * 
	 * @param jsonElement
	 * @return
	 */
	public static String toJson(Object jsonElement) {
		return new Gson().toJson(jsonElement);
	}

	/**
	 * 将JSON字符串转化成泛型的数据集合
	 * 
	 * @param json
	 * @param typeToken
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T fromJson(String json, TypeToken<T> typeToken) {
		return (T) new Gson().fromJson(json, typeToken.getType());
	}

}
