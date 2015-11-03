/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.thread;

import java.io.File;

import cn.hofan.bean.AccessToken;
import cn.hofan.util.FileUtil;
import cn.hofan.util.WeixinUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 
 * @author lizhenhai
 * @version $Id: TokenThread.java, v 0.1 2015年9月24日 上午9:54:41 lizhenhai Exp $
 */
public class TokenThread implements Runnable{
	private static Log log = LogFactory.getLog(TokenThread.class);
	// 第三方用户唯一凭证
	public static String appid = "";
	// 第三方用户唯一凭证密钥
	public static String appsecret = "";
	public static AccessToken accessToken = null;
	int n = 1;
	
	@Override
	public void run() {
		while (true) {
			try {
				accessToken = WeixinUtil.getAccessToken(appid, appsecret);
				if (null != accessToken) {
					log.info("第"+(n++)+"次获取access_token成功，有效时长{"+accessToken.getExpiresIn()+"}秒  token:{"+accessToken.getToken()+"}");
					File fileName = null;
					try {
						fileName = FileUtil.createFile("/opt/soft/tomcat_weixin/webapps","accesstoken.txt");
						FileUtil.writeTxtFile(accessToken.getToken(), fileName);
					} catch (Exception e) {
						log.error("存储access_token失败,休眠7000秒后重新获取...",e);
					}
					// 休眠7000秒
					Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);
				} else {
					// 如果access_token为null，60秒后再获取
					log.error("获取access_token失败,access_token为null,1分钟后重新获取...");
					Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException e) {
				try {
					log.error("获取access_token出错,access_token为null,1分钟后重新获取...");
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e1) {
					log.error("{}", e1);
				}
				log.error("{}", e);
			}
		}
	}

}
