package com.sharebo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ParkInfoMapper {

	public Integer findShareCountsByParkId(@Param("parkId")String parkId);
}
