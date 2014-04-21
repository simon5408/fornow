package com.fn.fornow.common.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fn.fornow.base.service.UploadFilesService;
import com.fn.fornow.base.service.UserService;
import com.fn.fornow.common.ViewName;
import com.fn.fornow.demo.service.DemoService;
import com.google.common.collect.Sets;

/**
 * @author Simon Lv
 * @since 2012-8-9
 */
public abstract class CommonController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected abstract String getModule();

	protected String forward(ViewName viewName) {
		String path = this.getClass().getAnnotation(RequestMapping.class).value()[0];
		logger.debug("[CommonController] whole path ==> "+getModule() + path.replaceAll("-", "") + path + viewName.getValue());
		return getModule() + path.replaceAll("-", "") + path + viewName.getValue();
	}

	protected String redirect(String action) {
		return ViewName.redirect.getValue() + action;
	}

	protected String show = "show";
	protected String edit = "edit";
	protected String update = "update";
	protected Set<String> methods = Sets.newHashSet(show, edit, update);

	protected Long extractId(String requestURI) {
		for (String method : methods) {
			method = "/" + method + "/";
			if (StringUtils.contains(requestURI, method)) {
				String id = requestURI.substring(requestURI.indexOf(method) + method.length());
				if (id.indexOf("/") != -1) {
					id = id.substring(0, id.indexOf("/"));
				}
				if (NumberUtils.isNumber(id)) {
					return Long.valueOf(id);
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	protected void extractParams(HttpServletRequest request) {
		Enumeration<String> keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String[] values = request.getParameterValues(key);
			String paramName = key.replaceAll("\\.", "_");
			if (values.length > 1) {
				Arrays.sort(values);
				request.setAttribute(paramName, values[0]);
				request.setAttribute(paramName + "_", values[1]);
			} else {
				request.setAttribute(paramName, request.getParameter(key));
			}
		}
	}

	protected void addMethod(Collection<String> methods) {
		this.methods.addAll(methods);
	}

	@Autowired
	protected DemoService demoService;

	@Autowired
	protected UserService userService;
	
	@Autowired
	protected UploadFilesService uploadFilesService;
}
