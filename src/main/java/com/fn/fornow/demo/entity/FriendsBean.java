/**
 * 
 */
package com.fn.fornow.demo.entity;

/**
 * @author Simon Lv
 * @date Oct 23, 2013
 */
public class FriendsBean {
	private String name = null;
	private int sex = 0;
	private int year = 0;
	
	public FriendsBean(String name, int sex, int year){
		this.name = name;
		this.sex = sex;
		this.year = year;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	
	
}
