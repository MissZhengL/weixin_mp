/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.hofan.service.CoreService;
import cn.hofan.util.SignUtil;

/**
 * 
 * @author lizhenhai
 * @version $Id: servlet.java, v 0.1 2015年8月24日 下午1:41:37 lizhenhai Exp $
 */
public class WeixinServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(WeixinServlet.class);  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeixinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**确认请求来自微信服务器 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
        	log.info("确认请求来自微信服务器!");
            out.print(echostr);  
        }  
        out.close();  
        out = null; 
		
		/*String email = request.getParameter("email");
		//如果email在我们的库里
		//验证是否过期
		PrintWriter out = response.getWriter();
		out.print(email);
		out.close();*/ 
		
	}

	/**处理微信服务器发来的消息 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String respMessage = CoreService.processRequest(request);
		
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close(); 
		
	}


}
