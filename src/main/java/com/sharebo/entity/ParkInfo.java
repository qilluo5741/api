package com.sharebo.entity;

import java.io.Serializable;

public class ParkInfo  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String parkId; // 主键
	private String parkName; // 停车场名字
	private String address; // 停车场地址
	private Double allowFee; // 闲时内价格
	private Double extraFee; // 非闲时内价格
	private String startTime = "00:00:00";; // 开始时间
	private String endTime = "24:00:00"; // 结束时间
	private Integer countType;  // 通过总车位数或者通过剩余车位
	private Double countAllow;// 允许车位数的方法，1、百分比。2、按直接数量
	private Integer counts; // 可用车位总数
	private Integer surCounts; // 剩余可用车位
	public String getParkId() {
		return parkId;
	}
	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getAllowFee() {
		return allowFee;
	}
	public void setAllowFee(Double allowFee) {
		this.allowFee = allowFee;
	}
	public Double getExtraFee() {
		return extraFee;
	}
	public void setExtraFee(Double extraFee) {
		this.extraFee = extraFee;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getCountType() {
		return countType;
	}
	public void setCountType(Integer countType) {
		this.countType = countType;
	}
	public Double getCountAllow() {
		return countAllow;
	}
	public void setCountAllow(Double countAllow) {
		this.countAllow = countAllow;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public Integer getSurCounts() {
		return surCounts;
	}
	public void setSurCounts(Integer surCounts) {
		this.surCounts = surCounts;
	}
	public ParkInfo(String parkId, String parkName, String address, Double allowFee, Double extraFee, String startTime,
			String endTime, Integer countType, Double countAllow, Integer counts, Integer surCounts) {
		super();
		this.parkId = parkId;
		this.parkName = parkName;
		this.address = address;
		this.allowFee = allowFee;
		this.extraFee = extraFee;
		this.startTime = startTime;
		this.endTime = endTime;
		this.countType = countType;
		this.countAllow = countAllow;
		this.counts = counts;
		this.surCounts = surCounts;
	}
	public ParkInfo() {
		super();
	}
	@Override
	public String toString() {
		return "ParkInfo [parkId=" + parkId + ", parkName=" + parkName + ", address=" + address + ", allowFee="
				+ allowFee + ", extraFee=" + extraFee + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", countType=" + countType + ", countAllow=" + countAllow + ", counts=" + counts + ", surCounts="
				+ surCounts + "]";
	}
}
