/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.bean.resp;

import java.util.List;

/**
 * 
 * @author lizhenhai
 * @version $Id: NewsMessage.java, v 0.1 2015年8月24日 下午3:56:03 lizhenhai Exp $
 */
public class NewsMessage extends BaseMessage {
	private int ArticleCount;
	private List<Article> Articles;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
	
}
