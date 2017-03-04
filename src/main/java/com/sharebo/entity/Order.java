package com.sharebo.entity;

import java.io.Serializable;

/**
 * 订单表
 * 订单状态流程：
 * 1、已预约->已入场->已出场（待支付）->已支付
 * 2、已预约->已逾期
 * 3、已预约->已取消
 * 状态标准：
 * 已预约："ORDERED"
 * 已逾期："OVER_DUE"
 * 已取消："CANCLED"
 * 已入场："ENTERED"
 * 已出场（待支付）："WAIT_PAY"
 * 已支付 :"PAYED"
 * @author zhuhaiyuan
 *
 */
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	private String orderId; // 订单主键
	private String userId; // 用户外键
	private String parkId; // 停车场外键
	private String carNo; // 车牌号
	private Long phone; // 手机号码
	private String status; // 状态
	private String couponNumber; // 使用积分多少
	private Double fee; // 总费用
	private String createTime; // 订单生成时间
	private String beginTime; // 开始时间
	private String endTime; // 结束时间
	private String payTime; // 支付时间
	private String orderTime; // 预约时间点
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getParkId() {
		return parkId;
	}
	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(String couponNumber) {
		this.couponNumber = couponNumber;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public Order(String orderId, String userId, String parkId, String carNo, Long phone, String status,
			String couponNumber, Double fee, String createTime, String beginTime, String endTime, String payTime,
			String orderTime) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.parkId = parkId;
		this.carNo = carNo;
		this.phone = phone;
		this.status = status;
		this.couponNumber = couponNumber;
		this.fee = fee;
		this.createTime = createTime;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.payTime = payTime;
		this.orderTime = orderTime;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", parkId=" + parkId + ", carNo=" + carNo
				+ ", phone=" + phone + ", status=" + status + ", couponNumber=" + couponNumber + ", fee=" + fee
				+ ", createTime=" + createTime + ", beginTime=" + beginTime + ", endTime=" + endTime + ", payTime="
				+ payTime + ", orderTime=" + orderTime + "]";
	}
	
	
}
