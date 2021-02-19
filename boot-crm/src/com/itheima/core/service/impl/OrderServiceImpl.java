package com.itheima.core.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.common.utils.Page;
import com.itheima.core.dao.OrderDao;
import com.itheima.core.po.Customer;
import com.itheima.core.po.Orders;
import com.itheima.core.service.OrderService;
/**
 * 订单管理
 * @author YHY
 *
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	//依赖注入
	@Autowired
	private OrderDao orderDao;
	
	
	
	//通过顾客姓名查询订单列表
	@Override
	public Page<Orders> findCustomerList(Integer page, Integer rows, String custName) throws ParseException {
		
		//创建订单对象
		Orders order = new Orders();
		// 判断客户名称
		if(StringUtils.isNotBlank(custName)){
			order.setCust_name(custName);
		}	
		// 当前页
				order.setStart((page-1) * rows) ;
				// 每页数
				order.setRows(rows);
				// 查询客户列表
				List<Orders> orders = orderDao.selectOrderList(order);
				
				// 查询客户列表总记录数
				Integer count = orderDao.selectOrderListCount(order);
				// 创建Page返回对象
				Page<Orders> result = new Page<>();
				result.setPage(page);
				result.setRows(orders);
				result.setSize(rows);
				result.setTotal(count);
				return result;
			}


	//创建订单
	@Override
	public int createOrder(Orders order) {
		
		return orderDao.createOrder(order);
	}

	
	//删除订单
	@Override
	public int deleteOrder(Integer order_id) {
		
		return orderDao.deleteOrder(order_id);
	}

	//查询所有订单
	@Override
	public Page<Orders> selectAllOrder(Integer page, Integer rows) throws ParseException {
		//创建订单对象
				Orders order = new Orders();
				
				// 当前页
						order.setStart((page-1) * rows) ;
						// 每页数
						order.setRows(rows);
						// 查询客户列表
						List<Orders> orders = orderDao.selectAllOrder();
						
						// 查询客户列表总记录数
						Integer count = orderDao.selectOrderListCount(order);
						
						// 创建Page返回对象
						Page<Orders> result = new Page<>();
						result.setPage(page);
						result.setRows(orders);
						result.setSize(rows);
						result.setTotal(count);
						return result;
	}

	//修改日期、经办人
	@Override
	public int updateOrder(Orders order) {
		
		
		
		return orderDao.updateOrder(order);
	}

	//根据id查询订单信息
	@Override
	public Orders selectAllOrderById(Integer order_id) {
		return orderDao.selectAllOrderById(order_id);
	}


	@Override
	public Date selectMaxDate(String name) {
		
		return orderDao.selectMaxDate(name);
	}

	//通过姓名查询所有订单
	@Override
	public String selectAllOrderByName(String cust_name) {
		
		return orderDao.selectAllOrderByName(cust_name);
	}
		
		
	}


