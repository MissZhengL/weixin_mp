/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.weixin.bean;

/**
 * 
 * @author lizhenhai
 * @version $Id: OpenidAndErpcode.java, v 0.1 2015年10月26日 上午11:57:24 lizhenhai Exp $
 */
public class OpenidAndErpcode {
	private String openid;
	private String erpcode;
	private String time;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getErpcode() {
		return erpcode;
	}
	public void setErpcode(String erpcode) {
		this.erpcode = erpcode;
	}
	
}
