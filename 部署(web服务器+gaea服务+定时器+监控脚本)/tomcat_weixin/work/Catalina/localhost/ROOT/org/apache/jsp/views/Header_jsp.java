/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2015-04-14 09:16:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("<link href=\"/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<link href=\"/bootstrap/css/bootstrap-theme.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<link href=\"/jquery-ui-1.9.2/css/ui-lightness/jquery-ui-1.9.2.custom.min.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\">\r\n");
      out.write("<link href=\"/jquery-ui-1.9.2/css/jquery.multiselect.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/validform/style.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/js/css/base.css\" /><!--基本的css样式   -->\r\n");
      out.write("\r\n");
      out.write("<script src=\"/jquery-ui-1.9.2/js/jquery-1.8.3.min.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/My97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jqCookies.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"/jquery-ui-1.9.2/js/jquery-ui-1.9.2.custom.min.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("<script src=\"/jquery-ui-1.9.2/js/jquery.multiselect.min.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("<script src=\"/jquery-ui-1.9.2/js/jquery.ui.datepicker-zh-CN.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("<script src=\"/jquery-ui-1.9.2/js/jquery.ui.position.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("<script src=\"/validform/Validform.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("<style>\r\n");
      out.write("body { font-size: 12px;}\r\n");
      out.write(".well{padding:0px;margin: 5px;margin-bottom: 0px;}\r\n");
      out.write(".panel-heading{padding:2px}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function (){\r\n");
      out.write("\t\t$(parent.document.getElementsByTagName(\"html\")[0]).animate({\r\n");
      out.write("\t        scrollTop: '0px'\r\n");
      out.write("\t    },\r\n");
      out.write("\t    500);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar timeHead='&nbsp;&nbsp;<a class=\"pull-right \" href=\"#\" onclick=\"timeZoneCsma()\">&nbsp;&nbsp;切换时区</a><div class=\"pull-right\" id=\"time\"></div>';\r\n");
      out.write("\t\t$(\".panel-heading\").html(timeHead);\r\n");
      out.write("\t\t// 增加遮罩层 begin\r\n");
      out.write("\t\t$(\"#styleBlack\").remove();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar black='<style id=\"styleBlack\" type=\"text/css\" >';\r\n");
      out.write("\t\tblack=black+'.black {';\r\n");
      out.write("\t\tblack=black+'background: none repeat scroll 0 0 #CCCCCC;';\r\n");
      out.write("\t\tblack=black+'display: none;';\r\n");
      out.write("\t\tblack=black+'height: 100%;';\r\n");
      out.write("\t\tblack=black+'left: 0;';\r\n");
      out.write("\t\tblack=black+'opacity: 0.3;';\r\n");
      out.write("\t\tblack=black+'position: absolute;';\r\n");
      out.write("\t\tblack=black+'top: 0;';\r\n");
      out.write("\t\tblack=black+'width: 100%;';\r\n");
      out.write("\t\tblack=black+'z-index: 10000;';\r\n");
      out.write("\t\tblack=black+'  }';\r\n");
      out.write("\t\tblack=black+'</style>';\r\n");
      out.write("\t\t$(\"head\").append(black);\r\n");
      out.write("\t\tsetInterval(\"setTimeZoneText();\",999);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//jQuery UI  时区切换  弹出框\r\n");
      out.write("\t\t$( \"#timeZoneRefund\" ).dialog({\r\n");
      out.write("\t\t\tautoOpen: false,\r\n");
      out.write("\t\t\twidth: 300,\r\n");
      out.write("\t\t\tbuttons: [\r\n");
      out.write("\t\t\t          {\r\n");
      out.write("\t\t\t        \t  text: \"确定\",\r\n");
      out.write("\t\t\t        \t  click:function(){\r\n");
      out.write("\t\t\t        \t\t  $(this).dialog( \"close\" );\r\n");
      out.write("\t\t\t        \t\t  alert(\"成功设置时区。\");\r\n");
      out.write("\t\t\t        \t  }\r\n");
      out.write("\t\t\t          },\r\n");
      out.write("\t\t\t          {\r\n");
      out.write("\t\t\t        \t  text: \"取消\",\r\n");
      out.write("\t\t\t        \t  click: function() {\r\n");
      out.write("\t\t\t        \t\t  $(\"#selTimeZone option[optId='\"+$(\"#oldTimeZone\").html()+\"']\").attr(\"selected\",true);\r\n");
      out.write("\t\t\t        \t\t  setTimeZone();\r\n");
      out.write("\t\t\t        \t\t  $( this ).dialog( \"close\" );\r\n");
      out.write("\t\t\t        \t  }\r\n");
      out.write("\t\t\t          }\r\n");
      out.write("\t\t\t          ]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//header 页面加载时 直接加载时区\r\n");
      out.write("\t\t $.ajax({\r\n");
      out.write("\t\t\t\turl : '/timeZone/queryList',\r\n");
      out.write("\t\t\t\tdata : {},\r\n");
      out.write("\t\t\t\ttype : 'post',\r\n");
      out.write("\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\tif(data != null && data !=\"\"){\r\n");
      out.write("\t\t\t\t\t\t$(\"#selTimeZone\").empty();\r\n");
      out.write("\t\t\t\t\t\tvar json = eval(data.list);\r\n");
      out.write("\t\t\t\t\t\tfor(var i=0;i<json.length;i++){\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#selTimeZone\").append(\"<option optId=\"+json[i].id+\" value=\"+json[i].timeLag+\">\"+json[i].countries+\"-\"+json[i].city+\" </option>\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function(data) {\r\n");
      out.write("\t\t\t\t\tmsgDialog(data);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});   \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t $(\"#timeZoneRefund\").dialog( \"close\" );\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tfunction setTimeZone(){\r\n");
      out.write("\t\tvar ret=false;\r\n");
      out.write("\t\tvar userInfo=getUserCookie();\r\n");
      out.write("\t\tif(userInfo!=null){\r\n");
      out.write("\t\t\tvar tzId=$(\"#selTimeZone option:selected\").attr(\"optId\");\r\n");
      out.write("\t\t\tvar tzVal=$(\"#selTimeZone option:selected\").attr(\"value\");\r\n");
      out.write("\t\t\tvar tzText=$(\"#selTimeZone option:selected\")[0].text;\r\n");
      out.write("\t\t\tvar infos=\"{tzId:'\"+tzId+\"',tzVal:'\"+tzVal+\"'\";\r\n");
      out.write("\t\t\t//userId=userId.substring(\"userId\".length+1,userId.indexOf(\"&\"));// 取出登录用户id\r\n");
      out.write("\t\t\t//userId=userId.replace(/\\&/g,\",\").replace(/\\=/g,\":\");// all方式替换语法\r\n");
      out.write("\t\t\tinfos+=\",tzText:'\"+tzText+\"'\";\r\n");
      out.write("\t\t\tinfos+=\",\"+userInfo;\r\n");
      out.write("\t\t\tinfos+=\"}\";\r\n");
      out.write("\t\t\tuserInfo=eval(\"({\"+userInfo+\"})\");\r\n");
      out.write("\t\t\t$.cookie(\"tz_\"+userInfo.userid, infos,{expires:(365*5),domain:\".hofan.cn\",path:\"/\"});//设置cookie 名字、值、有效期、作用域\r\n");
      out.write("\t\t\tret=!ret;\r\n");
      out.write("\t\t\t$(\"#oldTimeZone\").html(infos.tzId);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treturn ret;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//时区切换 （公用）\r\n");
      out.write("\tfunction timeZoneCsma(){\r\n");
      out.write("\t\tvar userInfo=getUserCookie();\r\n");
      out.write("\t\tif(userInfo!=null){\r\n");
      out.write("\t\t\tuserInfo=eval(\"({\"+userInfo+\"})\");\r\n");
      out.write("\t\t\tvar infos=$.cookie(\"tz_\"+userInfo.userid);\r\n");
      out.write("\t\t\tif(infos!=null){// 当前机器设置了时区cookies\r\n");
      out.write("\t\t\t\tinfos=eval(\"(\"+infos+\")\");\r\n");
      out.write("\t\t\t\t$(\"#selTimeZone option[optId='\"+infos.tzId+\"']\").attr(\"selected\",true);\r\n");
      out.write("\t\t\t\t$(\"#oldTimeZone\").html(infos.tzId);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$( \"#timeZoneRefund\" ).dialog({\r\n");
      out.write("\t\t\t\tautoOpen: false,\r\n");
      out.write("\t\t\t\twidth: 300,\r\n");
      out.write("\t\t\t\tbuttons: [\r\n");
      out.write("\t\t\t\t          {\r\n");
      out.write("\t\t\t\t        \t  text: \"确定\",\r\n");
      out.write("\t\t\t\t        \t  click:function(){\r\n");
      out.write("\t\t\t\t        \t\t  $(this).dialog( \"close\" );\r\n");
      out.write("\t\t\t\t        \t\t  alert(\"成功设置时区。\");\r\n");
      out.write("\t\t\t\t        \t  }\r\n");
      out.write("\t\t\t\t          },\r\n");
      out.write("\t\t\t\t          {\r\n");
      out.write("\t\t\t\t        \t  text: \"取消\",\r\n");
      out.write("\t\t\t\t        \t  click: function() {\r\n");
      out.write("\t\t\t\t        \t\t  $(\"#selTimeZone option[optId='\"+$(\"#oldTimeZone\").html()+\"']\").attr(\"selected\",true);\r\n");
      out.write("\t\t\t\t        \t\t  setTimeZone();\r\n");
      out.write("\t\t\t\t        \t\t  $( this ).dialog( \"close\" );\r\n");
      out.write("\t\t\t\t        \t  }\r\n");
      out.write("\t\t\t\t          }\r\n");
      out.write("\t\t\t\t          ]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tvar top = window.parent.document.documentElement.scrollTop || window.parent.pageYOffse || window.parent.document.body.scrollTop;\r\n");
      out.write("\t\t\t$(\"#timeZoneRefund\").dialog(\"option\",\"position\",[\"center\",top]);  //屏幕中心位置显示\r\n");
      out.write("\t\t\t$('#timeZoneRefund').dialog(\"open\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\talert(\"没有找到登录信息，请重新登录系统再设置。\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/**\r\n");
      out.write("\t * 设置页面时间显示\r\n");
      out.write("\t */\r\n");
      out.write("\tfunction setTimeZoneText(){\r\n");
      out.write("\t\tvar userInfo=getUserCookie();\r\n");
      out.write("\t\tvar tzInfo=null;\r\n");
      out.write("\t\tif(userInfo!=null){\r\n");
      out.write("\t\t\tuserInfo=eval(\"({\"+userInfo+\"})\");\r\n");
      out.write("\t\t\ttzInfo=$.cookie(\"tz_\"+userInfo.userid);\r\n");
      out.write("\t\t\tif(tzInfo!=null){\r\n");
      out.write("\t\t\t\ttzInfo=eval(\"(\"+tzInfo+\")\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar dt=new Date();\r\n");
      out.write("\t\tif(tzInfo==null){\r\n");
      out.write("\t\t\ttzInfo={tzText:\"中国-北京\",tzVal:0};\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdt.setMinutes(dt.getMinutes() + (tzInfo.tzVal*60), dt.getSeconds(), 0);\r\n");
      out.write("\t\tvar span=\"<b>\"+tzInfo.tzText+ \"：\" + dateFormat(dt,'yyyy-MM-dd HH:mm:ss')+\"</b>\";\r\n");
      out.write("\t\tvar beijingTime=\"<b>\"+dateFormat(new Date(),'yyyy-MM-dd HH:mm:ss')+\"</b>\";\r\n");
      out.write("\t\t$('#time').html(span);\r\n");
      out.write("\t\t$(\"#tdBeijingTime\").html(beijingTime);\r\n");
      out.write("\t\t$(\"#tdCurrentTime\").html(\"<b>\"+dateFormat(dt,'yyyy-MM-dd HH:mm:ss')+\"</b>\");\r\n");
      out.write("\t};\t\r\n");
      out.write("\t\r\n");
      out.write("\tdateFormat = function(d, fmt) { // author: meizz\r\n");
      out.write("\t\tvar o = {\r\n");
      out.write("\t\t\t\"M+\" : d.getMonth() + 1, // 月份\r\n");
      out.write("\t\t\t\"d+\" : d.getDate(), // 日\r\n");
      out.write("\t\t\t\"H+\" : d.getHours(), // 小时\r\n");
      out.write("\t\t\t\"m+\" : d.getMinutes(), // 分\r\n");
      out.write("\t\t\t\"s+\" : d.getSeconds(), // 秒\r\n");
      out.write("\t\t\t\"q+\" : Math.floor((d.getMonth() + 3) / 3), // 季度\r\n");
      out.write("\t\t\t\"S\" : d.getMilliseconds()// 毫秒\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tif (/(y+)/.test(fmt))\r\n");
      out.write("\t\t\tfmt = fmt.replace(RegExp.$1, (d.getFullYear() + \"\").substr(4 - RegExp.$1.length));\r\n");
      out.write("\t\tfor (var k in o)\r\n");
      out.write("\t\t\tif (new RegExp(\"(\" + k + \")\").test(fmt))\r\n");
      out.write("\t\t\t\tfmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : ((\"00\" + o[k]).substr((\"\" + o[k]).length)));\r\n");
      out.write("\t\treturn fmt;\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\t/**\r\n");
      out.write("\t * 从cookie 中获得用户信息\r\n");
      out.write("\t * @returns 如果有值则返回:\"A:1,A:2,B:3 ...\"这样格式的字符串，否则返回 null\r\n");
      out.write("\t */\r\n");
      out.write("\tfunction getUserCookie(){\r\n");
      out.write("\t\tvar ret=null;\r\n");
      out.write("\t\tvar\tuserInfoCookie=$.cookie(\"umshofancn\");// 获取登录用户信息\t\t\r\n");
      out.write("\t\tif(userInfoCookie!=null){\r\n");
      out.write("\t\t\tuserInfoCookie=userInfoCookie.split(\"&\");\r\n");
      out.write("\t\t\tfor(var i=0;i<userInfoCookie.length;i++){\r\n");
      out.write("\t\t\t\tvar t=userInfoCookie[i].split(\"=\");\r\n");
      out.write("\t\t\t\tif(i==0){\r\n");
      out.write("\t\t\t\t\tret=t[0]+\":\"+\"'\"+t[1]+\"'\";\t\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tret+=\",\"+t[0]+\":\"+\"'\"+t[1]+\"'\";\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treturn ret;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("<!--时区切换  Start-->\r\n");
      out.write("<div id=\"timeZoneRefund\" title=\"时区切换\">\r\n");
      out.write("\t<form action=\"\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr style=\"white-space:nowrap\">\r\n");
      out.write("\t\t\t\t<td><label class=\"control-label\">我的时区：</label></td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t<label id=\"oldTimeZone\" style=\"display: none;\">6</label><!-- 变更前的时区 -->\r\n");
      out.write("\t\t\t\t\t<select id=\"selTimeZone\" class=\"\" onchange=\"setTimeZone();\" style=\"width: 180px\">\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"1\" value=\"0\">中国-香港</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"2\" value=\"0\">中国-台北</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"3\" value=\"0\">中国-澳门地区</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"4\" value=\"0\">中国-上海</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"5\" value=\"0\">中国-广州</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"6\" value=\"0\">中国-北京</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"7\" value=\"-12\">智利-圣地亚哥</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"8\" value=\"-7\">乍得-恩贾梅纳</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"9\" value=\"-6\">赞比亚-卢萨卡</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"10\" value=\"-1\">越南-河内</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"11\" value=\"-6\">约旦-安曼</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"12\" value=\"-7\">英国殖民地-直布罗陀</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"13\" value=\"-8\">英国-伦敦</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"14\" value=\"-8\">英国-格拉斯哥</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"15\" value=\"-8\">英国-爱丁堡</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"16\" value=\"-8\">英国-曼彻斯特</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"17\" value=\"-8\">英国-利物浦</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"18\" value=\"-8\">英国-利兹</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"19\" value=\"-8\">英国-阿伯丁</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"20\" value=\"-8\">英国-伯明翰</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"21\" value=\"-8\">英国-贝尔法斯特</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"22\" value=\"-1\">印度尼西亚-雅加达</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"23\" value=\"0\">印度-孟买</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"24\" value=\"0\">印度-加尔各答</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"25\" value=\"0\">印度-新德里</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"26\" value=\"-7\">意大利-罗马</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"27\" value=\"-7\">意大利-威尼斯</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"28\" value=\"-7\">意大利-米兰</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"29\" value=\"-7\">意大利-热那亚</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"30\" value=\"4.5\">伊朗-阿巴丹</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"31\" value=\"-4.5\">伊朗-德黑兰</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"32\" value=\"-5\">伊拉克-巴格达</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"33\" value=\"-5\">也门-亚丁</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"34\" value=\"-13\">牙买加-金斯敦</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"35\" value=\"-6\">叙利亚-大马士革</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"36\" value=\"-7\">匈牙利-布达佩斯</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"37\" value=\"4\">新西兰-惠灵顿</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"38\" value=\"4\">新西兰-奥克兰</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"39\" value=\"0\">新加坡-新加坡</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"40\" value=\"-6\">希腊-雅典</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"41\" value=\"-19\">西萨摩亚-阿皮亚</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"42\" value=\"-7\">西班牙-马德里</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"43\" value=\"-11\">乌拉圭-蒙得维的亚</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"44\" value=\"-5\">乌克兰-敖德萨</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"45\" value=\"-5\">乌克兰-基辅</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"46\" value=\"-5\">乌干达-坎帕拉</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"47\" value=\"0\">文莱-斯里巴加湾港</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"48\" value=\"-12\">委内瑞拉-加拉加斯</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"49\" value=\"3\">瓦努阿图-维拉港</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"50\" value=\"-6\">土耳其-安卡拉</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"51\" value=\"-6\">土耳其-伊斯坦布尔</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"52\" value=\"-7\">突尼斯-突尼斯</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"53\" value=\"-12\">特立尼达和多巴哥-西班牙港</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"54\" value=\"-5\">坦桑尼亚-达累斯萨拉姆</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"55\" value=\"-1\">泰国-曼谷</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"56\" value=\"-5\">索马里-摩加迪沙</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"57\" value=\"-11\">苏里南-帕拉马里博</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"58\" value=\"-6\">苏丹-喀土穆</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"59\" value=\"0\">斯里兰卡-科伦坡</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"60\" value=\"-8\">圣多美和普林西比-圣多美</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"61\" value=\"-5\">沙特-麦加</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"62\" value=\"-8\">塞内加尔-达喀尔</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"63\" value=\"-7\">瑞士-日内瓦</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"64\" value=\"-7\">瑞士-苏黎世</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"65\" value=\"-7\">瑞典-斯德哥尔摩</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"66\" value=\"1\">日本-长崎</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"67\" value=\"1\">日本-大阪</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"68\" value=\"1\">日本-京都</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"69\" value=\"1\">日本-横滨</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"70\" value=\"1\">日本-东京</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"71\" value=\"-8\">葡萄牙-里斯本</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"72\" value=\"-7\">挪威-奥斯陆</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"73\" value=\"-7\">尼日利亚-拉各斯</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"74\" value=\"-7\">尼日利亚-卡诺</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"75\" value=\"-8\">尼日尔-尼亚美</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"76\" value=\"-2.5\">尼泊尔-加德满都</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"77\" value=\"-7\">南斯拉夫-贝尔格莱德</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"78\" value=\"-6\">南非-约翰内斯堡</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"79\" value=\"-6\">南非-德班</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"80\" value=\"-6\">南非-比勒陀利亚</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"81\" value=\"-6\">南非-开普敦</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"82\" value=\"1\">南朝鲜-汉城</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"83\" value=\"-6\">纳米比亚-温得和克</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"84\" value=\"-14\">墨西哥-墨西哥城</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"85\" value=\"-6\">莫桑比克-贝拉</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"86\" value=\"-6\">莫桑比克-马普托</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"87\" value=\"-8\">摩洛哥-达尔贝达(卡萨布兰卡)</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"88\" value=\"-8\">摩洛哥-拉巴特</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"89\" value=\"-7\">民主刚果-金沙萨</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"90\" value=\"-1.5\">缅甸-仰光</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"91\" value=\"-13\">秘鲁-利马</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"92\" value=\"-2\">孟加拉-达卡</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"93\" value=\"0\">蒙古-乌兰巴托</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"94\" value=\"-17\">美国-安克雷奇</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"95\" value=\"-13\">美国-波士顿</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"96\" value=\"-14\">美国-芝加哥</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"97\" value=\"-13\">美国-亚特兰大</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"98\" value=\"-14\">美国-达拉斯</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"99\" value=\"-15\">美国-丹佛</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"100\" value=\"-14\">美国-休斯敦</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"101\" value=\"-13\">美国-底特律</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"102\" value=\"-13\">美国-巴尔的摩</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"103\" value=\"-16\">美国-洛杉矶</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"104\" value=\"-13\">美国-迈阿密</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"105\" value=\"-14\">美国-新奥尔良</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"106\" value=\"-13\">美国-纽约</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"107\" value=\"-13\">美国-费城</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"108\" value=\"-13\">美国-匹兹堡</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"109\" value=\"-14\">美国-圣路易斯</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"110\" value=\"-15\">美国-盐湖城</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"111\" value=\"-13\">美国-华盛顿</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"112\" value=\"-16\">美国-西雅图</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"113\" value=\"-16\">美国-圣迭戈</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"114\" value=\"-16\">美国-旧金山(圣弗兰西斯科)</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"115\" value=\"-16\">美国-拉斯韦加斯</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"116\" value=\"-18\">美国-火奴鲁鲁(檀香山)</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"117\" value=\"-8\">毛里塔尼亚-努瓦克肖特</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"118\" value=\"-4\">毛里求斯-路易港</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"119\" value=\"-8\">马里-巴马科</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"120\" value=\"0\">马来西亚-吉隆坡</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"121\" value=\"-5\">马达加斯加-塔那那利佛</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"122\" value=\"-6\">罗马尼亚-康斯坦萨</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"123\" value=\"-6\">罗马尼亚-布加勒斯特</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"124\" value=\"-7\">罗马教廷所在地-梵蒂冈</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"125\" value=\"-6\">利比亚-班加西</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"126\" value=\"-6\">利比亚-的黎波里</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"127\" value=\"-8\">利比里亚-蒙罗维亚</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"128\" value=\"-6\">黎巴嫩-贝鲁特</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"129\" value=\"-5\">肯尼亚-内罗毕</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"130\" value=\"-5\">肯尼亚-蒙巴萨</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"131\" value=\"-5\">科威特-科威特</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"132\" value=\"-8\">科特迪瓦-阿比让</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"133\" value=\"-7\">喀麦隆-杜阿拉</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"134\" value=\"-7\">捷克-布拉格</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"135\" value=\"-1\">柬埔寨-金边</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"136\" value=\"-8\">加那利群岛-拉斯帕耳马斯</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"137\" value=\"-13\">加拿大-多伦多</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"138\" value=\"-13\">加拿大-蒙特利尔</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"139\" value=\"-13\">加拿大-渥太华</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"140\" value=\"-16\">加拿大-温哥华</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"141\" value=\"-15\">加拿大-埃德蒙顿</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"142\" value=\"-14\">加拿大-温尼伯</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"143\" value=\"-13\">加拿大-魁北克</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"144\" value=\"-14\">加拿大-丘吉尔港</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"145\" value=\"-5\">吉布提-吉布提</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"146\" value=\"-7\">荷兰-阿姆斯特丹</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"147\" value=\"-7\">荷兰-鹿特丹</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"148\" value=\"2\">关岛-阿加尼亚</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"149\" value=\"-13\">古巴-哈瓦那</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"150\" value=\"-13\">哥伦比亚-波哥大</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"151\" value=\"-7\">刚果-布拉柴维尔</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"152\" value=\"-7\">刚果-黑角</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"153\" value=\"-6\">芬兰-赫尔辛基</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"154\" value=\"4\">斐济-苏瓦</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"155\" value=\"0\">菲律宾-马尼拉</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"156\" value=\"3\">法属新喀里多尼亚-努美阿</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"157\" value=\"-18\">法属波利尼西亚-帕皮提</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"158\" value=\"-7\">法国-巴黎</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"159\" value=\"-7\">法国-马塞</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"160\" value=\"-5\">俄罗斯-莫斯科</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"161\" value=\"-5\">俄罗斯-摩尔曼斯克</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"162\" value=\"-5\">俄罗斯-圣彼得堡</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"163\" value=\"1\">俄罗斯-尼古拉耶夫斯克(庙街)</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"164\" value=\"0\">俄罗斯-伊尔库次克</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"165\" value=\"2\">俄罗斯-符拉迪沃斯托克(海参崴)</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"166\" value=\"-3\">俄罗斯-鄂木斯克</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"167\" value=\"-7\">德国-柏林</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"168\" value=\"-7\">德国-法兰克福</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"169\" value=\"-7\">德国-波恩</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"170\" value=\"-7\">德国-慕尼黑</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"171\" value=\"-7\">德国-莱比锡</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"172\" value=\"-7\">德国-汉堡</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"173\" value=\"-7\">丹麦-哥本哈根</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"174\" value=\"1\">朝鲜-平壤</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"175\" value=\"-6\">博茨瓦纳-哈博罗内</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"176\" value=\"-12\">玻利维亚-拉巴斯</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"177\" value=\"-7\">波兰-华沙</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"178\" value=\"-7\">波兰-格但斯克</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"179\" value=\"-12\">波多黎各-圣胡安</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"180\" value=\"-8\">冰岛-雷克雅未克</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"181\" value=\"-7\">比利时-安特卫普</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"182\" value=\"-7\">比利时-布鲁塞尔</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"183\" value=\"-6\">保加利亚-索非亚</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"184\" value=\"-11\">巴西-贝伦</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"185\" value=\"-11\">巴西-巴西利亚</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"186\" value=\"-11\">巴西-里约热内卢</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"187\" value=\"-13\">巴拿马-巴拿马城</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"188\" value=\"-13\">巴拿马-科隆</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"189\" value=\"-6\">巴勒斯坦-耶路撒冷</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"190\" value=\"-12\">巴拉圭-亚松森</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"191\" value=\"-3\">巴基斯坦-伊斯兰堡</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"192\" value=\"-3\">巴基斯坦-卡拉奇</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"193\" value=\"-3\">巴基斯坦-拉瓦尔品第</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"194\" value=\"2\">巴布亚新几内亚-莫尔兹比港</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"195\" value=\"2\">澳大利亚-布里斯班</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"196\" value=\"2\">澳大利亚-堪培拉</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"197\" value=\"0\">澳大利亚-弗里曼特尔</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"198\" value=\"0\">澳大利亚-佩思</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"199\" value=\"2\">澳大利亚-悉尼</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"200\" value=\"2\">澳大利亚-霍巴特</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"201\" value=\"2\">澳大利亚-墨尔本</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"202\" value=\"-7\">奥地利-维也纳</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"203\" value=\"-7\">安哥拉-罗安达</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"204\" value=\"-8\">爱尔兰-都柏林</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"205\" value=\"-5\">埃塞俄比亚-亚的斯亚贝巴</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"206\" value=\"-6\">埃及-开罗</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"207\" value=\"-6\">埃及-亚历山大</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"208\" value=\"-6\">阿塞拜疆-巴库</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"209\" value=\"-4\">阿联酋-阿布扎比</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"210\" value=\"-11\">阿根廷-布宜诺斯艾利斯</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"211\" value=\"-7\">阿尔及利亚-阿尔及尔</option>\r\n");
      out.write("\t\t\t\t\t\t<option optId=\"212\" value=\"-7\">阿尔巴尼亚-地拉那</option> \r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td style=\"padding-top: 5px;\"><b>我的时间：</b></td>\r\n");
      out.write("\t\t\t\t<td id=\"tdCurrentTime\" style=\"padding-top: 5px;\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td style=\"padding-top: 5px;\"><b>北京时间：</b></td>\r\n");
      out.write("\t\t\t\t<td id=\"tdBeijingTime\" style=\"padding-top: 5px;\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr style=\"white-space:nowrap;display:none\">\r\n");
      out.write("\t\t\t\t<td><label class=\"control-label\">日期格式：</label></td> \r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t<select id=\"selDateFormat\" class=\"\"  style=\"width: 180px\">\r\n");
      out.write("\t\t\t\t\t<option value=\"yyyy-MM-dd HH:mm:ss\">2014-11-12 11:53:00 </option>\r\n");
      out.write("\t\t\t\t\t<option value=\"EEE MMM dd HH:mm:ss z yyyy\">Tue Nov 11 15:16:42 CST 2014</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table><br>\r\n");
      out.write("\t</form>\t\t\r\n");
      out.write("</div>\r\n");
      out.write("<!--时区切换 end  -->\t\t\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
