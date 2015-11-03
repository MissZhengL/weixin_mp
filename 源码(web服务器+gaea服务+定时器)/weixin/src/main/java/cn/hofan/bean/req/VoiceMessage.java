/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.bean.req;

/**
 * 
 * @author lizhenhai
 * @version $Id: VoiceMessage.java, v 0.1 2015年8月24日 下午2:28:13 lizhenhai Exp $
 */
public class VoiceMessage extends BaseMessage {
	private String MediaId;
	private String Format;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	
}
