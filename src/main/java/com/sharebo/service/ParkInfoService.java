package com.sharebo.service;

public interface ParkInfoService {

	/**
	 * 查找该停车场所有的剩余车位
	 * 防止停车场无空余车位
	 * @param parkId
	 * @return
	 */
	public Integer findAllCountsByParkId(String parkId);
	
	/**
	 * 查找该停车场提供的共享车位数是否还有剩余
	 * @param parkId
	 * @return
	 */
	public Integer findShareCountsByParkId(String parkId);
}
