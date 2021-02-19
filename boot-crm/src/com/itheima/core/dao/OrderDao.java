package com.itheima.core.dao;

import java.util.Date;
import java.util.List;

import com.itheima.core.po.Customer;
import com.itheima.core.po.Orders;

/**
 * 
 * @author YHY
 *	OderDao接口
 */
public interface OrderDao {
	 // 订单列表
		public List<Orders> selectOrderList(Orders order);
		// 客户数
		public Integer selectOrderListCount(Orders order);
		//创建订单
		public int createOrder(Orders order);
		// 删除客户
		int deleteOrder (Integer order_id);
		//查询所有订单selectAllOrder
		public List<Orders> selectAllOrder();
		//修改日期、经办人updateOrder
		public int updateOrder(Orders order);
		//根据id查询所有订单信息
		public Orders selectAllOrderById(Integer order_id);
		//根据id查订单最大日期
		public Date selectMaxDate(String name);
		//通过姓名查询所有订单
		public String selectAllOrderByName(String cust_name);
		
		
		
		

}
