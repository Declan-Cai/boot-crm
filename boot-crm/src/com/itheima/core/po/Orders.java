package com.itheima.core.po;

import java.util.Date;

public class Orders {
	int order_id;//订单编号
	String cust_name;//顾客姓名
	Date pay_date;//缴费时间
	Date due_date;//到期日期
	double order_cost;//费用
	String pay_type;//缴费类型
	String order_operator;//经办人
	private Integer start;            // 起始行
	private Integer rows;             // 所取行数
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public double getOrder_cost() {
		return order_cost;
	}
	public void setOrder_cost(double order_cost) {
		this.order_cost = order_cost;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public String getOrder_operator() {
		return order_operator;
	}
	public void setOrder_operator(String order_operator) {
		this.order_operator = order_operator;
	}
	
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	

}
