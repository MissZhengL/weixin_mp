<%@page import="net.sf.json.JSONObject"%>
<%@page import="cn.hofan.util.FileUtil"%>
<%@page import="java.io.File"%>
<%@page import="cn.hofan.util.WeixinUtil"%>
<%@page import="cn.hofan.dal.impl.SupplierDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta id="viewport" name="viewport" content="width=640px,minimum-scale=0.2,maximum-scale=0.2" /> -->
<!-- <meta id="viewport" name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<title>绑定结果</title>
<script type="text/javascript">
	function OnInput(event){
		document.getElementById("butt").disabled=false;
	}
</script>
<style type="text/css">
#fenge {
 height:1px;
 width:100%;
 background:#999999;
 overflow:hidden;
 }
 .divcss5-bottom{ margin-top:10px}
</style>
</head>
<body>
	<div class="wrap" align="center" style="background:url(bg.jpg) no-repeat ; background-size: cover; -moz-background-size: cover; ">
		<%
		    request.setCharacterEncoding("UTF-8");
			String erpcode = request.getParameter("erpcode");
			String url = request.getHeader("Referer");
			String openid = url.substring(url.indexOf("=") + 1);
			String yanzhengma = request.getParameter("firstname");
			long time = System.currentTimeMillis();

			SupplierDaoImpl dao = new SupplierDaoImpl();
			String yanzhengcode = dao.getYanzhengma(erpcode, openid);
			if (yanzhengcode.equals(yanzhengma)) {
				if (((time - dao.getsenddate(erpcode, openid)) / (1000 * 60)) < 30) {
			    //	out.print("<br><br>openid=" + openid);
				//	out.print("<br>erpcode=" + erpcode);
				//	out.print("<br>yanzhengma=" + yanzhengma);
					out.print("<br><br>绑定成功！绑定账号：" + erpcode+"<br><br><br><br>");
					dao.setYanzhengExpire(erpcode, openid, yanzhengcode, 0l, 1);
					File file = new File("/opt/soft/tomcat_weixin/webapps/accesstoken.txt");
					String accesstoken = null;
					try {
						accesstoken = FileUtil.readTxtFile(file);
						System.out.println("从/opt/soft/tomcat_weixin/webapps/accesstoken.txt中读出accesstoken成功: "+accesstoken);
					} catch (Exception e) {
						System.out.println("从/opt/soft/tomcat_weixin/webapps/accesstoken.txt中读出accesstoken出错: "+e);
					}
					String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token="+accesstoken+"";
					String body = "{\"openid\":\""+openid+"\",\"to_groupid\":2}";
					JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "POST", body);
					if (null != jsonObject) {  
			            if (0 != jsonObject.getInt("errcode")) {  
							System.out.println("移动"+erpcode+"到星标组失败 errcode:{"+jsonObject.getInt("errcode")+"} errmsg:{"+jsonObject.getString("errmsg")+"}");
			            }else {
							System.out.println("移动"+erpcode+"到星标组成功");
						}  
			        } 
				} else {
					dao.setYanzhengExpire(erpcode, openid, yanzhengcode, 0l, 2);
		%>
		<div class="wrap" align="center" >
			<form
				action="http://weixin.hofan.cn/weixin/bind2.jsp?openid=<%=openid%>"
				method="post">
				<br>
				<br>
				<div>验证超时,请您重新输入供应商编号:</div>
				<br>
				<br> <input
					style="border-radius: 5px; width: 300px; height: 30px" type="text"
					name="erpcode" oninput="OnInput(event)" placeholder="请重新输入您的供应商编号" /><br>
				<br>
				<br> <input
					style="border-radius: 5px; width: 300px; height: 50px; background: #green; color: white; font-size: 20px"
					id="butt" type="submit" name="secondname" disabled="disabled"
					value="发送验证码" /><br>
				<br>
				<br>
			</form>
		</div>
		<%
			}
			} else {
				//out.print("<br><br>openid=" + openid);
				//out.print("<br>erpcode=" + erpcode);
				//out.print("<br>yanzhengma=" + yanzhengma);
				out.print("<br><br>供应商编号为 " + erpcode
						+ "<br><br>但输入的验证码不正确，账号绑定失败！<br><br><br>");

			}

			/*
			 //驱动程序名   
			 String driverName = "com.mysql.jdbc.Driver";  
			 //数据库用户名   
			 String userName = "root";  
			 //密码   
			 String userPasswd = "12345678";  
			 //数据库名   
			 String dbName = "sp_db";  
			 //表名   
			 String tableName = "weixin_info";  
			 //联结字符串   
			 String url = "jdbc:mysql://192.168.3.77:3306/" + dbName + "?user="  
			 + userName + "&password=" + userPasswd;  
			 Class.forName("com.mysql.jdbc.Driver").newInstance();  
			 Connection connection = DriverManager.getConnection(url);  
			 Statement statement = connection.createStatement();  
			 String sql = "SELECT isemailchecked from "+tableName+" where openid='"+fromUserName+"'";  
			 ResultSet rs = statement.executeQuery(sql);  
			 if(){
			
			 }
			 */
		%>
	</div>
	<br>
</body>
</html>