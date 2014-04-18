/**
 * 
 */
package com.fn.fornow.enums;

/**
 * @author Simon Lv
 * @since Oct 24, 2013
 */
public enum ReturnModule {
	success("SUCCESS"), failure("FAILURE");
	String status;
	
	ReturnModule(String status){
		this.status = status;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
}
