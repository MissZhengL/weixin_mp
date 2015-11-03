/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2014 All Rights Reserved.
 */
package cn.hofan.gaea;
import cn.hofan.commonTiming.CommonMethods;

import com.bj58.spat.gaea.client.GaeaInit;
import com.bj58.spat.gaea.client.proxy.builder.ProxyFactory;

/**
 * 
 * @author Leo
 * @version $Id: GaeaServiceFactory.java, v 0.1 2014年8月6日 上午9:27:33 Leo Exp $
 */
public class GaeaServiceFactory {

	static {
		GaeaInit.init(CommonMethods.getAppPath(GaeaServiceFactory.class)
				+ "/gaea.config");
	}
	
	public static <T> T createService(Class<T> x, String which) {
		String url = "tcp://" + which + "/" + x.getSimpleName();
		return ProxyFactory.create(x, url);
	}

	public static <T> T createWeiXinService(Class<T> x) {
		return createService(x, "weixin");
	}
}
