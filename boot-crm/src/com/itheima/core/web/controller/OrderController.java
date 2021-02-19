package com.itheima.core.web.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.DaysBetween;
import com.itheima.common.utils.Page;
import com.itheima.core.po.BaseDict;
import com.itheima.core.po.Customer;
import com.itheima.core.po.Orders;
import com.itheima.core.po.User;
import com.itheima.core.service.OrderService;
import com.itheima.core.service.impl.OrderServiceImpl;

/**
 * 订单的控制类
 * @author YHY
 *
 */
@Controller
public class OrderController {
	//依赖注入
	@Autowired
	private OrderService orderService;
	
	/**
	 * 订单列表
	 * @param page
	 * @param rows
	 * @param custName
	 * @param model
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/order/list.action")
	public String list(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer rows, 
			String custName,Model model,HttpSession session) throws ParseException {
		
		
		
		// 获取Session
		Customer cust=(Customer) session.getAttribute("CUSTOMER_SESSION");
		Page<Orders> orders = orderService.findCustomerList(page, rows, cust.getCust_name());
		
		//使用工具类计算现在和最大日期之间的天数
		Date maxdate = orderService.selectMaxDate(cust.getCust_name());
		int day = 0;
		if(maxdate!=null){
			day = DaysBetween.daysBetween(new Date(), maxdate);
			
		}
		model.addAttribute("day", day);
		model.addAttribute("page1", orders);
		//model.addAttribute("name", name);
		// 添加参数
		model.addAttribute("custName", custName);
		return "newCustomer";
	}
	
	//查询所有订单
	@RequestMapping(value = "/order/alllist.action")
	public String alllist(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer rows, 
			Model model,HttpSession session) throws ParseException {
		
		
		
		// 获取Session
		Customer cust=(Customer) session.getAttribute("CUSTOMER_SESSION");
		Page<Orders> orders = orderService.selectAllOrder(page, rows);
		model.addAttribute("page2", orders);
		return "orderManage";
	}
	
	
	/**
	 * 创建订单
	 */
	@RequestMapping("/order/create.action")
	@ResponseBody
	public String orderCreate(Orders order,HttpSession session) {
	    // 获取Session中的当前用户信息
	    Customer customer = (Customer) session.getAttribute("CUSTOMER_SESSION");
	    // 将当前用户id存储在客户对象中
	    order.setOrder_id(customer.getCust_id());;
	    // 执行Service层中的创建方法，返回的是受影响的行数
	    int rows= orderService.createOrder(order);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 删除订单
	 */
	@RequestMapping("/order/delete.action")
	@ResponseBody
	public String customerDelete(Integer order_id) {
	    int rows=orderService.deleteOrder(order_id);
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}
	
	
	/**
	 * 通过订单
	 */
	@RequestMapping("/order/update.action")
	@ResponseBody
	public String orderUpdate(int order_id, String order_operator) {
		Orders order=new Orders();
		order.setOrder_id(order_id);
		order.setOrder_operator(order_operator);
		order.setPay_date(new Date());
		Calendar cal=Calendar.getInstance();
		Orders ord=orderService.selectAllOrderById(order_id);
		Date MaxDate=orderService.selectMaxDate(ord.getCust_name());
		if(MaxDate!=null){
			cal.setTime(MaxDate);
			
			
		}else{
			cal.setTime(new Date());
		}
		
		if(ord.getPay_type().equals("包月")){
			cal.add(Calendar.MONTH, 1);
		}
		else if(ord.getPay_type().equals("包年")){
			cal.add(Calendar.YEAR, 1);
		}
		order.setDue_date(cal.getTime());
	    int rows=orderService.updateOrder(order);
	    
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}
	
	
	/**
	 * 取消订单
	 */
	@RequestMapping("/order/fail.action")
	@ResponseBody
	public String forbiddenOrder(int order_id, String order_operator) {
		Orders order=new Orders();
		order.setOrder_id(order_id);
	    int rows=orderService.updateOrder(order);
	    
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}




		
		
}
