package com.sharebo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sharebo.entity.CarInfo;
import com.sharebo.entity.ResultInfo;
import com.sharebo.service.CarInfoService;

@Controller
@RequestMapping("/carinfo")
public class CarInfoController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CarInfoService carInfoServer;
	/**
	 * carinfo/addCarInfo.do?carNo=沪B99999&userId=889659768476532797
	 * @param car
	 * 添加车牌信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="addCarInfo",method=RequestMethod.POST)
    public ResultInfo addCarInfo(CarInfo car){
		if(car.getUserId()==null && car.getCarNo()==null){
			//返回给请求者
			return new ResultInfo(3000,"请求参数为空");
		}
		//验证该车牌对应的用户是否存在
		if(carInfoServer.selectCarNoByUserId(car.getUserId(),car.getCarNo())>0){
			return new ResultInfo(3001,"该车牌对应的用户已经存在！");
		}
		try {
			//新增车牌
			if(carInfoServer.addCarInfo(car)>0){
				return new ResultInfo(200,"新增车牌成功！");
			}
		} catch (Exception e) {
			//异常输出
			log.error("新增车牌异常！");
			System.out.println("新增车牌异常！！");
		}
		return new ResultInfo(3002,"请求繁忙！");
	}
	/**
	 * carinfo/updateCarInfo.do?carNo=沪B66964&userId=889659768476532797
	 * @param car
	 * 根据userid修改车牌 
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="updateCarInfo",method=RequestMethod.POST)
    public ResultInfo updateCarInfo(CarInfo car){
		if(car.getUserId()==null && car.getCarNo()==null){
			//返回给请求者
			return new ResultInfo(3000,"请求参数为空");
		}
		//修改车牌
		try {
			if(carInfoServer.updateCarNoByUserId(car.getUserId(),car.getCarNo())>0){
				return new ResultInfo(200,"修改车牌成功！");
			}
		} catch (Exception e) {
			//异常输出
			log.error("修改车牌异常！");
			System.out.println("修改车牌异常！！");
		}
		return new ResultInfo(3002,"请求繁忙！");
	}
	/**
	 * carinfo/deleteCarInfo.do?carNo=沪B66964&userId=889659768476532797
	 * @param car
	 * 根据userid,车牌删除
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="deleteCarInfo",method=RequestMethod.POST)
    public ResultInfo delectCarInfo(CarInfo car){
		if(car.getUserId()==null && car.getCarNo()==null){
			//返回给请求者
			return new ResultInfo(3000,"请求参数为空");
		}
		//修改车牌
		try {
			if(carInfoServer.deleteCarNoByUserId(car.getUserId(),car.getCarNo())>0){
				return new ResultInfo(200,"删除车牌成功！");
			}
		} catch (Exception e) {
			//异常输出
			log.error("删除车牌异常！");
			System.out.println("删除车牌异常！！");
		}
		return new ResultInfo(3003,"该车牌已经不存在了！");
	}
	/**
	 * carinfo/updateIsDefaultByUserId.do?userId=889659768476532797
	 * 设置默认车牌号，根据用户号
	 * @param car
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="updateIsDefaultByUserId",method=RequestMethod.POST)
    public ResultInfo updateIsDefaultByUserId(String userId,String carNo){
		if(userId==null && carNo==null){
			//返回给请求者
			return new ResultInfo(3000,"请求参数为空");
		}
		//是否为默认0非默认1默认
		try {
			//重置用户下该车牌是否默认
			carInfoServer.updateResetIsDefaultByUserId(userId);
			//设置默认车牌
			if(carInfoServer.updateIsDefaultByUserId(carNo,1,userId)>0){
				return new ResultInfo(200,"设置默认成功！");
			}
		} catch (Exception e) {
			//异常输出
			log.error("设置默认车牌异常！");
			System.out.println("设置默认车牌异常！！");
		}
		return new ResultInfo(3003,"该车牌已经删除，或者不存在！");
	}
}
