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
package com.fn.fornow.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author Jiafa Lv
 * @date Apr 22, 2014 3:52:01 PM
 * @email simon-jiafa@126.com
 * 
 */
public class FreemarkerUtils {
	public static final String ORIGIN_FTL_PATH = "/WEB-INF/ftl";
	public static final String STATIC_FTL_PATH = "/html/";

	/**
	 * 生成静态页面主方法
	 * 
	 * @param context
	 *            ServletContext
	 * @param data
	 *            一个Map的数据结果集
	 * @param templatePath
	 *            ftl模版路径
	 * @param targetHtmlPath
	 *            生成静态页面的路径
	 */
	public static void crateHTML(ServletContext context,
			Map<String, Object> data, String templatePath, String targetHtmlPath) {
		Configuration freemarkerCfg = new Configuration();
		// 加载模版
		freemarkerCfg.setServletContextForTemplateLoading(context,
				ORIGIN_FTL_PATH);
		freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
		try {
			// 指定模版路径
			Template template = freemarkerCfg
					.getTemplate(templatePath, "UTF-8");
			template.setEncoding("UTF-8");
			// 静态页面路径
			String htmlPath = context.getRealPath(STATIC_FTL_PATH)
					+ File.separator + targetHtmlPath;
			File htmlFile = new File(htmlPath);

			if (!htmlFile.exists()) {
				UploadUtils.makeDir(htmlFile.getParentFile());
				htmlFile.createNewFile();
			}

			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(htmlFile), "UTF-8"));
			// 处理模版
			template.process(data, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
