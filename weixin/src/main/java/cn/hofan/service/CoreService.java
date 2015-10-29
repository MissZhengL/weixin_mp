/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import cn.hofan.bean.OrderQueryInfo;
import cn.hofan.bean.resp.Article;
import cn.hofan.bean.resp.NewsMessage;
import cn.hofan.bean.resp.TextMessage;
import cn.hofan.dal.ISupplierDao;
import cn.hofan.util.FileUtil;
import cn.hofan.util.MessageUtil;
import cn.hofan.util.ProxyLocator;
import cn.hofan.util.SendEmail;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author lizhenhai
 * @version $Id: CoreService.java, v 0.1 2015年8月24日 下午4:38:08 lizhenhai Exp $
 */
public class CoreService {
	
	static ISupplierDao dao = ProxyLocator.get(ISupplierDao.class);
	private static Log log = LogFactory.getLog(CoreService.class);
	
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		
		try {
			// 默认返回的文本消息内容
			String respContent = "谢谢回复!";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			
			// 事件推送
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
//					respContent = "很有眼光啊/坏笑,来,坐下坐下,我们聊聊人生...";
//					respContent = "<a href=\"http://weixin.hofan.cn/weixin/bind.html\">感谢关注！请您进行账号绑定，账号绑定成功后即可实时收发订单消息。点击这里，马上填写。</a>。openid="+fromUserName;
//					respContent = "<a href=\"http://weixin.hofan.cn/weixin/bind.jsp?openid="+fromUserName+"\">点击这里，立即绑定</a>";
					respContent = "感谢关注！请您进行账号绑定，绑定成功即可接收订单通知。\n<a href=\"http://weixin.hofan.cn/weixin/bind.jsp?openid="+fromUserName+"\">点击这里，立即绑定</a>";
					
//					//图文开始
//					List<Article> articleList = new ArrayList<Article>(); 
//					NewsMessage newsMessage = new NewsMessage(); 
//					newsMessage.setToUserName(fromUserName);  
//	                newsMessage.setFromUserName(toUserName);  
//	                newsMessage.setCreateTime(new Date().getTime());  
//	                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
//					
//					Article article = new Article();  
//                    article.setTitle("感谢关注！");  
//                    article.setDescription("请您进行账号绑定，绑定成功后即可实时收发订单消息。\n"
//                    		+ "点击这里，立即绑定。");  
////                    article.setPicUrl("http://7qna9x.com1.z0.glb.clouddn.com/002.jpg");  
//                    article.setPicUrl("");  
//                    article.setUrl("http://weixin.hofan.cn/weixin/bind.jsp?openid="+fromUserName);  
//                    articleList.add(article);  
//                    // 设置图文消息个数  
//                    newsMessage.setArticleCount(articleList.size());  
//                    // 设置图文消息包含的图文集合  
//                    newsMessage.setArticles(articleList);  
//                    // 将图文消息对象转换成xml字符串  
//                    respMessage = MessageUtil.newsMessageToXml(newsMessage);
//                    return respMessage;
//					//图文结束
					
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
					return respMessage;
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					//取消订阅后,删除用户信息
					dao.backupNofollower(fromUserName);
					dao.deleteOpenid(fromUserName);
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					//自定义菜单
					String eventKey = requestMap.get("EventKey");  
					if (eventKey.equals("10")) {
						int all = 0;
						String erpcode= null;
						if (dao.openIdIsChecked(fromUserName)) {
							String code = dao.getCode(fromUserName);
							erpcode = code;
							log.info("erpcode:" + code);
							String time = dao.getAuditPassTime(code);
							List<OrderQueryInfo> lists = dao.getBuytimeAndNum(code,time);
//							respContent = "供应商编号：" + code
//									+ "\n==================\n";
							StringBuilder sb = new StringBuilder();  
							sb.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>");  
					        sb.append("<html>");  
					        sb.append("<head>");  
					        sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");  
					        sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />");  
					        sb.append("<title>订单详情</title>");  
					        sb.append("</head>");  
					        sb.append("<body>");  
					        sb.append("<div align=\"center\" style=\"background:url(bgg.jpg) no-repeat ; background-size: cover; -moz-background-size: cover; \">");
					        sb.append("<table style=\"margin-top: 20px\" align=\"left\" cellpadding=\"5px\" cellspacing=\"0px\" >");
//					        sb.append("");  
//					        sb.append("<br/><br/>");  
							for (OrderQueryInfo orderQueryInfo : lists) {
								all += Integer.parseInt(orderQueryInfo.getNum());
								sb.append("<tr><td>&nbsp&nbsp采购日期: "+orderQueryInfo.getBuyerTime()+"</td></tr>");  
								sb.append("<tr><td>&nbsp&nbsp订单总数: "+orderQueryInfo.getNum()+"</td></tr>");  
								sb.append("<tr><td>&nbsp--------------------------------------</td></tr>");  
//								respContent = respContent
//										+ "采购日期："
//										+ orderQueryInfo.getBuyerTime()
//										+ "\n"
//										+ "订单总数："
//										+ orderQueryInfo.getNum()
//										+ "\n------------------------------------\n";
							}
							sb.append("<tr><td>详情请登录浩方供应商门户<br>http://sp.hofan.cn/<br></td></tr><br>");  
//							respContent = respContent
//									+ "详情请登录浩方供应商门户http://sp.hofan.cn/进行订单查询与执行发货操作。";
							sb.append("</table></body>");
							String uuid = UUID.randomUUID().toString().replaceAll("-", "");
							File emptyjsp = FileUtil.createFile("/opt/soft/tomcat_weixin/webapps/orderdetail", ""+uuid+".jsp");
							boolean result = FileUtil.writeTxtFile(sb.toString(), emptyjsp);
							if (result) {
								//图文开始
								List<Article> articleList = new ArrayList<Article>(); 
								NewsMessage newsMessage = new NewsMessage(); 
								newsMessage.setToUserName(fromUserName);  
								newsMessage.setFromUserName(toUserName);  
								newsMessage.setCreateTime(new Date().getTime());  
								newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
								Article article = new Article();  
								article.setTitle("发货通知");  
								String number = all+"";
								article.setDescription("绑定账号: "+erpcode+"\n"
										+ "待发货: "+number+"\n\n"
										+ "更多详情请点击这里");  
	                            article.setPicUrl("http://weixin.hofan.cn/weixin/fahuo.jpg");  
								article.setUrl("http://weixin.hofan.cn/orderdetail/"+uuid+".jsp");  
								articleList.add(article);  
								// 设置图文消息个数  
								newsMessage.setArticleCount(articleList.size());  
								// 设置图文消息包含的图文集合  
								newsMessage.setArticles(articleList);  
								// 将图文消息对象转换成xml字符串  
								respMessage = MessageUtil.newsMessageToXml(newsMessage);
								return respMessage;
								//图文结束
							}
							
						}else if (!dao.hasOpenID(fromUserName)) {
							respContent = "请您进行账号绑定，绑定成功即可接收订单通知。\n<a href=\"http://weixin.hofan.cn/weixin/bind.jsp?openid="+fromUserName+"\">点击这里，立即绑定</a>";
						}else if (dao.openIdIsNotChecked(fromUserName)) {
							respContent = "请您进行账号绑定，绑定成功即可接收订单通知。\n<a href=\"http://weixin.hofan.cn/weixin/bind.jsp?openid="+fromUserName+"\">点击这里，立即绑定</a>";
						}else if (dao.openIdCheckedExpire(fromUserName)) {
							//重新发送邮政邮件
//							if(sendCheckEmail(fromUserName)){
								respContent = "请您进行账号绑定，绑定成功即可接收订单通知。\n<a href=\"http://weixin.hofan.cn/weixin/bind.jsp?openid="+fromUserName+"\">点击这里，立即绑定</a>";
//							}
						}
						
                    }else if (eventKey.equals("32")) {
                    	String resp = "Address：广东省深圳市南山区学苑大道1001号南山智园B1栋14-15F\n"
                    			+ "Tel: +86（755）-82837000\n"
                    			+ "Email：hofangys@hofan.cn\n"
                    			+ "QQ：2853879175、2853879163";
                    	TextMessage textMessage = new TextMessage();
    					textMessage.setToUserName(fromUserName);
    					textMessage.setFromUserName(toUserName);
    					textMessage.setCreateTime(new Date().getTime());
    					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
    					textMessage.setContent(resp);
    					respMessage = MessageUtil.textMessageToXml(textMessage);
    					return respMessage;
						
					}else if (eventKey.equals("31")) {
						String resp = "请您进行账号绑定，绑定成功即可接收订单通知。\n<a href=\"http://weixin.hofan.cn/weixin/bind.jsp?openid="+fromUserName+"\">点击这里，立即绑定</a>";
						TextMessage textMessage = new TextMessage();
						textMessage.setToUserName(fromUserName);
						textMessage.setFromUserName(toUserName);
						textMessage.setCreateTime(new Date().getTime());
						textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
						textMessage.setContent(resp);
						respMessage = MessageUtil.textMessageToXml(textMessage);
						return respMessage;
						
					}
				}
				
				TextMessage textMessage = new TextMessage();
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
				return respMessage;
			}
			
			if (dao.openIdIsChecked(fromUserName)) {
				if (StringUtils.trim(requestMap.get("Content")).equals("信息")) {
					//获取fromUserName对应的供应商最新信息,发微信图文信息
					List<Article> articleList = new ArrayList<Article>(); 
					NewsMessage newsMessage = new NewsMessage(); 
					newsMessage.setToUserName(fromUserName);  
	                newsMessage.setFromUserName(toUserName);  
	                newsMessage.setCreateTime(new Date().getTime());  
	                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
					
					Article article = new Article();  
                    article.setTitle("浩方电子商务");  
                    article.setDescription("信息中心\n工程部\n财务");  
                    article.setPicUrl("http://7qna9x.com1.z0.glb.clouddn.com/002.jpg");  
                    article.setUrl("http://sp.hofan.cn/");  
                    articleList.add(article);  
                    // 设置图文消息个数  
                    newsMessage.setArticleCount(articleList.size());  
                    // 设置图文消息包含的图文集合  
                    newsMessage.setArticles(articleList);  
                    // 将图文消息对象转换成xml字符串  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);
                    return respMessage;
				}
				TextMessage textMessage = new TextMessage();
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
				return respMessage;
			}else if (!dao.hasOpenID(fromUserName)) {
				/*
				if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
					String content = StringUtils.trim(requestMap.get("Content"));
					if (dao.hasCode(content)) {
						//把openid(fromUserName)存到该供应商编码的记录里去,并设置isCheck为"0",表示没有验证过
						dao.saveOpenID(content,fromUserName,0);
						//先给该供应商的邮箱发验证邮件,并进行提示
						if(sendCheckEmail(fromUserName)){
							respContent = "您的供应商编号为 "+content+" ，为了您的账号安全，系统将发送验证链接至您在浩方门户绑定的电子邮箱，有效时间10小时，请按照邮件提示完成验证。";
							//响应链接里需要(验证成功后设置isCheck为"1",表示通过验证)(超过30分钟失效,并设置isCheck为"2",表示验证超时)
						}
						//有可能发送失败吗??
					}else{
						//
						respContent = "您输入的供应商编号不正确，请重新输入：";
					}
				}else{
					//
					respContent = "供应商编号是文本类型，请重新输入：";
				}

			*/
				respContent = "您还没有进行账号绑定！";
			}else if (dao.openIdIsNotChecked(fromUserName)) {
				respContent = "您还没有完成账号绑定！";
			}else if (dao.openIdCheckedExpire(fromUserName)) {
				//重新发送邮政邮件
//				if(sendCheckEmail(fromUserName)){
					respContent = "您还没有完成账号绑定！";
//				}
			}

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			// 文本消息
//			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
//				String content = requestMap.get("Content");
//				if (EmotionUtil.isQQFace(content)) {
//					respContent = content+"  "+content+" "+EmotionUtil.emoji(0x1F4B0)+" "+EmotionUtil.emoji(0x1F6B2)+"\ue159";
//				}else{
//					respContent = "您发送的是文本！\n\n\n\n(*^__^*) 嘻嘻/呲牙……";
//				}
//			}
			// 图片消息
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
//				respContent = "您发送的是图片>=<！";
//			}
			// 地理位置消息
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
//				respContent = "您发送的是地理位置！";
//			}
			// 链接消息
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
//				respContent = "您发送的是链接！我再送你个新的链接吧,点<a href=\"http://baidu.com\">我要激情</a>\n"
//						+ "[呲牙] /呲牙 /::D";
//			}
			// 音频消息
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
//				respContent = "您发送的是音频<=>！";
//			}
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return respMessage;
	}

	/**
	 * 发送验证邮件
	 * @param fromUserName 
	 * @return
	 */
	private static boolean sendCheckEmail(String fromUserName) {
		String email = null;
		try {
			email = dao.getEmail(fromUserName);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		email = "jackhai6@163.com";
		email = "844870351@qq.com";
//		email = "lizhenhai@hofan.cn";
		StringBuffer sb = new StringBuffer("感谢您</br>");
//		sb.append("<a href=\"http://weixintesthai.sinaapp.com/ss?email=");
		sb.append("<a href=\"http://weixin.hofan.cn/weixin/checkemail.jsp?email=");
		sb.append(email);
		sb.append("\">点击完成账号绑定(此处待替换为二维码扫描)");
		sb.append(email);
		sb.append("</a>");
//		sb.append("");
		//发送邮件
		SendEmail.send(email, sb.toString());
		return true;
	}
	
	public static void main(String[] args) {
		sendCheckEmail("xxx");
	}
}
