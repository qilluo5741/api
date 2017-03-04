package com.sharebo.entity;

import java.io.Serializable;

/**
 * 优惠券
 * @author zhuhaiyuan
 *
 */
public class Coupon implements Serializable{
	private static final long serialVersionUID = 1L;
	private String couponId; // 主键
	private String userId; // 用户外键
	private String orderId; // 订单外键
	private String number; // 优惠券码
	private String getTime; // 获取时间
	private String useTime; // 使用时间
	private String way; // 获得途径
	private String detail; // 明细。比如：这人是途径活动1获得，一个是三等奖一个是一等奖。这个奖不同就写在这里
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getGetTime() {
		return getTime;
	}
	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Coupon(String couponId, String userId, String orderId, String number, String getTime, String useTime,
			String way, String detail) {
		super();
		this.couponId = couponId;
		this.userId = userId;
		this.orderId = orderId;
		this.number = number;
		this.getTime = getTime;
		this.useTime = useTime;
		this.way = way;
		this.detail = detail;
	}
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", userId=" + userId + ", orderId=" + orderId + ", number=" + number
				+ ", getTime=" + getTime + ", useTime=" + useTime + ", way=" + way + ", detail=" + detail + "]";
	}
	

}
