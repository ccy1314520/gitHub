package com.zyz.empSys.pojo;

import java.io.Serializable;

/**
 * 商品项, 就是购物车中的每一类商品
 */
@SuppressWarnings("serial")
public class CartItem implements Serializable{

	// 商品id
	private Integer pid;
	// 商品名称
	private String pname;
	// 购买数量
	private Integer number;
	// 商品单价
	private Double price;

	public CartItem() {
		super();
	}

	

	public CartItem(Integer pid, String pname, Integer number, Double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.number = number;
		this.price = price;
	}



	public Integer getPid() {
		return pid;
	}



	public void setPid(Integer pid) {
		this.pid = pid;
	}



	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}



	public Integer getNumber() {
		return number;
	}



	public void setNumber(Integer number) {
		this.number = number;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "CartItem [pid=" + pid + ", pname=" + pname + ", number=" + number + ", price=" + price + "]";
	}
}
