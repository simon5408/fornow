/**
 * 
 */
package com.fn.fornow.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fn.fornow.base.entity.Resource;
import com.fn.fornow.base.entity.Role;
import com.fn.fornow.base.entity.RoleResource;
import com.fn.fornow.base.entity.UserRole;
import com.fn.fornow.base.entity.Users;
import com.fn.fornow.base.service.RoleResourceService;
import com.fn.fornow.base.service.UserRoleService;
import com.fn.fornow.base.service.UserService;
import com.fn.fornow.common.util.StringUtils;

/**
 * @author Simon Lv
 * @since Oct 31, 2013
 */
public class MyAuthenticationManager implements UserDetailsService {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RoleResourceService roleResourceService;
	private Logger logger = LoggerFactory.getLogger(getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		logger.debug("[MyAuthenticationManager] username ==> " + username);
		if (!StringUtils.isNoEmpty(username)) {
			throw new UsernameNotFoundException("用户名不能为空！");
		}
		Users user = userService.getUserByName(username);
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);

		boolean enables = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		// 封装成spring security的user
		User userdetail = new User(user.getUsername(), user.getPassword(),
				enables, accountNonExpired, credentialsNonExpired,
				accountNonLocked, grantedAuths);
		return userdetail;
	}

	// 取得用户的权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(Users user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		List<Resource> resources = new ArrayList<Resource>();
		Role role;
		List<RoleResource> roleResources;
		List<UserRole> userRoles = userRoleService.getUserRoleByUserId(user);
		for (UserRole userRole : userRoles) {
			role = userRole.getRole();
			roleResources = roleResourceService.getUserRoleByRoleId(role);
			for (RoleResource roleResource : roleResources) {
				resources.add(roleResource.getResource());
			}
		}

		for (Resource res : resources) {
			authSet.add(new SimpleGrantedAuthority(res.getModelname()));
		}
		return authSet;
	}
}
