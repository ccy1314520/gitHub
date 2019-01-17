package com.zyz.empSys.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车: 商品项的集合
 */
public class ShoppingCart {

	// 商品项集合
	private List<CartItem> items = new ArrayList<>();

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
	/**
	 * 添加商品到购物车
	 * @param item
	 */
	public void addItem(CartItem item) {
		// 如果该商品已经存在于购物出, 则加1
		for (CartItem cartItem : items) {
			if(item.getPid().equals(cartItem.getPid())) {
				cartItem.setNumber(cartItem.getNumber() + item.getNumber());
				return;
			}
		}
		
		// 如果该商品没有存在于购物车, 则保存
		items.add(item);
	}
	
	/**
	 * 删除商品
	 * @param id
	 */
	public void delItem(Integer id) {
		for (CartItem cartItem : items) {
			Integer pid = cartItem.getPid();
			
			if(id==pid) {
				items.remove(cartItem);
				return;
			}
		}
	}

}
