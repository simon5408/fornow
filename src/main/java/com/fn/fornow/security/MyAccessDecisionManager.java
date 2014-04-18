/**
 * 
 */
package com.fn.fornow.security;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Simon Lv
 * @since Oct 31, 2013
 */
public class MyAccessDecisionManager implements AccessDecisionManager {
	private Logger logger = LoggerFactory.getLogger(getClass());
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.AccessDecisionManager#decide(org.
	 * springframework.security.core.Authentication, java.lang.Object,
	 * java.util.Collection)
	 */
	@Override
	public void decide(Authentication authentication, Object obj,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {
			return;
		}
		// 所请求的资源拥有的权限(一个资源对多个权限)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			// 访问所请求资源所需要的权限
			String needPermission = configAttribute.getAttribute();
			logger.debug("[MyAccessDecisionManager] needPermission is " + needPermission);
			// 用户所拥有的权限authentication
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				logger.debug("[MyAccessDecisionManager] ga.getAuthority() is " + ga.getAuthority());
				if (needPermission.contains((ga.getAuthority()))) {
					return;
				}
			}
		}
		// 没有权限让我们去捕捉
		throw new AccessDeniedException(" 没有权限访问！");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.AccessDecisionManager#supports(org
	 * .springframework.security.access.ConfigAttribute)
	 */
	@Override
	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.AccessDecisionManager#supports(java
	 * .lang.Class)
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
