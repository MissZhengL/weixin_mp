/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.bean.req;

/**
 * 
 * @author lizhenhai
 * @version $Id: LinkMessage.java, v 0.1 2015年8月24日 下午2:26:43 lizhenhai Exp $
 */
public class LinkMessage extends BaseMessage {
	private String Title;
	private String Description;
	private String Url;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
}
