package com.sharebo.mapper;

import org.apache.ibatis.annotations.Param;

import com.sharebo.entity.CarInfo;

/**
 * @author Administrator
 */
public interface CarInfoMapper {
	//添加车牌
	public int addCarInfo(CarInfo Car);
	//验证用户下该车牌是否已经存在
	public int selectCarNoByUserId(@Param("userId")String userId,@Param("carNo")String carNo);
	//根据userid修改车牌
	public int updateCarNoByUserId(@Param("userId")String userId,@Param("carNo")String carNo);
	//根据userid,车牌删除
	public int delectCarNoByUserId(@Param("userId")String userId,@Param("carNo")String carNo);
	//重置用户下该车牌是否默认
	public int updateResetIsDefaultByUserId(@Param("userId")String userId);
	//设置默认车牌号，根据用户号
	public int updateIsDefaultByUserId(@Param("carNo")String carNo,@Param("isDefault")Integer isDefault,@Param("userId")String userId);
}
