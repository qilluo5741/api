package com.sharebo.service;

import com.sharebo.entity.CarInfo;

/**
 * @author Administrator
 */
public interface CarInfoService {
	//添加车牌
	public int addCarInfo(CarInfo Car);
	//验证用户下该车牌是否已经存在
	public int selectCarNoByUserId(String userId,String carNo);
	//根据userid修改车牌
	public int updateCarNoByUserId(String userId,String carNo);
	//根据userid,车牌删除
	public int deleteCarNoByUserId(String userId,String carNo);
	//重置用户下该车牌是否默认
	public int updateResetIsDefaultByUserId(String userId);
	//设置默认车牌号，根据用户号
	public int updateIsDefaultByUserId(String carNo,Integer isDefault,String userId);
}
