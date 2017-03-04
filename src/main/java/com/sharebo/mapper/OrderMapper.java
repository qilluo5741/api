package com.sharebo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sharebo.entity.MatchLicensePlateInfo;
import com.sharebo.entity.Order;

@Mapper
public interface OrderMapper {
	
	public Integer judgeIsOrderCar(@Param("carNo") String carNo, @Param("parkId") String parkId);
	
	public List<MatchLicensePlateInfo> getcarNosByParkAndStatus(@Param("parkId")String parkId,@Param("status") String status);
	
	public Order findOrderById(@Param("orderId") String orderId);
	
	public Order findOrderByCar(@Param("carNo")String carNo,@Param("parkId") String parkId,@Param("status") String status);

	public Integer saveOrder(Order order);
	
	public Integer createOrder(Order order);
	
	public Integer isExistWatiPay(@Param("userId")String userId);
	
	public Integer isOrderedByCarNo(@Param("userId")String userId,@Param("carNo")String carNo,@Param("parkId") String parkId);
	
	public List<Order> findOrdersByNowUser(@Param("userId")String userId);
	
	public List<Order> findOrdersWithCom(@Param("userId")String userId);
	
	public List<Order> findOrdersWithUnCom(@Param("userId")String userId);
}

