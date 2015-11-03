/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.dal;

import java.util.List;

import cn.hofan.bean.OrderQueryInfo;

/**
 * 
 * @author lizhenhai
 * @version $Id: ISupplierDao.java, v 0.1 2015年8月28日 下午4:55:44 lizhenhai Exp $
 */
public interface ISupplierDao {
	
	public String getQueryResult(String queryid) throws Exception;
	
	/**
	 * 是否在途(即 是否预约送货)
	 * @param deliverycode
	 * @throws Exception 
	 */
	public boolean isOnWay(String deliverycode) throws Exception;
	
	/**
	 * 保存建议
	 * @param content
	 * @throws Exception 
	 */
	public void saveAdvice(String content) throws Exception;
	
	/**
	 * 设置验证超期
	 * @param erpcode
	 * @param openid
	 * @param yanzhengcode
	 * @param date
	 * @param isCheck
	 * @throws Exception
	 */
	public void setYanzhengExpire(String erpcode ,String openid,String yanzhengcode,long date,int isCheck) throws Exception;
	
	/**
	 * 得到发送验证码的时刻
	 * @param erpcode
	 * @param openid
	 * @return
	 * @throws Exception
	 */
	public long getsenddate(String erpcode,String openid) throws Exception;
	
	/**
	 * 得到验证码
	 * @param erpcode
	 * @param openid
	 * @return
	 * @throws Exception 
	 */
	public String getYanzhengma(String erpcode,String openid) throws Exception;
	
	/**
	 * 保存验证码等信息
	 * @param erpcode
	 * @param openid
	 * @param yanzhengcode
	 * @param date
	 * @param isCheck
	 * @return
	 * @throws Exception
	 */
	public boolean saveYanzhengCode(String erpcode ,String openid,String yanzhengcode,long date,int isCheck) throws Exception;

	/**
	 * 给该供应商发验证邮件
	 * @param code
	 * @return 验证码
	 * @throws Exception 
	 */
	public String sendEmail(String code) throws Exception ;
	
	
	/**
	 * 存储过openid
	 * @param openid 微信用户
	 * @return
	 * @throws Exception 
	 */
	public boolean hasOpenID(String openid) throws Exception;

	/**
	 * 验证过openid
	 * @param openid 微信用户
	 * @return
	 * @throws Exception 
	 */
	public boolean openIdIsChecked(String openid) throws Exception;

	/**
	 * 有该供应商编码
	 * @param code 供应商编码
	 * @return
	 * @throws Exception 
	 */
	public boolean hasCode(String code) throws Exception;

	/**
	 * 保存该供应商的微信用户
	 * @param code 供应商编码
	 * @param fromUserName 微信用户
	 * @param isCheck 是否验证过 0:未验证(即未点击邮件的验证链接) 1:已验证 2:超时
	 * @throws Exception 
	 */
	public void saveOpenID(String code, String fromUserName, int isCheck) throws Exception;

	/**
	 * 没有验证过openid
	 * @param openid
	 * @return
	 * @throws Exception 
	 */
	public boolean openIdIsNotChecked(String openid) throws Exception;

	/**
	 * 验证超时
	 * @param fromUserName
	 * @return
	 * @throws Exception 
	 */
	public boolean openIdCheckedExpire(String fromUserName) throws Exception;

	/**
	 * 根据openid得到email
	 * @param fromUserName
	 * @return
	 * @throws Exception 
	 */
	public String getEmail(String fromUserName) throws Exception;
	
	/**
	 * 获取供应商编码
	 * @param fromUserName
	 * @return
	 * @throws Exception
	 */
	public String getCode(String fromUserName) throws Exception;

	/**
	 * 获取采购日期
	 * @param fromUserName
	 * @return
	 */
	public String getBuytime(String fromUserName);

	/**
	 * 获取订单总数
	 * @param fromUserName
	 * @return
	 */
	public String getNum(String fromUserName);

	/**
	 * 获取采购日期和订单总数
	 * @param erpcode
	 * @return
	 * @throws Exception 
	 */
	public List<OrderQueryInfo> getBuytimeAndNum(String erpcode,String time) throws Exception;

	/**
	 * 获取供应商的终审审核通过时间
	 * @param code
	 * @return
	 * @throws Exception 
	 */
	public String getAuditPassTime(String code) throws Exception;

	/**
	 * 取消关注后,删除数据
	 * @param fromUserName
	 * @throws Exception 
	 */
	public void deleteOpenid(String fromUserName) throws Exception;

	/**
	 * 备份取消关注的人
	 * @param fromUserName
	 * @throws Exception 
	 */
	public void backupNofollower(String fromUserName) throws Exception;
}
