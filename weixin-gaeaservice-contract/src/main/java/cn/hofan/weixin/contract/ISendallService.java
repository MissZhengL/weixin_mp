/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.weixin.contract;

import com.bj58.spat.gaea.server.contract.annotation.OperationContract;
import com.bj58.spat.gaea.server.contract.annotation.ServiceContract;

/**
 * 
 * @author lizhenhai
 * @version $Id: ISendallService.java, v 0.1 2015年9月24日 下午1:49:05 lizhenhai Exp $
 */
@ServiceContract
public interface ISendallService {

	/**
	 * 按组群发
	 * --默认组是 0 ;
	 * --星标组是 2 ;
	 * @param groupId
	 * @return
	 * @throws Exception 
	 */
	@OperationContract
	public boolean sendallByGroup(int groupId) throws Exception ;
}
