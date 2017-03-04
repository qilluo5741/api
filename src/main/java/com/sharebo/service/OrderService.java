package com.sharebo.service;

import java.util.List;

import com.sharebo.entity.Order;

/**
 * 订单类方法接口
 * @author zhuhaiyuan
 *
 */
public interface OrderService {

	/**
	 * 根据订单ID设置订单状态
	 * @param orderId
	 * @param status
	 * @return
	 */
	public Boolean setOrderStatus(String orderId, String status);
	
	/**
	 * 根据车牌号，停车场ID修改订单状态
	 * @param carNo
	 * @param parkId
	 * @param status
	 * @return
	 */
	public Boolean setOrderStatus(String carNo, String parkId, String status);
	
	/**
	 * 根据车牌号，停车场ID查找订单
	 * @param carNo
	 * @param parkId
	 * @param status
	 * @return
	 */
	public Order findOrder(String carNo, String parkId, String status);
	
	/**
	 * 根据订单ID查找订单
	 * @param orderId
	 * @return
	 */
	public Order findOrder(String orderId);
	
	/**
	 * 判断是否为预约车
	 * @param carNo
	 * @param parkId
	 * @return
	 */
	public Integer judgeIsOrderCar(String carNo, String parkId);
	
	/**
	 * 创建订单
	 * @param order
	 * @return
	 */
	public Integer createOrder(Order order);
	
	/**
	 * 是否存在未支付状态的订单。用于在发起预约时，进行判断，有该状态的订单，则不允许发起预约
	 * @return
	 */
	public Boolean isExistWatiPay();
	
	/**
	 * 根据车牌号与停车场ID，查找该车在该停车场是否已经有未完成订单的预约
	 * @param carNo
	 * @param parkId
	 * @return
	 */
	public Boolean isOrderedByCarNo(String carNo, String parkId);
	
	/**
	 * 根据当前用户查找出所有订单
	 * @return
	 */
	public List<Order> findOrdersByNowUser();
	
	/**
	 * 根据当前用户查找已完成订单
	 * @return
	 */
	public List<Order> findOrdersWithCom();
	
	/**
	 * 根据当前用户查找未完成订单
	 * @return
	 */
	public List<Order> findOrdersWithUnCom();
}
