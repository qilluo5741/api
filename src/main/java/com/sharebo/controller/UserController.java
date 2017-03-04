package com.sharebo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sharebo.entity.ResultInfo;
import com.sharebo.entity.User;
import com.sharebo.service.UserService;
import com.sharebo.util.EncrypAES;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userServer;
	/**
	 * user/addUser.do?password=123456&phoneNumber=13101089315&wechatId=889659768476532793
	 * @param user
	 * 添加用户信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="addUser",method=RequestMethod.POST)
    public ResultInfo addUser(User user){
		if(user.getWechatId()==null){
			//返回给请求者
			return new ResultInfo(3000,"请求参数为空");
		}
		//密码加密
		user.setPassword(EncrypAES.encryptToString(user.getPassword()));
		//判断用户是否关注（判断返回的userid）
		if(userServer.selectCountByWechatid(user.getWechatId())!=null){
			//修改信息
			try {
				if(userServer.updateUserinfoByUserid(user)>0){
					return new ResultInfo(200,"关注成功!");
				}
			} catch (Exception e) {
				//异常输出
				log.error("关注异常！");
				System.out.println("关注异常！！");
			}
		}else{
			try {
				//第一次关注执行添加
				if(userServer.addUserinfo(user)>0){
					return new ResultInfo(200,"关注成功!");
				}
			} catch (Exception e) {
				//异常输出
				log.error("关注异常！");
				System.out.println("关注异常！！");
			}
		}
		return new ResultInfo(2001,"操作异常！");
	}
	/**
	 * user/selectUserByUserId.do?userId=889659768476532797
	 * @param userid
	 * 根据userid查询个人信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="selectUserByUserId",method=RequestMethod.POST)
    public ResultInfo selectUserByUserId(String userId){
		if(userId==null){
			//返回给请求者
			return new ResultInfo(3000,"请求参数为空");
		}
		try {
			if(userServer.selectUserByUserId(userId)!=null){
				return new ResultInfo(200,"查询成功",userServer.selectUserByUserId(userId));
			}
		} catch (Exception e) {
			//异常输出
			log.error("查询异常！");
			System.out.println("查询异常！！");
		}
		return new ResultInfo(2001,"暂无数据！");
	}
	/**
	 * user/deleteUserByUserId.do?userId=889659768476532797
	 * @param userId
	 * 根据userid删除
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="deleteUserByUserId",method=RequestMethod.POST)
    public ResultInfo deleteUserByUserId(String userId){
		if(userId==null){
			//返回给请求者
			return new ResultInfo(3000,"请求参数为空");
		}
		try {
			if(userServer.deleteUserByUserId(userId)>0){
				return new ResultInfo(200,"删除成功");
			}
		} catch (Exception e) {
			//异常输出
			log.error("删除异常！");
			System.out.println("删除异常！！");
		}
		return new ResultInfo(2001,"操作频繁！");
	}
	/**
	 * user/updatePhoneNumberByWechatIdOrUserid.do?phoneNumber=13101089616&userId=889659768476532797&wechatId=889659768476532800
	 * 根据 微信唯一标识号，userid修改手机号码
	 * @param user
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="updatePhoneNumberByWechatIdOrUserid",method=RequestMethod.POST)
    public ResultInfo updatePhoneNumberByWechatIdOrUserid(User user){
		if(user.getPhoneNumber()==null && user.getWechatId()==null && user.getUserId()==null){
			//返回给请求者
			return new ResultInfo(3000,"请求参数为空");
		}
		//判断根据 微信唯一标识号，userid修改手机号码修改成功
		try {
			if(userServer.updatePhoneNumberByWechatIdOrUserid(user.getPhoneNumber(), user.getUserId(), user.getWechatId())>0){
				return new ResultInfo(200,"修改成功");
			}
		} catch (Exception e) {
			//异常输出
			log.error("修改异常！");
			System.out.println("修改异常！！");
		}
		return new ResultInfo(2001,"操作频繁！");
	}
	/**
	 * user/selectPhoneNumberisCarNoByuserId.do?userId=889659768476532797
	 * 根据手机号和默认车牌号，根据用户号
	 * @param userId
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="selectPhoneNumberisCarNoByuserId",method=RequestMethod.POST)
    public ResultInfo selectPhoneNumberisCarNoByuserId(String userId){
		if(userId==null){
			//返回给请求者
			return new ResultInfo(3000,"请求参数为空");
		}
		try {
			if(userServer.selectPhoneNumberAndCarNoByUserId(userId)!=null){
				return new ResultInfo(200,"成功",userServer.selectPhoneNumberAndCarNoByUserId(userId));
			}
		} catch (Exception e) {
			//异常输出
			log.error("查询异常！");
			System.out.println("查询异常！！");
		}
		return new ResultInfo(2001,"暂无数据！");
	}
}
