/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.main;

import cn.hofan.bean.AccessToken;
import cn.hofan.bean.Button;
import cn.hofan.bean.CommonButton;
import cn.hofan.bean.ComplexButton;
import cn.hofan.bean.Menu;
import cn.hofan.bean.ViewButton;
import cn.hofan.util.WeixinUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author lizhenhai
 * @version $Id: MenuManager.java, v 0.1 2015年9月7日 上午10:57:59 lizhenhai Exp $
 */
public class MenuManager {  
    private static Log log = LogFactory.getLog(MenuManager.class);
  
    public static void main(String[] args) {  
        // 第三方用户唯一凭证  
//      个人的:  String appId = "wxed2bdff5e888b041";  
        String appId = "wx514fa56faa4f60b6";  
        // 第三方用户唯一凭证密钥  
//      个人的:  String appSecret = "9c1978f2370e7fba0c925e61a897813a";  
        String appSecret = "a06cec8d677edd9484847ceee5208dd2";  
  
        // 调用接口获取access_token  
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);  
  
        if (null != at) {  
            // 调用接口创建菜单  
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());  
  
            // 判断菜单创建结果  
            if (0 == result)  
                log.info("菜单创建成功！");  
            else  
                log.info("菜单创建失败，错误码：" + result);  
        }  
    }  
  
    /** 
     * 组装菜单数据 
     *  
     * @return 
     */  
    private static Menu getMenu() {  
  
    	CommonButton btn31 = new CommonButton();  
        btn31.setName("账号绑定");  
        btn31.setType("click");  
        btn31.setKey("31");
        
        CommonButton btn32 = new CommonButton();  
        btn32.setName("联系我们");  
        btn32.setType("click");  
        btn32.setKey("32");
//        ViewButton btn32 = new ViewButton();  
//        btn32.setName("联系我们");  
//        btn32.setType("view");  
//        btn32.setUrl("http://weixin.hofan.cn/weixin/contact.html"); 
  
        ViewButton btn33 = new ViewButton();  
        btn33.setName("提点建议");  
        btn33.setType("view");  
        btn33.setUrl("http://weixin.hofan.cn/weixin/advice.jsp");  
  
        CommonButton mainBtn1 = new CommonButton();  
        mainBtn1.setName("订单查询");  
        mainBtn1.setType("click");  
        mainBtn1.setKey("10");  
  
        ViewButton mainBtn2 = new ViewButton();  
        mainBtn2.setName("入库查询");  
        mainBtn2.setType("view");
        mainBtn2.setUrl("http://weixin.hofan.cn/weixin/query.html");
  
        ComplexButton mainBtn3 = new ComplexButton();  
        mainBtn3.setName("更多服务");  
        mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33 });  
  
        /** 
         * 这是公众号目前的菜单结构，一级菜单下可能有二级菜单项<br> 
         */  
        Menu menu = new Menu();  
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });  
  
        return menu;  
    }

}
