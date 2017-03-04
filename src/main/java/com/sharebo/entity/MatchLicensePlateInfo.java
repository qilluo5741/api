package com.sharebo.entity;
/**
 * 匹配车牌
 * @author niewei
 *
 */
public class MatchLicensePlateInfo {
	private String orderId;//订单号
	private String carNo;//车牌号码
	private int similarity;//相似度
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public int getSimilarity() {
		return similarity;
	}
	public void setSimilarity(int notSimilarity) {
		this.similarity = notSimilarity;
	}
	public MatchLicensePlateInfo(String orderId, String carNo,
			int similarity) {
		super();
		this.orderId = orderId;
		this.carNo = carNo;
		this.similarity = similarity;
	}
	public MatchLicensePlateInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
