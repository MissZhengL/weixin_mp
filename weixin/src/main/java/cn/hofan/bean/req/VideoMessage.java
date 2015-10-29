/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.bean.req;

/**
 * 
 * @author lizhenhai
 * @version $Id: VideoMessage.java, v 0.1 2015年8月24日 下午2:42:39 lizhenhai Exp $
 */
public class VideoMessage extends BaseMessage{
	private String MediaId;
	private String ThumbMediaId;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
}
