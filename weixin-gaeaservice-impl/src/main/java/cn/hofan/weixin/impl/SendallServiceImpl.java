/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.weixin.impl;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.hofan.spat.db.dal.sql.select.IRowCallbackHandler;
import cn.hofan.spat.db.dal.sql.select.SQLQuery;
import cn.hofan.weixin.bean.OpenidAndErpcode;
import cn.hofan.weixin.contract.ISendallService;
import cn.hofan.weixin.util.FileUtil;
import cn.hofan.weixin.util.WeixinUtil;

import com.bj58.spat.gaea.server.contract.annotation.ServiceBehavior;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.junit.Test;

/**
 * 
 * @author lizhenhai
 * @version $Id: SendallServiceImpl.java, v 0.1 2015年9月24日 下午2:10:40 lizhenhai
 *          Exp $
 */
@ServiceBehavior(lookUP = "ISendallService")
public class SendallServiceImpl implements ISendallService {

	private final Log log = LogFactory.getLog(SendallServiceImpl.class);

	/**
	 * @throws Exception 
	 * @see cn.hofan.weixin.contract.ISendallService#sendallByGroup(int)
	 */
	@Override
	public boolean sendallByGroup(int groupId) throws Exception {
		//1.先获取已绑定用户的openid和erpcode
		List<OpenidAndErpcode> list = getOpenidAndErpcodeOfChecked();
		List<String> listresult = new ArrayList<String>();
		//2.没有待发货的openid则移动到临时组 id为100
		if(moveToTempGroup(list,listresult)){
			Thread.sleep(5*1000);
			//3.给星标组推送提醒
			sendToGroup(groupId);
			Thread.sleep(5*1000);
			//4.把临时组的openid移动回星标组 id为2
			if(moveBackToStarGroup(listresult)){
				return true;
			}
		}
		return false;
	}

	private boolean moveBackToStarGroup(List<String> listresult) {
		if ( listresult==null || listresult.size()==0) {
			return true;
		}
		File file = new File("/opt/soft/tomcat_weixin/webapps/accesstoken.txt");
		String accesstoken = null;
		try {
			accesstoken = FileUtil.readTxtFile(file);
			log.info("从/opt/soft/tomcat_weixin/webapps/accesstoken.txt中读出accesstoken成功: "
					+ accesstoken);
		} catch (Exception e) {
			log.error(
					"从/opt/soft/tomcat_weixin/webapps/accesstoken.txt中读出accesstoken出错: ",
					e);
		}
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token="
				+ accesstoken + "";
		//--开始
		int batch = 50;
		int size = listresult.size();
		int total = size % batch == 0 ? size / batch : size / batch + 1;
		for (int n = 0; n < total; n++) {
			StringBuffer sbb = new StringBuffer();
			sbb.append("{\"openid_list\":[");
			int j = 0;
			if (size > (n + 1) * batch) {
				for (String ppd : listresult.subList(n * batch, (n + 1)* batch)) {
					if (j > 0) {
						sbb.append(",");
					}
					j++;
					sbb.append("\""+ppd+"\"");
				}
			}else {
				for (String ppd : listresult.subList(n * batch, size)) {
					if (j > 0) {
						sbb.append(",");
					}
					j++;
					sbb.append("\""+ppd+"\"");
				}
			}
			sbb.append("],\"to_groupid\":2}");
			String body = sbb.toString();
			JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "POST", body);
			if (null != jsonObject) {
				if (0 != jsonObject.getInt("errcode")) {
					log.error("批量移动"+batch+"个回星标组失败 errcode:{" + jsonObject.getInt("errcode")
							+ "} errmsg:{" + jsonObject.getString("errmsg") + "}");
					return false;
				} else {
					log.info("批量移动"+batch+"个回星标组成功!");
				}
			}
			
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	private boolean moveToTempGroup(List<OpenidAndErpcode> list,List<String> listresult) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT erp_code as erpcode,audit_pass_at as time from personal_info where erp_code in (");
		for (int i = 0; i < list.size(); i++) {
			String erpcode = list.get(i).getErpcode();
			sb.append("'"+erpcode+"',");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		String sql = sb.toString();
		SQLQuery sqlQuery = DBHelper.daoHelperSP.session.createSQLQuery(OpenidAndErpcode.class, sql);
		List<OpenidAndErpcode> list2 = (List<OpenidAndErpcode>) sqlQuery.list();
		for (int i = 0; i < list.size(); i++) {
			String erpcode = list.get(i).getErpcode();
			for (int j = 0; j < list2.size(); j++) {
				if(erpcode.equalsIgnoreCase(list2.get(j).getErpcode())){
					list.get(i).setTime(list2.get(j).getTime());
				}
			}
		}
		//循环遍历,获取到没有待发货的openid
		List<String> lists = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String sqlr="SELECT  COUNT(1) CN FROM    dbo.tbPOPlan pop "
					+ "LEFT JOIN dbo.tbPO po ON po.POPlanID = pop.POPlanID "
					+ "LEFT JOIN xq2006..btype b ON b.typeId = po.btypeid "
					+ "LEFT JOIN xq2006..ptype p ON p.UserCode = pop.Code "
					+ "LEFT JOIN ( SELECT  JHDOrderNo , MaterialCode , MAX(JHDTotal) AS JHDTotal , SUM(DEliveryNum) AS DEliveryNum FROM    dbo.erp_DeliveryInfo WHERE   status = 6 GROUP BY JHDOrderNo , MaterialCode ) di ON di.JHDOrderNo = po.JHDNumber AND di.MaterialCode = pop.Code "
					+ "WHERE   1 = 1 "
					+ "AND pop.StatusID IN ( 41, 70, 80 ) "
					+ "AND ( di.JHDTotal != di.DEliveryNum OR di.JHDTotal IS NULL ) "
					+ "AND ISNULL(pop.HandStatus, 0)= 0 "
					+ "and b.UserCode = '"+list.get(i).getErpcode()+"' "
					+ "AND pop.PODate >= '"+list.get(i).getTime()+"'";
			int cn = (int) DBHelper.daoHelperERP.sql.execQuery(sqlr, new IRowCallbackHandler() {
				
				@Override
				public Object exec(ResultSet rs) throws SQLException {
					while(rs.next()){
						return rs.getInt(1);
					}
					return 0;
				}
			});
			if (cn==0) {
				lists.add(list.get(i).getOpenid());
			}
		}
		listresult.addAll(lists);
		if ( lists==null || lists.size()==0) {
			return true;
		}
		//批量移动到临时组
		File file = new File("/opt/soft/tomcat_weixin/webapps/accesstoken.txt");
		String accesstoken = null;
		try {
			accesstoken = FileUtil.readTxtFile(file);
			log.info("从/opt/soft/tomcat_weixin/webapps/accesstoken.txt中读出accesstoken成功: "
					+ accesstoken);
		} catch (Exception e) {
			log.error(
					"从/opt/soft/tomcat_weixin/webapps/accesstoken.txt中读出accesstoken出错: ",
					e);
		}
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token="
				+ accesstoken + "";
		//--开始
		int batch = 50;
		int size = lists.size();
		int total = size % batch == 0 ? size / batch : size / batch + 1;
		for (int n = 0; n < total; n++) {
			StringBuffer sbb = new StringBuffer();
			sbb.append("{\"openid_list\":[");
			int j = 0;
			if (size > (n + 1) * batch) {
				for (String ppd : lists.subList(n * batch, (n + 1)* batch)) {
					if (j > 0) {
						sbb.append(",");
					}
					j++;
					sbb.append("\""+ppd+"\"");
				}
			}else {
				for (String ppd : lists.subList(n * batch, size)) {
					if (j > 0) {
						sbb.append(",");
					}
					j++;
					sbb.append("\""+ppd+"\"");
				}
			}
			sbb.append("],\"to_groupid\":100}");
			String body = sbb.toString();
			JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "POST", body);
			if (null != jsonObject) {
				if (0 != jsonObject.getInt("errcode")) {
					log.error("批量移动"+batch+"个到临时组失败 errcode:{" + jsonObject.getInt("errcode")
							+ "} errmsg:{" + jsonObject.getString("errmsg") + "}");
					return false;
				} else {
					log.info("批量移动"+batch+"个到临时组成功!");
				}
			}
			
		}
		return true;
	}

	private boolean sendToGroup(int groupId) {
		File file = new File("/opt/soft/tomcat_weixin/webapps/accesstoken.txt");
		String accesstoken = null;
		try {
			accesstoken = FileUtil.readTxtFile(file);
			log.info("从/opt/soft/tomcat_weixin/webapps/accesstoken.txt中读出accesstoken成功: "
					+ accesstoken);
		} catch (Exception e) {
			log.error(
					"从/opt/soft/tomcat_weixin/webapps/accesstoken.txt中读出accesstoken出错: ",
					e);
		}
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token="
				+ accesstoken + "";
		String body = "{\"filter\":{\"is_to_all\":false,\"group_id\":\""
				+ groupId
				+ "\"},\"mpnews\":{\"media_id\":\"yTULMNqJKEwsIuDUvVbK1Dpf6wFrCyjdjkioQee4wU4\"},\"msgtype\":\"mpnews\"}";
		JSONObject jsonObject = WeixinUtil
				.httpRequest(requestUrl, "POST", body);
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				log.error("分组群发失败 errcode:{" + jsonObject.getInt("errcode")
						+ "} errmsg:{" + jsonObject.getString("errmsg") + "}");
				return false;
			} else {
				log.info("分组群发成功!");
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	private List<OpenidAndErpcode> getOpenidAndErpcodeOfChecked() throws Exception {
		String sql = "SELECT erp_code AS erpcode,openid from weixin_info where isemailchecked=1";
		SQLQuery query = DBHelper.daoHelperSP.session.createSQLQuery(OpenidAndErpcode.class, sql);
		List<OpenidAndErpcode> lists = (List<OpenidAndErpcode>) query.list();
		return lists;
	}
	
	@Test
	public void main() throws Exception {
		SendallServiceImpl impl = new SendallServiceImpl();
		impl.sendallByGroup(2);
	}
}
