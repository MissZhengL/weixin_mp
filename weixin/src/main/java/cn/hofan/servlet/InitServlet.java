/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import cn.hofan.thread.TokenThread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author lizhenhai
 * @version $Id: InitServlet.java, v 0.1 2015年9月24日 上午9:48:07 lizhenhai Exp $
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(InitServlet.class);  

	public void init() throws ServletException {
		// 获取web.xml中配置的参数
		TokenThread.appid = getInitParameter("appid");
		TokenThread.appsecret = getInitParameter("appsecret");

		log.info("weixin api appid:{"+TokenThread.appid+"}");
		log.info("weixin api appsecret:{"+TokenThread.appsecret+"}");

		// 未配置appid、appsecret时给出提示
		if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {
			log.error("appid and appsecret configuration error, please check carefully.");
		} else {
			// 启动定时获取access_token的线程
//			new Thread(new TokenThread()).start();
			new TokenThread().run();
		}
	}
}
