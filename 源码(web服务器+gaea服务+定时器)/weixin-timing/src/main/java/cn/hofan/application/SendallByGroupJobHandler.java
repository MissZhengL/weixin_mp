/**
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.application;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.hofan.gaea.GaeaServiceFactory;
import cn.hofan.util.DateUtil;
import cn.hofan.weixin.contract.ISendallService;


/**
 * 
 * @author lizhenhai
 * @version $Id: SendallByGroupJobHandler.java, v 0.1 2015年9月24日 下午7:13:07 lizhenhai Exp $
 */
public class SendallByGroupJobHandler extends BaseTimeJobHandler {

	private static Logger logger = LoggerFactory.getLogger(SendallByGroupJobHandler.class);
	private ISendallService service = GaeaServiceFactory.createWeiXinService(ISendallService.class);
	/** 
	 * @see cn.hofan.provider.IJobTimeHandler#CanRun(java.util.Date)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public boolean CanRun(Date d) {
		if (d.getHours()==15 || d.getHours()==16 || d.getHours()==17) {
			return true;
		}
		return false;
	}

	/** 
	 * @see cn.hofan.provider.IJobTimeHandler#Run()
	 */
	@Override
	public String Run() {
		logger.info("==开始按组群发图文消息 "+DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss")+"==");
		boolean sendallByGroup = false;
		try {
			sendallByGroup = service.sendallByGroup(101);
			if (sendallByGroup) {
				logger.info("==成功 "+DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss")+"==");
			}else {
				logger.info("==失败 "+DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss")+"==");
			}
		} catch (Exception e) {
			if (e.getMessage().indexOf("async task timeout") > -1) {
				logger.info("==查询超时,但群发还是成功的 "+DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss")+"==");
				
			}else {
				logger.error("==出错== ", e);
			}
		}
		return null;
		
	}

}
