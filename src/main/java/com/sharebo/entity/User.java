package com.sharebo.entity;

import java.io.Serializable;

/**
 * 用户表
 * @author zhuhaiyuan
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;// 用户主键
	private String password;// 密码
	private Long phoneNumber;// 手机号
	private String wechatId;// 微信唯一标识号
	private Integer sex;// 性别 0：未知、1：男、2：女
	private String city;// 城市
	private String province;//省份
	private String nickName;//微信昵称 
	private String headimgurl;//微信头像URL
	private String subscribe_time;//关注时间
	private Integer useCounts;//使用次数
	private String create_time;
	private Integer isDelete;
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getWechatId() {
		return wechatId;
	}
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(String subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public Integer getUseCounts() {
		return useCounts;
	}
	public void setUseCounts(Integer useCounts) {
		this.useCounts = useCounts;
	}
	public User() {
		super();
	}
	public User(String userId, String password, Long phoneNumber, String wechatId, Integer sex, String city,
			String province, String nickName, String headimgurl, String subscribe_time, Integer useCounts) {
		super();
		this.userId = userId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.wechatId = wechatId;
		this.sex = sex;
		this.city = city;
		this.province = province;
		this.nickName = nickName;
		this.headimgurl = headimgurl;
		this.subscribe_time = subscribe_time;
		this.useCounts = useCounts;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", phoneNumber=" + phoneNumber + ", wechatId="
				+ wechatId + ", sex=" + sex + ", city=" + city + ", province=" + province + ", nickName=" + nickName
				+ ", headimgurl=" + headimgurl + ", subscribe_time=" + subscribe_time + ", useCounts=" + useCounts
				+ ", create_time=" + create_time + ", isDelete=" + isDelete + "]";
	}
}
