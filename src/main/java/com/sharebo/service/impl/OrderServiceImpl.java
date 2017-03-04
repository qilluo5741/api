package com.sharebo.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharebo.entity.MatchLicensePlateInfo;
import com.sharebo.entity.Order;
import com.sharebo.mapper.OrderMapper;
import com.sharebo.service.OrderService;
import com.sharebo.util.MatchLicensePlateUtil;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderMapper orderMapper;
	
	@Autowired
	HttpSession session;
	
	private String frontStatus(String status){
		if(status.equals("CANCLED")){
			return "ORDERED";
		}else if(status.equals("OVER_DUE")){
			return "ORDERED";
		}else if(status.equals("ENTERED")){
			return "ORDERED";
		} else if(status.equals("WAIT_PAY")){
			return "ENTERED";
		} else if(status.equals("PAYED")){
			return "WAIT_PAY";
		}
		return "noFront";
	}
	
	private Boolean determineStatus(String oldStatus, String newStatus){
		if(newStatus.equals("CANCLED")){
			if(oldStatus.equals("ORDERED")){
				return true;
			}
		}else if(newStatus.equals("OVER_DUE")){
			if(oldStatus.equals("ORDERED")){
				return true;
			}
		}else if(newStatus.equals("ENTERED")){
			if(oldStatus.equals("ORDERED")){
				return true;
			}
		}else if(newStatus.equals("WAIT_PAY")){
			if(oldStatus.equals("ENTERED")){
				return true;
			}
		}else if(newStatus.equals("PAYED")){
			if(oldStatus.equals("WAIT_PAY")){
				return true;
			}
		} else if(newStatus.equals("ORDERED")){
			return true;
		}
		return false;
		
	}
	
	
	@Override
	public Boolean setOrderStatus(String orderId, String status) {
		Order order = findOrder(orderId);
		if (determineStatus(order.getStatus(), status)) {
			order.setStatus(status);
			orderMapper.saveOrder(order);
			return true;
		} else {
			return false;
		}
	}

	
	@Override
	public Boolean setOrderStatus(String carNo, String parkId, String status) {
		String frontStatus = frontStatus(status);
		System.out.println(frontStatus);
		if(!frontStatus.equals("noFront")){
			Order order = findOrder(carNo, parkId, frontStatus);
			System.out.println(order.toString());
			if(determineStatus(order.getStatus(), status)){
				order.setStatus(status);
				orderMapper.saveOrder(order);
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}

	@Override
	public Order findOrder(String carNo, String parkId, String status) {
		return orderMapper.findOrderByCar(carNo, parkId, status);
	}

	@Override
	public Order findOrder(String orderId) {
		return orderMapper.findOrderById(orderId);
	}

	@Override
	public Integer judgeIsOrderCar(String carNo, String parkId) {
		// 当查找失败时，则进行模糊匹配。
		if (orderMapper.judgeIsOrderCar(carNo, parkId) == 0) {
			System.out.println("service" + carNo);
			// 取得
			List<MatchLicensePlateInfo> mlps = orderMapper.getcarNosByParkAndStatus(parkId, "ORDERED");
			MatchLicensePlateInfo mlp = MatchLicensePlateUtil.calculate(mlps, carNo);
			if (mlp != null) {
				System.out.println("pipeihou" + mlp.getCarNo());
				carNo = mlp.getCarNo();
				return orderMapper.judgeIsOrderCar(carNo, parkId);
			} else {
				return 0;
			}
		} else {
			return 1;
		}
	}

	@Override
	public Integer createOrder(Order order) {
		return orderMapper.createOrder(order);
	}

	@Override
	public Boolean isExistWatiPay() {
//		String userId = session.getAttribute("userId").toString();
		String userId = "001";
		if(orderMapper.isExistWatiPay(userId) > 0){
			return true;
		}
		return false;
	}

	@Override
	public Boolean isOrderedByCarNo(String carNo, String parkId) {
		String userId = "001";
		if(orderMapper.isOrderedByCarNo(userId, carNo, parkId) > 0){
			return true;
		}
		return false;
	}

	@Override
	public List<Order> findOrdersByNowUser() {
		String userId = "001";
		return orderMapper.findOrdersByNowUser(userId);
	}

	@Override
	public List<Order> findOrdersWithCom() {
		String userId = "001";
		return orderMapper.findOrdersWithCom(userId);
	}

	@Override
	public List<Order> findOrdersWithUnCom() {
		String userId = "001";
		return orderMapper.findOrdersWithUnCom(userId);
	}
	
	
}
