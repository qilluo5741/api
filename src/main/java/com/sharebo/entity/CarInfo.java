package com.sharebo.entity;

import java.io.Serializable;

public class CarInfo  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String carId; // 车牌主键
	private String carNo; // 车牌号
	private String userId; // 用户外键
	private Integer isDefault; // 是否为默认0非默认1默认
	private String carNickName; // 预留字段，车辆称呼
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public String getCarNickName() {
		return carNickName;
	}
	public void setCarNickName(String carNickName) {
		this.carNickName = carNickName;
	}
	public CarInfo(String carId, String carNo, String userId, Integer isDefault, String carNickName) {
		super();
		this.carId = carId;
		this.carNo = carNo;
		this.userId = userId;
		this.isDefault = isDefault;
		this.carNickName = carNickName;
	}
	public CarInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CarInfo [carId=" + carId + ", carNo=" + carNo + ", userId=" + userId + ", isDefault=" + isDefault
				+ ", carNickName=" + carNickName + "]";
	}
	
	
}
