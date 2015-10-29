/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.bean;

/**
 * 
 * @author lizhenhai
 * @version $Id: QueryResul.java, v 0.1 2015年10月16日 下午6:57:00 lizhenhai Exp $
 */
public class QueryResul {

	private String arrivelNum;
	private String totalNum;
	private String materialCode;
	private String billPostingTime;
	private String samplingResult;
	private String dealResult;
	private String purchaseResult;
	public String getArrivelNum() {
		return arrivelNum;
	}
	public void setArrivelNum(String arrivelNum) {
		this.arrivelNum = arrivelNum;
	}
	public String getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public String getBillPostingTime() {
		return billPostingTime;
	}
	public void setBillPostingTime(String billPostingTime) {
		this.billPostingTime = billPostingTime;
	}
	public String getSamplingResult() {
		return samplingResult;
	}
	public void setSamplingResult(String samplingResult) {
		this.samplingResult = samplingResult;
	}
	public String getDealResult() {
		return dealResult;
	}
	public void setDealResult(String dealResult) {
		this.dealResult = dealResult;
	}
	public String getPurchaseResult() {
		return purchaseResult;
	}
	public void setPurchaseResult(String purchaseResult) {
		this.purchaseResult = purchaseResult;
	}
	
}
