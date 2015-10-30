/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.dal.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import cn.hofan.bean.OrderQueryInfo;
import cn.hofan.bean.QueryResul;
import cn.hofan.dal.DBHelper;
import cn.hofan.dal.ISupplierDao;
import cn.hofan.spat.db.dal.sql.IPreparedStatementHandler;
import cn.hofan.spat.db.dal.sql.select.IRowCallbackHandler;
import cn.hofan.spat.db.dal.sql.select.SQLQuery;
import cn.hofan.util.SendEmail;

/**
 * 
 * @author lizhenhai
 * @version $Id: SupplierDaoImpl.java, v 0.1 2015年8月31日 上午10:17:23 lizhenhai Exp
 *          $
 */
public class SupplierDaoImpl implements ISupplierDao {

	// 192.168.3.77 select p.email,p.erp_code,p.* from personal_info p where
	// p.email is not null
	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#hasOpenID(java.lang.String)
	 */
	@Override
	public boolean hasOpenID(String fromUserName) throws Exception {

		long result = 0;
		result = (long) DBHelper.daoHelperSP.sql.execQuery(
				"select count(1) as num from weixin_info where openid = ?",
				new Object[] { fromUserName }, new IRowCallbackHandler() {
					@Override
					public Object exec(ResultSet rs) throws SQLException {
						while (rs.next()) {
							return rs.getLong(1);
						}
						return -1l;
					}
				});
		// System.out.println(result);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#openIdIsChecked(java.lang.String)
	 */
	@Override
	public boolean openIdIsChecked(String fromUserName) throws Exception {
		// isemailchecked字段是否是1
		String sql = "SELECT isemailchecked from weixin_info where openid = ?";
		String result = (String) DBHelper.daoHelperSP.sql.execQuery(sql,
				new Object[] { fromUserName }, new IRowCallbackHandler() {

					@Override
					public Object exec(ResultSet rs) throws SQLException {
						String int1 = "";
						while (rs.next()) {
							int1 = rs.getString("isemailchecked");
						}
						return int1;
					}
				});
		if (result == null || !("1".equals(result))) {
			return false;
		}
		return true;
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#openIdIsNotChecked(java.lang.String)
	 */
	@Override
	public boolean openIdIsNotChecked(String fromUserName) throws Exception {
		// isemailchecked字段是否是0
		String sql = "SELECT isemailchecked from weixin_info where openid = ?";
		String result = (String) DBHelper.daoHelperSP.sql.execQuery(sql,
				new Object[] { fromUserName }, new IRowCallbackHandler() {
					String result = "";

					public Object exec(ResultSet rs) throws SQLException {
						if (rs.next()) {
							result = rs.getString("isemailchecked");
						}
						return result;
					}
				});
		if ("0".equals(result)) {
			return true;
		}
		return false;
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#openIdCheckedExpire(java.lang.String)
	 */
	@Override
	public boolean openIdCheckedExpire(String fromUserName) throws Exception {
		// isemailchecked字段是否是2
		String sql = "SELECT isemailchecked from weixin_info where openid = ?";
		String result = (String) DBHelper.daoHelperSP.sql.execQuery(sql,
				new Object[] { fromUserName }, new IRowCallbackHandler() {
					String result = "";

					public Object exec(ResultSet rs) throws SQLException {
						if (rs.next()) {
							result = rs.getString("isemailchecked");
						}
						return result;
					}
				});
		if ("2".equals(result)) {
			return true;
		}
		return false;
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#hasCode(java.lang.String)
	 */
	@Override
	public boolean hasCode(String code) throws Exception {
		String sql = "SELECT COUNT(1) from personal_info where erp_code = ? and audit_pass_at is not null";

		String result = (String) DBHelper.daoHelperSP.sql.execQuery(sql,
				new Object[] { code }, new IRowCallbackHandler() {
					String result = "";

					public Object exec(ResultSet rs) throws SQLException {
						if (rs.next()) {
							result = rs.getString(1);
						}
						return result;
					}
				});
		if ("0".equals(result)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#saveOpenID(java.lang.String,
	 *      java.lang.String, int)
	 */
	@Override
	public void saveOpenID(String code, String fromUserName, int isCheck)
			throws Exception {
		String sql = "INSERT INTO weixin_info(erp_code,openid,isemailchecked)VALUES('"
				+ code + "','" + fromUserName + "'," + isCheck + ")";
		DBHelper.daoHelperSP.sql.executeUpdate(sql,
				new IPreparedStatementHandler() {

					public Object exec(PreparedStatement ps, Object[] objs)
							throws SQLException {
						return ps.executeUpdate();
					}
				}, new Object[] {});
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#getEmail(java.lang.String)
	 */
	@Override
	public String getEmail(String fromUserName) throws Exception {
		String sql;
		String code = getCode(fromUserName);
		sql = "SELECT email from personal_info where erp_code='" + code
				+ "' and audit_pass_at is not null";
		String result = (String) DBHelper.daoHelperSP.sql.execQuery(sql,
				new IRowCallbackHandler() {
					String result = "";

					public Object exec(ResultSet rs) throws SQLException {
						if (rs.next()) {
							result = rs.getString("email");
						}
						return result;
					}
				});

		return result;
	}

	@Override
	public String getCode(String fromUserName) throws Exception {
		String sql = "SELECT erp_code from weixin_info where openid='"
				+ fromUserName + "'";
		String code = (String) DBHelper.daoHelperSP.sql.execQuery(sql,
				new IRowCallbackHandler() {
					String code = "";

					public Object exec(ResultSet rs) throws SQLException {
						if (rs.next()) {
							code = rs.getString("erp_code");
						}
						return code;
					}
				});
		return code;
	}

	@Override
	public String getBuytime(String fromUserName) {

		return null;
	}

	@Override
	public String getNum(String fromUserName) {

		return null;
	}

	@Override
	public List<OrderQueryInfo> getBuytimeAndNum(String erpcode, String time)
			throws Exception {
		String sql = "SELECT  PODate AS BuyerTime,COUNT(podate) AS Num FROM dbo.tbPOPlan pop WITH (NOLOCK) LEFT JOIN dbo.tbPO po ON po.POPlanID = pop.POPlanID "
				+ "LEFT JOIN xq2006..btype b WITH (NOLOCK) ON b.typeId = po.btypeid "
				+ "LEFT JOIN xq2006..ptype p WITH (NOLOCK) ON p.UserCode = pop.Code  "
				+ "LEFT JOIN ( SELECT  JHDOrderNo , MaterialCode , MAX(JHDTotal) AS JHDTotal , SUM(DEliveryNum) AS DEliveryNum FROM    dbo.erp_DeliveryInfo WITH (NOLOCK) WHERE   status = 6 GROUP BY JHDOrderNo , MaterialCode ) di ON di.JHDOrderNo = po.JHDNumber "
				+ "AND di.MaterialCode = pop.Code WHERE   1 = 1 "
				+ "AND pop.StatusID IN ( 41, 70, 80 ) "
				+ "AND ( di.JHDTotal != di.DEliveryNum OR di.JHDTotal IS NULL ) "
				+ "AND ISNULL(pop.HandStatus, 0)  = 0 "
				+ "and b.UserCode = '"
				+ erpcode
				+ "' "
				+ "AND pop.PODate >= '"
				+ time
				+ "' "
				+ "GROUP BY PODate";
		SQLQuery createSQLQuery = DBHelper.daoHelperERP.session.createSQLQuery(
				OrderQueryInfo.class, sql);
		@SuppressWarnings("unchecked")
		List<OrderQueryInfo> list = (List<OrderQueryInfo>) createSQLQuery
				.list();
		return list;
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#sendEmail(java.lang.String)
	 */
	@Override
	public String sendEmail(String code) throws Exception {
		String sql = "SELECT email from personal_info where erp_code='" + code
				+ "' and audit_pass_at is not null";
		String result = (String) DBHelper.daoHelperSP.sql.execQuery(sql,
				new IRowCallbackHandler() {
					String result = "";

					public Object exec(ResultSet rs) throws SQLException {
						if (rs.next()) {
							result = rs.getString("email");
						}
						return result;
					}
				});
		StringBuffer sb = new StringBuffer("您的验证码为:</br>");
		// sb.append("<a href=\"http://weixintesthai.sinaapp.com/ss?email=");
		String substring = UUID.randomUUID().toString().replaceAll("-", "")
				.substring(0, 4);
		System.out.println("验证码是:" + substring);
		sb.append(substring);
		sb.append("</br></br>有效时间30分钟，请及时输入！");
		System.out.println("--send--" + sb.toString());
		SendEmail.send(result, sb.toString());
		return substring;
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#saveYanzhengCode(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public boolean saveYanzhengCode(String erpcode, String openid,
			String yanzhengcode, long date, int isCheck) throws Exception {
		String judge = "SELECT COUNT(1) from weixin_info where erp_code = ? and openid= '"
				+ openid + "'";
		String result = (String) DBHelper.daoHelperSP.sql.execQuery(judge,
				new Object[] { erpcode }, new IRowCallbackHandler() {
					String result = "";

					public Object exec(ResultSet rs) throws SQLException {
						if (rs.next()) {
							result = rs.getString(1);
						}
						return result;
					}
				});
		if ("0".equals(result)) {
			String sql = "INSERT INTO weixin_info(erp_code,openid,yanzhengcode,send_date,isemailchecked)VALUES('"
					+ erpcode
					+ "','"
					+ openid
					+ "','"
					+ yanzhengcode
					+ "','"
					+ date + "'," + isCheck + ")";
			DBHelper.daoHelperSP.sql.executeUpdate(sql,
					new IPreparedStatementHandler() {

						public Object exec(PreparedStatement ps, Object[] objs)
								throws SQLException {
							return ps.executeUpdate();
						}
					}, new Object[] {});
		} else {
			// 更新验证码和时间
			String sql = "UPDATE weixin_info SET yanzhengcode='" + yanzhengcode
					+ "',send_date=" + date + " where erp_code='" + erpcode
					+ "' and openid='" + openid + "'";
			DBHelper.daoHelperSP.sql.executeUpdate(sql,
					new IPreparedStatementHandler() {

						public Object exec(PreparedStatement ps, Object[] objs)
								throws SQLException {
							return ps.executeUpdate();
						}
					}, new Object[] {});
		}

		return true;
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#getYanzhengma(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String getYanzhengma(String erpcode, String openid) throws Exception {

		String sql = "SELECT yanzhengcode from weixin_info where erp_code='"
				+ erpcode + "' and openid='" + openid + "'";
		String code = (String) DBHelper.daoHelperSP.sql.execQuery(sql,
				new IRowCallbackHandler() {
					String code = "";

					public Object exec(ResultSet rs) throws SQLException {
						if (rs.next()) {
							code = rs.getString("yanzhengcode");
						}
						return code;
					}
				});
		return code;
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#getsenddate(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public long getsenddate(String erpcode, String openid) throws Exception {

		String sql = "SELECT send_date from weixin_info where erp_code='"
				+ erpcode + "' and openid='" + openid + "'";
		long code = (long) DBHelper.daoHelperSP.sql.execQuery(sql,
				new IRowCallbackHandler() {
					long code = 0l;

					public Object exec(ResultSet rs) throws SQLException {
						if (rs.next()) {
							code = rs.getLong("send_date");
						}
						return code;
					}
				});
		return code;
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#setYanzhengExpire(java.lang.String,
	 *      java.lang.String, java.lang.String, long, int)
	 */
	@Override
	public void setYanzhengExpire(String erpcode, String openid,
			String yanzhengcode, long date, int isCheck) throws Exception {
		String sql = "UPDATE weixin_info SET isemailchecked=" + isCheck
				+ " where erp_code='" + erpcode + "' and openid='" + openid
				+ "'";
		DBHelper.daoHelperSP.sql.executeUpdate(sql,
				new IPreparedStatementHandler() {

					public Object exec(PreparedStatement ps, Object[] objs)
							throws SQLException {
						return ps.executeUpdate();
					}
				}, new Object[] {});
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#saveAdvice(java.lang.String)
	 */
	@Override
	public void saveAdvice(final String content) throws Exception {

		String sql = "INSERT  INTO weixin_info_advice(advice)VALUES(?)";
		DBHelper.daoHelperSP.sql.executeUpdate(sql,
				new IPreparedStatementHandler() {

					public Object exec(PreparedStatement ps, Object[] objs)
							throws SQLException {
						ps.setString(1, content);
						return ps.executeUpdate();
					}
				}, new Object[] {});
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#getAuditPassTime(java.lang.String)
	 */
	@Override
	public String getAuditPassTime(String code) throws Exception {
		String sql = "SELECT audit_pass_at from personal_info where erp_code='"
				+ code + "'";
		String result = (String) DBHelper.daoHelperSP.sql.execQuery(sql,
				new IRowCallbackHandler() {
					String code = "";

					public Object exec(ResultSet rs) throws SQLException {
						if (rs.next()) {
							code = rs.getString("audit_pass_at");
						}
						return code;
					}
				});
		return result;
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#isOnWay(java.lang.String)
	 */
	@Override
	public boolean isOnWay(String deliverycode) throws Exception {
		String sql = "SELECT COUNT(1) from express_info where DeliveryCode=?";
		long result = 0;
		result = (long) DBHelper.daoHelperSP.sql.execQuery(sql,
				new Object[] { deliverycode }, new IRowCallbackHandler() {
					@Override
					public Object exec(ResultSet rs) throws SQLException {
						while (rs.next()) {
							return rs.getLong(1);
						}
						return -1l;
					}
				});
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#deleteOpenid(java.lang.String)
	 */
	@Override
	public void deleteOpenid(String fromUserName) throws Exception {
		String sql = "DELETE FROM weixin_info WHERE openid='" + fromUserName
				+ "'";
		DBHelper.daoHelperSP.sql.executeUpdate(sql,
				new IPreparedStatementHandler() {

					@Override
					public Object exec(PreparedStatement ps, Object[] objs)
							throws SQLException {
						return ps.execute();
					}
				}, new Object[] {});
	}

	/**
	 * @throws Exception
	 * @see cn.hofan.dal.ISupplierDao#getQueryResult(java.lang.String)
	 */
	@Override
	public String getQueryResult(String queryid) throws Exception {
		if (queryid.contains("\"")||queryid.contains("\'")) {
			return "<br><br>&nbsp&nbsp<b>送货单号："
					+ queryid
					+ "，输入的单号有误！</b><br><br>&nbsp&nbsp-----------------------------------------";
		}
		String sql = " SELECT  ps.ArrivelNum AS ArrivelNum ,ps.StorageCount As TotalNum,ps.MaterialCode AS MaterialCode, "
				+ "bp.BillPostingTime AS BillPostingTime,ps.SamplingResult as SamplingResult, ps.DealResult as DealResult,ps.PurchaseResult as PurchaseResult "
				+ "FROM dbo.ProductSampling ps LEFT JOIN dbo.BillProperty bp ON ps.JHOrderNo = bp.BillNumber "
				+ "WHERE 1=1 AND ((ps.SamplingResult=1 OR ps.DealResult=1 OR ps.PurchaseResult=1) or (ps.SamplingResult=4 OR ps.DealResult=2 OR ps.PurchaseResult=2))  "
				+ "AND ps.isValid = 1  AND ps.DeliveryCode='" + queryid + "'";
		SQLQuery createSQLQuery = DBHelper.daoHelperERP.session.createSQLQuery(
				QueryResul.class, sql);
		@SuppressWarnings("unchecked")
		List<QueryResul> list = (List<QueryResul>) createSQLQuery.list();
		int status = 0;
		int tag = 0;
		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				String sr = list.get(i).getSamplingResult();
				String dr = list.get(i).getDealResult();
				String pr = list.get(i).getPurchaseResult();
				if ("4".equals(sr) || "2".equals(dr) || "2".equals(pr)) {
					status = 4;
					tag = 1;
				} else {
					String bpt = list.get(i).getBillPostingTime();
					if (bpt == null || "".equals(bpt)) {
						status = 3;
					} else {
						String an = list.get(i).getArrivelNum();
						String tn = list.get(i).getTotalNum();
						if (Integer.parseInt(an) > Integer.parseInt(tn)) {
							status = 1;
						} else if (Integer.parseInt(an) == Integer.parseInt(tn)) {
							if (tag > 0) {
								status = 1;
							} else {
								status = 2;
							}
						} else {
							status = 1;
						}
					}
				}
			}
		} else {
			if (isOnWay(queryid)) {
				status = 0;
			}else {
				status = 5;
			}
		}
		if (status == 0) {
			return "<br><br>&nbsp&nbsp<b>送货单号："
					+ queryid
					+ "，在途</b><br><br>&nbsp&nbsp-----------------------------------------";
		} else if (status == 1) {
			return "<br><br>&nbsp&nbsp<b>送货单号："
					+ queryid
					+ "，差异入库</b><br><br>&nbsp&nbsp-----------------------------------------";
		} else if (status == 2) {
			return "<br><br>&nbsp&nbsp<b>送货单号："
					+ queryid
					+ "，正常入库</b><br><br>&nbsp&nbsp-----------------------------------------";
		} else if (status == 3) {
			return "<br><br>&nbsp&nbsp<b>送货单号："
					+ queryid
					+ "，入库中</b><br><br>&nbsp&nbsp-----------------------------------------";
		}else if (status == 4) {
			return "<br><br>&nbsp&nbsp<b>送货单号："
					+ queryid
					+ "，退货</b><br><br>&nbsp&nbsp-----------------------------------------";
		} else if (status == 5) {
			return "<br><br>&nbsp&nbsp<b>送货单号："
					+ queryid
					+ "，输入的单号有误！</b><br><br>&nbsp&nbsp-----------------------------------------";
		} 
		return null;
	}

	/** 
	 * @throws Exception 
	 * @see cn.hofan.dal.ISupplierDao#backupNofollower(java.lang.String)
	 */
	@Override
	public void backupNofollower(String fromUserName) throws Exception {
		String sql = "INSERT INTO weixin_info_nofollow SELECT * FROM weixin_info WHERE openid='"+fromUserName+"'";
		DBHelper.daoHelperSP.sql.executeUpdate(sql,
				new IPreparedStatementHandler() {
					public Object exec(PreparedStatement ps, Object[] objs)
							throws SQLException {
						return ps.executeUpdate();
					}
				}, new Object[] {});
	}

}
