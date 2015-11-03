/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.bean;

/**
 * 
 * @author lizhenhai
 * @version $Id: ComplexButton.java, v 0.1 2015年9月7日 上午10:06:44 lizhenhai Exp $
 */
public class ComplexButton extends Button {
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	
}
