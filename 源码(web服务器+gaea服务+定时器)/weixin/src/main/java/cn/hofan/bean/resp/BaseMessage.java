/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.bean.resp;

/**
 * 
 * @author lizhenhai
 * @version $Id: BaseMessage.java, v 0.1 2015年8月24日 下午2:49:25 lizhenhai Exp $
 */
public class BaseMessage {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	
}
