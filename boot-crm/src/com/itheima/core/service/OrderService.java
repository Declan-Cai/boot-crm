package com.itheima.core.service;

import java.text.ParseException;
import java.util.Date;

import com.itheima.common.utils.Page;
import com.itheima.core.po.Customer;
import com.itheima.core.po.Orders;

public interface OrderService {
	
	//通过顾客姓名查询订单列表
	public Page<Orders> findCustomerList(Integer page, Integer rows, String custName) throws ParseException;
	//创建订单
	public int createOrder(Orders order);
	// 删除订单
	public int deleteOrder(Integer order_id);
	//查询所有订单
	public Page<Orders> selectAllOrder(Integer page, Integer rows) throws ParseException;
	//修改日期、经办人
	public int updateOrder(Orders order);
	//根据id查询所有订单信息
	public Orders selectAllOrderById(Integer order_id);
	//根据id查订单最大日期
	public Date selectMaxDate(String name);
	//通过姓名查询所有订单
	public String selectAllOrderByName(String cust_name);
}
