/**
 * 
 */
package com.fn.fornow.demo.entity;

import com.google.gson.Gson;

/**
 * @author Simon Lv
 * @date Oct 24, 2013
 */
public class ReturnJsonBean {
	private String status = null;
	
	public ReturnJsonBean(String status){
		this.status = status;
	}
	
	public String toJson(){
		return new Gson().toJson(this);
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
}
