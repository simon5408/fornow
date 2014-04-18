/**
 * 
 */
package com.fn.fornow.demo.entity;

import java.util.List;

/**
 * @author Simon Lv
 * @date Oct 23, 2013
 */
public class JsonBean {
 private String name = null;
 private int sex = 0;
 private List<FriendsBean> frines;
 
 public JsonBean(String name, int sex, List<FriendsBean> frines){
	 this.frines = frines;
	 this.name = name;
	 this.sex = sex;
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
 * @return the frines
 */
public List<FriendsBean> getFrines() {
	return frines;
}
}
