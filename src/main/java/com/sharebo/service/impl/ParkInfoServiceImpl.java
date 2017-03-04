package com.sharebo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharebo.mapper.ParkInfoMapper;
import com.sharebo.service.ParkInfoService;
import com.sharebo.util.HttpUtil;

import net.sf.json.JSONObject;

@Service
public class ParkInfoServiceImpl implements ParkInfoService{

	@Autowired
	ParkInfoMapper parkInfoMapper;
	
	
	@Override
	public Integer findAllCountsByParkId(String parkId) {
		String httpUrl = "http://localhost:8080/sharebodoc/community/getCommpsCount.do?commId=" + parkId;
		System.out.println(httpUrl);
		String res=HttpUtil.request_post(httpUrl, "");
		System.out.println(res);
		String result = JSONObject.fromObject(res).getString("result");
		result = JSONObject.fromObject(result).getString("PsCount");
		return Integer.valueOf(result);
	}

	@Override
	public Integer findShareCountsByParkId(String parkId) {
		return parkInfoMapper.findShareCountsByParkId(parkId);
	}
	
	

}
