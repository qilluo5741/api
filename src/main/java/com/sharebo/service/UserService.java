package com.sharebo.service;

import com.sharebo.entity.User;
import com.sharebo.entityDto.UserCarinfoDto;
/**
 * @author Administrator
 */
public interface UserService {
	//添加用户信息
	public int addUserinfo(User user);
	//验证用户是否已经存在
	public String selectCountByWechatid(String wechatId);
	//修改用户信息
	public int updateUserinfoByUserid(User user);
	//根据userid查询个人信息
	public User selectUserByUserId(String userId);
	//根据userid删除
	public int deleteUserByUserId(String userId);
	//根据 微信唯一标识号，userid修改手机号码
	public int updatePhoneNumberByWechatIdOrUserid(Long phoneNumber,String userId,String wechatId);
	//2、获得手机号和默认车牌号，根据用户号
	public UserCarinfoDto selectPhoneNumberAndCarNoByUserId(String userId);
}
