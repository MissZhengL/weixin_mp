/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.bean.resp;

/**
 * 
 * @author lizhenhai
 * @version $Id: PicMessage.java, v 0.1 2015年10月16日 上午10:29:11 lizhenhai Exp $
 */
public class ImageMessage extends BaseMessage {
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
	
}
