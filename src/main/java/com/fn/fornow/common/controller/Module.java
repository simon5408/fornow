package com.fn.fornow.common.controller;

/**
 * @author Simon Lv
 * @since 2012-8-9
 */
public enum Module {

	example("example");

	String name;

	Module(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
