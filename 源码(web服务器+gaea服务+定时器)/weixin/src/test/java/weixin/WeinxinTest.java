/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package weixin;

import cn.hofan.dal.impl.SupplierDaoImpl;
import cn.hofan.util.Path;

import org.junit.Test;

/**
 * 
 * @author lizhenhai
 * @version $Id: UtilTest.java, v 0.1 2015年9月15日 下午5:28:59 lizhenhai Exp $
 */
public class WeinxinTest {

	SupplierDaoImpl supplierDaoImpl = new SupplierDaoImpl();
	@Test
	public void pathtest(){
		String currentPath = Path.getCurrentPath();
		System.out.println(currentPath);
	}
	@Test
	public void daotest(){
		boolean hasCode = false;
		try {
			hasCode = supplierDaoImpl.hasCode("GYS1508070001");
		} catch (Exception e) {
//			logger.error("", e);
			System.out.println(e.getMessage());
		}
		if (hasCode) {
			System.out.println("有");
		}else{
			System.out.println("没有");
		}
	}
	@Test
	public void savetest(){
		try {
			supplierDaoImpl.saveOpenID("GYS1508070001", "gk_id95967e47fd", 1);
		} catch (Exception e) {
//			logger.error("", e);
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void expiretest(){
		try {
			boolean openIdCheckedExpire = supplierDaoImpl.openIdCheckedExpire("gk_id95967e47fd");
			if (openIdCheckedExpire) {
				System.out.println("expire");
			}else {
				System.out.println("no expire");
			}
		} catch (Exception e) {
//			logger.error("", e);
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void checktest(){
		boolean openIdIsChecked = false;
		try {
			openIdIsChecked = supplierDaoImpl.openIdIsNotChecked("oT1veswayNSDr77qcVK1Ehm-yia04");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (openIdIsChecked) {
			System.out.println("checked....");
		}else {
			System.out.println("no checked...");
		}
	}
	
	@Test
	public void hastest() throws Exception{
		SupplierDaoImpl supplierDaoImpl1 = new SupplierDaoImpl();
		boolean hasOpenID = supplierDaoImpl1.hasOpenID("gk_id95967e47fd");
		if (hasOpenID) {
			System.out.println("ok");
		}else {
			System.out.println("nook");
		}
	}  
	
	@Test
	public void deleteTest() throws Exception{
		SupplierDaoImpl daoImpl = new SupplierDaoImpl();
		daoImpl.deleteOpenid("oOc4Ww42SdbkQHWEnIykqgBdZp0wfsdfsd");
	}
}
