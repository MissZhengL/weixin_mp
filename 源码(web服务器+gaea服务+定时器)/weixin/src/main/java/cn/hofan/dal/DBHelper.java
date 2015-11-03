/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.dal;


import java.io.File;

import cn.hofan.spat.db.dal.DAOHelper;
import cn.hofan.spat.db.dal.pool.DBPoolFactory;
import cn.hofan.util.Path;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author lizhenhai
 * @version $Id: DBHelper.java, v 0.1 2015年9月15日 下午4:10:40 lizhenhai Exp $
 */
public class DBHelper {
	protected static final Log logger = LogFactory.getLog(DBHelper.class);
	/**
	 * 供应商门户数据库
	 */
	public static DAOHelper daoHelperSP = null;
	public static DAOHelper daoHelperERP = null;
	
	static {
		try {
			String configPathsp = Path.getCurrentPath() + File.separator
					+ "config"+File.separator+"PersonalInfo.properties";
//			logger.info("db config path:" + configPath);
			daoHelperSP = new DAOHelper(DBPoolFactory.getDBConnectionPool(configPathsp));
			String configPatherp = Path.getCurrentPath() + File.separator
					+ "config"+File.separator+"ERPServer.properties";
//			logger.info("db config path:" + configPath);
			daoHelperERP = new DAOHelper(DBPoolFactory.getDBConnectionPool(configPatherp));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
