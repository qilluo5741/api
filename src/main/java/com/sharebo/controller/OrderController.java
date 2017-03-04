package com.sharebo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sharebo.entity.Order;
import com.sharebo.service.OrderService;
import com.sharebo.service.ParkInfoService;
import com.sharebo.util.HttpUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ParkInfoService parkInfoService;

	/**
	 * 设置订单的状态
	 * @param state
	 * @param orderId
	 */
	@RequestMapping("/setOrderStateById")
	@ResponseBody
	public Integer setOrderStateById(String orderId, String status){
		return orderService.setOrderStatus(orderId, status)?1:0;
	}
	
	/**
	 * 提供给接口库请求的改订单状态接口
	 * @param carNo
	 * @param parkId
	 * @param status
	 * http://localhost:8080/park_api/order/setOrderStateByCar.do?carNo=%E6%B5%99C12345&parkId=111222&status=ENTERED
	 */
	@RequestMapping("/setOrderStateByCar")
	@ResponseBody
	public Integer setOrderStateByCar(String carNo, String parkId, String status){
		return orderService.setOrderStatus(carNo, parkId, status)?1:0;
			
	}
	
	/**
	 * 判断是否为该停车场的预约车。
	 * @param carNo
	 * @param parkId
	 * @return
	 * http://localhost:8080/park_api/order/judgeIsOrderCar.do?parkId=111222&carNo=%E6%B5%99C12346
	 */
	@RequestMapping("/judgeIsOrderCar")
	@ResponseBody
	public Integer judgeIsOrderCar(String carNo, String parkId){
		return orderService.judgeIsOrderCar(carNo, parkId);
	}
	
	@RequestMapping("/findCountsByParkId")
	@ResponseBody
	public String findCountsByParkId(){
		String httpUrl = "http://localhost:8080/sharebodoc/community/getCommpsCount.do?commId=24602080450744070";
		System.out.println(httpUrl);
		String res=HttpUtil.request_post(httpUrl, "");
		System.out.println(res);
		String result = JSONObject.fromObject(res).getString("result");
		result = JSONObject.fromObject(result).getString("PsCount");
		return result;
	}
	
	/**
	 * 
	 * @param carNo
	 * @param phoneNumber
	 * @param parkId
	 * @param couponNumber
	 * @param orderTime
	 * @return
	 * http://localhost:8080/park_api/order/makeOrder.do?carNo=%E6%B5%99C12346&phoneNumber=12345678900&parkId=24602080450744070&couponNumber&orderTime=2017-02-28%2013%3A41%3A46
	 */
	@RequestMapping("/makeOrder")
	@ResponseBody
	public String makeOrder(String carNo, Long phoneNumber,String parkId,String couponNumber,String orderTime){
		// 判断是否有未支付的订单。有则返回不能预约
		if(orderService.isExistWatiPay()){
			return "noAllow";
		}
		// 判断是否有未支付的订单。有则返回不能预约
		if(orderService.isOrderedByCarNo(carNo, parkId)){
			return "youAlreadyHavaOrder";
		}
		// 判断该停车场剩余车位是否大于0
		if(parkInfoService.findAllCountsByParkId(parkId) <= 0){
			return "wuchewei";
		}
		// 判断空余车位数量是否还有剩余
		if(parkInfoService.findShareCountsByParkId(parkId) <= 0){
			return "noshare";
		}
		
		Order order = new Order();
		order.setCarNo(carNo);
		order.setCouponNumber(couponNumber);
		order.setPhone(phoneNumber);
		order.setUserId("001");
		order.setOrderTime(orderTime);
		order.setParkId(parkId);
		if(orderService.createOrder(order) == 1){
			return "sucess";
		}
		return "fail";
	}
	
	@RequestMapping("/findOrderById")
	@ResponseBody
	public String findOrderById(String orderId){
		orderService.findOrder(orderId);
		return "";
	}
	
	@RequestMapping("/findOrdersByNowUser")
	@ResponseBody
	public String findOrdersByNowUser(){
		JSONArray jsons = new JSONArray();
		List<Order> orders = orderService.findOrdersByNowUser();
		jsons.add(orders);
		return jsons.toString();
	}
	
	/**
	 * 未完成订单
	 * @return
	 */
	@RequestMapping("/findOrdersWithUnCom")
	@ResponseBody
	public String findOrdersWithUnCom(){
		JSONArray jsons = new JSONArray();
		List<Order> orders = orderService.findOrdersWithUnCom();
		jsons.add(orders);
		return jsons.toString();
	}
	
	/**
	 * 已完成订单
	 * @return
	 */
	@RequestMapping("/findOrdersWithCom")
	@ResponseBody
	public String findOrdersWithCom(){
		JSONArray jsons = new JSONArray();
		List<Order> orders = orderService.findOrdersWithCom();
		jsons.add(orders);
		return jsons.toString();
	}
	
	/**
	 * 取消订单接口
	 * 1、改变订单状态
	 * 2、向接口库发起修改停车场车位数量
	 * @param orderId
	 * @return
	 */
	public String cancleOrder(String orderId){
		return "";
	}
	
}
