/**
 * 
 */
package com.fn.fornow.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @author Simon Lv
 * @since Nov 5, 2013
 */
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.web.authentication.logout.LogoutSuccessHandler
	 * #onLogoutSuccess(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.Authentication)
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		if (authentication != null) {
			logger.debug(authentication.getName() + "Logout==>");
		}
		response.sendRedirect(request.getContextPath());

	}

}
