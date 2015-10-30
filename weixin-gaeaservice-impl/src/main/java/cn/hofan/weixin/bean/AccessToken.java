/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.weixin.bean;

/**
 * 
 * @author lizhenhai
 * @version $Id: AccessToken.java, v 0.1 2015年9月4日 下午5:06:27 lizhenhai Exp $
 */
public class AccessToken { 
    // 获取到的凭证  
    private String token;  
    // 凭证有效时间，单位：秒  
    private int expiresIn;  
  
    public String getToken() {  
        return token;  
    }  
  
    public void setToken(String token) {  
        this.token = token;  
    }  
  
    public int getExpiresIn() {  
        return expiresIn;  
    }  
  
    public void setExpiresIn(int expiresIn) {  
        this.expiresIn = expiresIn;  
    }

}
