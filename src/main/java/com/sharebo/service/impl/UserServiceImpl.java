package com.sharebo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharebo.entity.User;
import com.sharebo.entityDto.UserCarinfoDto;
import com.sharebo.mapper.UserMapper;
import com.sharebo.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;
	@Override
	public int addUserinfo(User user) {
		return mapper.addUserinfo(user);
	}
	@Override
	public String selectCountByWechatid(String wechatId) {
		return mapper.selectCountByWechatid(wechatId);
	}
	@Override
	public int updateUserinfoByUserid(User user) {
		return mapper.updateUserInfoByUserid(user);
	}
	@Override
	public User selectUserByUserId(String userId) {
		return mapper.selectUserByUserId(userId);
	}
	@Override
	public int deleteUserByUserId(String userId) {
		return mapper.deleteUserByUserId(userId);
	}
	@Override
	public int updatePhoneNumberByWechatIdOrUserid(Long phoneNumber, String userId, String wechatId) {
		return mapper.updatePhoneNumberByWechatIdOrUserId(phoneNumber, userId, wechatId);
	}
	@Override
	public UserCarinfoDto selectPhoneNumberAndCarNoByUserId(String userId) {
		return mapper.selectPhoneNumberIsCarNoByUserId(userId);
	}
}
