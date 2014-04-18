/**
 * 
 */
package com.fn.fornow.common.util;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Simon Lv
 * @date Oct 24, 2013
 */
public class HttpUtils {
	/**
	 * 
	 * @param response
	 * @param jsonStr
	 * @throws Exception
	 */
	public static void respWrite(HttpServletResponse response, String jsonStr)
			throws Exception {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(jsonStr);
		writer.flush();
		writer.close();
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String getReqJson(HttpServletRequest request)
			throws Exception {
		BufferedReader reader = request.getReader();
		StringBuffer buffer = new StringBuffer();
		String str;
		while ((str = reader.readLine()) != null) {
			buffer.append(str);
		}
		reader.close();

		return buffer.toString();
	}
}
