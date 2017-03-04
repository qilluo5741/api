package com.sharebo.mapper;

import org.apache.ibatis.annotations.Param;

import com.sharebo.entity.User;
import com.sharebo.entityDto.UserCarinfoDto;
/**
 * @author Administrator
 */
public interface UserMapper {
	//添加用户信息
	public int addUserinfo(User user);
	//验证用户是否已经存在同时返回userid供下次使用
	public String selectCountByWechatid(@Param("wechatId")String wechatId);
	//修改用户信息
	public int updateUserInfoByUserid(User user);
	//根据userid查询个人信息
	public User selectUserByUserId(@Param("userId")String userId);
	//根据userid删除
	public int deleteUserByUserId(@Param("userId")String userId);
	//根据 微信唯一标识号，userid修改手机号码
	public int updatePhoneNumberByWechatIdOrUserId(@Param("phoneNumber")Long phoneNumber,@Param("userId")String userId,@Param("wechatId")String wechatId);
	//2、根据手机号和默认车牌号，根据用户号
	public UserCarinfoDto selectPhoneNumberIsCarNoByUserId(@Param("userId")String userId);
}
