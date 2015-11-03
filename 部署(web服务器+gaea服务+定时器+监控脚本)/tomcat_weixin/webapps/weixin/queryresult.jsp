<%@page import="cn.hofan.dal.impl.SupplierDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
<title>查询结果</title>
</head>
<body>
<div class="wrap" align="left" style="background:url(bgg.jpg) no-repeat ; background-size: cover; -moz-background-size: cover; ">
<%
	request.setCharacterEncoding("UTF-8");
	String params=request.getParameter("F1");
	params = params.replace("，",",");
    String[] orders = params.split(",");
    String order = null;
	SupplierDaoImpl dao = new SupplierDaoImpl();
    for (int i = 0; i < orders.length; i++) {
		order = orders[i];
		if(!order.replace(" ", "").isEmpty()){
			String result = dao.getQueryResult(order);
			out.print(result);
		}else{
			out.print("<br><br>&nbsp&nbsp<b>单号不能为空!</b><br><br>&nbsp&nbsp-----------------------------------------");
		}
	
    }
	out.print("<br><br>&nbsp&nbsp详情请登录浩方供应商门户<br>&nbsp&nbsphttp://sp.hofan.cn/<br><br><br>");
%>
</div>
</body>
</html>