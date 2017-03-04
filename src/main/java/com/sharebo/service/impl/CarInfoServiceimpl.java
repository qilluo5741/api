package com.sharebo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sharebo.entity.CarInfo;
import com.sharebo.mapper.CarInfoMapper;
import com.sharebo.service.CarInfoService;

@Service
public class CarInfoServiceimpl implements CarInfoService {
	@Autowired
	private CarInfoMapper mapper;
	
	@Override
	public int addCarInfo(CarInfo Car) {
		return mapper.addCarInfo(Car);
	}

	@Override
	public int updateIsDefaultByUserId(String carNo,Integer isDefault, String userId) {
		return mapper.updateIsDefaultByUserId(carNo,isDefault, userId);
	}

	@Override
	public int updateResetIsDefaultByUserId(String userId) {
		return mapper.updateResetIsDefaultByUserId(userId);
	}

	@Override
	public int selectCarNoByUserId(String userId, String carNo) {
		return mapper.selectCarNoByUserId(userId, carNo);
	}

	@Override
	public int updateCarNoByUserId(String userId, String carNo) {
		return mapper.updateCarNoByUserId(userId, carNo);
	}

	@Override
	public int deleteCarNoByUserId(String userId, String carNo) {
		return mapper.delectCarNoByUserId(userId, carNo);
	}
}
