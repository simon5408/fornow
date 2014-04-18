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
package com.fn.fornow.weixin.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.fn.fornow.utils.MyX509TrustManager;
import com.fn.fornow.weixin.pojo.AccessToken;

/**
 * 公众平台通用接口工具类
 * 
 * @author Jiafa Lv
 * @date Apr 16, 2014
 */
public class WeixinUtil {
	private static final Logger log = Logger.getLogger(WeixinUtil.class);
	
	public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	public final static String URL_APPID = "APPID";
	public final static String URL_APPSECRET = "APPSECRET";
	
	public final static String URL_METHOD_GET = "GET";
	public final static String URL_METHOD_POST = "POST";
	
	public final static String WX_ACCESS_TOKEN = "access_token";
	public final static String WX_EXPIRES_IN = "expires_in";
	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式(GET/POST)
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject (通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpsRquest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer sb = new StringBuffer();

		// 创建SSLContext对象，并使用我们指定的信任管理器初始化
		TrustManager[] tm = { new MyX509TrustManager() };
		try {
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);

			HttpsURLConnection httpsUrlConn = (HttpsURLConnection) url
					.openConnection();

			httpsUrlConn.setSSLSocketFactory(ssf);
			httpsUrlConn.setDoInput(true);
			httpsUrlConn.setDoOutput(true);
			httpsUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpsUrlConn.setRequestMethod(requestMethod);

			if (URL_METHOD_GET.equalsIgnoreCase(requestMethod)) {
				httpsUrlConn.connect();
			}

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream os = httpsUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				os.write(outputStr.getBytes("UTF-8"));
				os.close();
			}

			// 将返回的输入流转换成字符串
			InputStream is = httpsUrlConn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);

			String str = null;

			while ((str = br.readLine()) != null) {
				sb.append(str);
			}

			// 释放资源
			br.close();
			isr.close();
			is.close();
			is = null;
			httpsUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(sb.toString());

		} catch (NoSuchAlgorithmException e) {
			log.error("[httpsRquest] NoSuchAlgorithmException", e);
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			log.error("[httpsRquest] NoSuchProviderException", e);
			e.printStackTrace();
		} catch (KeyManagementException e) {
			log.error("[httpsRquest] KeyManagementException", e);
			e.printStackTrace();
		} catch (MalformedURLException e) {
			log.error("[httpsRquest] MalformedURLException", e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error("[httpsRquest] IOException", e);
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	/**
	 * Get AccessToken
	 * @param appid
	 * @param appsecret
	 * @return
	 */
	public static AccessToken getAccessToken(String appid, String appsecret){
		AccessToken accessToken = null;
		String requestUrl = ACCESS_TOKEN_URL.replace(URL_APPID, appid).replace(URL_APPSECRET, appsecret);
		
		JSONObject jsonObject = httpsRquest(requestUrl, URL_METHOD_GET, null);
		
		if(null != jsonObject){
			accessToken = new AccessToken();
			accessToken.setToken(jsonObject.getString(WX_ACCESS_TOKEN));
			accessToken.setExpiresIn(jsonObject.getInt(WX_EXPIRES_IN));
		}
		return accessToken;
	}
}
